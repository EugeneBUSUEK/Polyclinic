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

public class AppointmentsDAOImpl implements AppointmentsDAO {

    private static volatile AppointmentsDAOImpl instance;

    private static final String SELECT_DOCTOR_APPOINTMENTS = ProjectResourcer.getInstance().getString("query.select.doctor.appointments");
    private static final String DELETE_APPOINTMENT = ProjectResourcer.getInstance().getString("query.delete.appointment");

    @Override
    public List<Appointment> returnAppointmentsForDoctor(Doctor doctor) {
        List<Appointment> appointmentList = new ArrayList<>();
        ResultSet rs = null;
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_DOCTOR_APPOINTMENTS)) {
            preparedStatement.setLong(1, doctor.getUser().getId());
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Appointment appointment = new Appointment();
                Patient patient = new Patient();
                patient.setId(rs.getLong(2));
                patient.setName(rs.getString(6));
                appointment.setId(rs.getLong(1));
                appointment.setPatient(patient);
                appointment.setDoctor(doctor);
                appointment.setFromTime(rs.getString(4));
                appointment.setToTime(rs.getString(5));

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
