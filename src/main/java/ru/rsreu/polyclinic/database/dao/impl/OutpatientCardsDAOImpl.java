package ru.rsreu.polyclinic.database.dao.impl;

import com.prutzkow.resourcer.ProjectResourcer;
import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.ModerTableRow;
import ru.rsreu.polyclinic.data.Patient;
import ru.rsreu.polyclinic.data.User;
import ru.rsreu.polyclinic.database.ConnectionPool;
import ru.rsreu.polyclinic.database.dao.OutpatientCardsDAO;
import ru.rsreu.polyclinic.util.BooleanUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OutpatientCardsDAOImpl implements OutpatientCardsDAO {

    private static volatile OutpatientCardsDAOImpl instance;

    private static final String SELECT_ALL_PATIENTS = ProjectResourcer.getInstance().getString("query.select.all.patients");
    private static final String UPDATE_PATIENT = ProjectResourcer.getInstance().getString("query.update.patient");
    private static final String INSERT_PATIENT = ProjectResourcer.getInstance().getString("query.insert.patient");
    private static final String DELETE_PATIENT_ID = ProjectResourcer.getInstance().getString("query.delete.patient");


    @Override
    public List<Patient> returnAllPatients() {
        List<Patient> rowsList= new ArrayList<>();
        ResultSet rs = null;
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_ALL_PATIENTS)) {
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setId(rs.getLong(1));
                patient.setName(rs.getString(2));
                patient.setGender(rs.getString(3));
                patient.setBirthDay(rs.getString(4));
                patient.setPhoneNumber(rs.getString(5));
                patient.setAddress(rs.getString(6));
                rowsList.add(patient);
            }
            return rowsList;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return rowsList;
        }
    }

    @Override
    public List<Doctor> returnAllUsersForAdminEdit() {
        return null;
    }

    @Override
    public void blockUser(User user) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        return Optional.empty();
    }

    @Override
    public void updatePatient(Patient patient) {
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(UPDATE_PATIENT)) {
            preparedStatement.setString(1, patient.getName());
            preparedStatement.setString(2, patient.getGender());
            preparedStatement.setString(3, patient.getBirthDay());
            preparedStatement.setString(4, patient.getPhoneNumber());
            preparedStatement.setString(5, patient.getAddress());
            preparedStatement.setLong(6, patient.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deletePatient(Patient patient) {
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(DELETE_PATIENT_ID)) {

            preparedStatement.setLong(1, patient.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Optional<Patient> addPatient(Patient patient) {
        String[] returnId = { "id" };
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(INSERT_PATIENT, returnId)) {
            preparedStatement.setString(1, patient.getName());
            preparedStatement.setString(2, patient.getGender());
            preparedStatement.setString(3, patient.getBirthDay());
            preparedStatement.setString(4, patient.getPhoneNumber());
            preparedStatement.setString(5, patient.getAddress());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating patient failed");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long id = generatedKeys.getLong(1);

                    patient.setId(id);

                    return Optional.of(patient);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    }

    public static OutpatientCardsDAOImpl getInstance() {
        synchronized (OutpatientCardsDAOImpl.class) {
            if (instance == null) {
                instance = new OutpatientCardsDAOImpl();
            }
        }
        return instance;
    }
}
