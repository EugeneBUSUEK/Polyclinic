package ru.rsreu.polyclinic.database.dao.impl;

import com.prutzkow.resourcer.ProjectResourcer;
import ru.rsreu.polyclinic.data.Appointment;
import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.Patient;
import ru.rsreu.polyclinic.data.RequestsTableRow;
import ru.rsreu.polyclinic.database.ConnectionPool;
import ru.rsreu.polyclinic.database.dao.AppointmentsDAO;
import ru.rsreu.polyclinic.util.BooleanUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppointmentsDAOImpl implements AppointmentsDAO {

    private static volatile AppointmentsDAOImpl instance;

    private static final String SELECT_DOCTOR_APPOINTMENTS = ProjectResourcer.getInstance().getString("query.select.doctor.appointments");
    private static final String DELETE_APPOINTMENT = ProjectResourcer.getInstance().getString("query.delete.appointment");
    private static final String INSERT_APPOINTMENT = ProjectResourcer.getInstance().getString("query.insert.appointment");

    @Override
    public List<Appointment> returnAppointmentsForDoctor(Doctor doctor) {
        List<Appointment> appointmentList = new ArrayList<>();
        ResultSet rs = null;
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_DOCTOR_APPOINTMENTS)) {
            preparedStatement.setLong(1, doctor.getUser().getId());
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setId(rs.getLong(1));
                Patient patient = new Patient();
                patient.setId(rs.getLong(2));
                appointment.setFromTime(rs.getString(4));
                appointment.setToTime(rs.getString(5));
                patient.setName(rs.getString(7));
                patient.setGender(rs.getString(8));
                patient.setBirthDay(rs.getString(9));
                patient.setPhoneNumber(rs.getString(10));
                patient.setAddress(rs.getString(11));
                appointment.setPatient(patient);
                appointment.setDoctor(doctor);

                appointmentList.add(appointment);
//                List<String> row = new ArrayList<>();
//                row.add(rs.getString(1));
//                row.add(rs.getString(2));
//                row.add(rs.getString(3));
//                row.add(Integer.toString(rs.getInt(4)));
//                row.add(rs.getString(5));
//                for (int i = 1; i <= 5; i++) {
//                    row.add(rs.getString(i));
//
//                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return appointmentList;
    }

    @Override
    public Optional<Appointment> addAppointment(Appointment appointment) {
        String[] returnId = { "id" };
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(INSERT_APPOINTMENT, returnId)) {
            preparedStatement.setLong(1, appointment.getPatient().getId());
            preparedStatement.setLong(2, appointment.getDoctor().getUser().getId());
            preparedStatement.setString(3, appointment.getFromTime());
            preparedStatement.setString(4, appointment.getToTime());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating appointment failed");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long id = generatedKeys.getLong(1);

                    appointment.setId(id);

                    return Optional.of(appointment);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteAppointment(Appointment appointment) {
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(DELETE_APPOINTMENT)) {
            preparedStatement.setLong(1, appointment.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static AppointmentsDAOImpl getInstance() {
        synchronized (AppointmentsDAOImpl.class) {
            if (instance == null) {
                instance = new AppointmentsDAOImpl();
            }
        }
        return instance;
    }

}
