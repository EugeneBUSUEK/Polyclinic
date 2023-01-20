package ru.rsreu.polyclinic.database.dao.impl;

import com.prutzkow.resourcer.ProjectResourcer;
import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.database.ConnectionPool;
import ru.rsreu.polyclinic.database.dao.DoctorDetailsDAO;
import ru.rsreu.polyclinic.util.BooleanUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DoctorDetailsDAOImpl implements DoctorDetailsDAO {

    private static volatile DoctorDetailsDAOImpl instance;

    private static final String UPDATE_DOCTOR_DETAILS = ProjectResourcer.getInstance().getString("query.update.doctor.details");

    @Override
    public void editDoctorDetails(Doctor doctor) {
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(UPDATE_DOCTOR_DETAILS)) {
            preparedStatement.setString(1, doctor.getSpecialization());
            preparedStatement.setString(2, doctor.getCabinet());
            preparedStatement.setInt(3, BooleanUtil.convertToInt(doctor.isInVacation()));
            preparedStatement.setLong(4, doctor.getUser().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }









    public static DoctorDetailsDAOImpl getInstance() {
        synchronized (DoctorDetailsDAOImpl.class) {
            if (instance == null) {
                instance = new DoctorDetailsDAOImpl();
            }
        }
        return instance;
    }
}
