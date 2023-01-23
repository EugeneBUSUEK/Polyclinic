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

public class CardRecordingsDAOImpl implements CardRecordingsDAO {
    private static volatile CardRecordingsDAOImpl instance;

    private static final String SELECT_PATIENT_RECORDINGS = ProjectResourcer.getInstance().getString("query.select.patient.recordings");


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

    public static CardRecordingsDAOImpl getInstance() {
        synchronized (CardRecordingsDAOImpl.class) {
            if (instance == null) {
                instance = new CardRecordingsDAOImpl();
            }
        }
        return instance;
    }
}
