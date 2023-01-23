package ru.rsreu.polyclinic.database.dao.impl;

import com.prutzkow.resourcer.ProjectResourcer;
import ru.rsreu.polyclinic.data.*;
import ru.rsreu.polyclinic.database.ConnectionPool;
import ru.rsreu.polyclinic.database.dao.CardRecordingsDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CardRecordingsDAOImpl implements CardRecordingsDAO {
    private static volatile CardRecordingsDAOImpl instance;

    private static final String SELECT_PATIENT_RECORDINGS = ProjectResourcer.getInstance().getString("query.select.patient.recordings");
    private static final String INSERT_PATIENT_RECORD = ProjectResourcer.getInstance().getString("query.insert.patient.record");


    @Override
    public List<CardRecord> returnAllRecords() {
        return null;
    }

    @Override
    public List<CardRecord> returnPatientRecords(Patient patient) {
        List<CardRecord> cardRecordList = new ArrayList<>();
        ResultSet rs = null;
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_PATIENT_RECORDINGS)) {
            preparedStatement.setLong(1, patient.getId());
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                CardRecord cardRecord = new CardRecord();
                cardRecord.setId(rs.getLong(1));
                cardRecord.setPatient(patient);
                cardRecord.setDiagnosis(rs.getString(3));
                cardRecord.setTreatmentCourse(rs.getString(4));
                cardRecord.setTime(rs.getString(5));
                User user = new User();
                user.setName(rs.getString(6));
                Doctor doctor = new Doctor();
                doctor.setUser(user);
                doctor.setSpecialization(rs.getString(7));
                cardRecord.setDoctor(doctor);
                cardRecordList.add(cardRecord);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cardRecordList;
    }

    @Override
    public Optional<CardRecord> addRecord(CardRecord cardRecord) {
        String[] returnId = { "id" };
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(INSERT_PATIENT_RECORD, returnId)) {
            preparedStatement.setLong(1, cardRecord.getPatient().getId());
            preparedStatement.setString(2, cardRecord.getDiagnosis());
            preparedStatement.setString(3, cardRecord.getTreatmentCourse());
            preparedStatement.setString(4, cardRecord.getDoctor().getUser().getName());
            preparedStatement.setString(5, cardRecord.getDoctor().getSpecialization());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating record failed");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long id = generatedKeys.getLong(1);

                    cardRecord.setId(id);

                    return Optional.of(cardRecord);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    }

    public static CardRecordingsDAOImpl getInstance() {
        synchronized (CardRecordingsDAOImpl.class) {
            if (instance == null) {
                instance = new CardRecordingsDAOImpl();
            }
        }
        return instance;
    }
}
