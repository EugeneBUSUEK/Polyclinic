package ru.rsreu.polyclinic.database.dao.impl;

import com.prutzkow.resourcer.ProjectResourcer;
import ru.rsreu.polyclinic.data.*;
import ru.rsreu.polyclinic.database.ConnectionPool;
import ru.rsreu.polyclinic.database.dao.VacationRequestsDAO;
import ru.rsreu.polyclinic.util.BooleanUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VacationRequestsDAOImpl implements VacationRequestsDAO {

    private static volatile VacationRequestsDAOImpl instance;

    private static final String SELECT_DOCTOR_REQUESTS = ProjectResourcer.getInstance().getString("query.select.doctor.requests");
    private static final String UPDATE_DOCTOR_REQUEST = ProjectResourcer.getInstance().getString("query.update.doctor.request");
    private static final String DELETE_DOCTOR_REQUEST = ProjectResourcer.getInstance().getString("query.delete.doctor.request");


    @Override
    public RequestSet returnRequestsOfDoctor(Doctor doctor) {
        RequestSet requestSet = new RequestSet();
        requestSet.setDoctor(doctor);
        ResultSet rs = null;
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_DOCTOR_REQUESTS)) {
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                VacationRequest vacationRequest = new VacationRequest();
                vacationRequest.setId(rs.getLong(1));
                vacationRequest.setRequest(rs.getString(3));
                vacationRequest.setDate_from(rs.getString(4));
                vacationRequest.setDate_to(rs.getString(5));
                vacationRequest.setApproved(BooleanUtil.parseBoolean(rs.getInt(6)));
                requestSet.addRequest(vacationRequest);
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
            return requestSet;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return requestSet;
        }
    }

    @Override
    public void updateDoctorRequest(VacationRequest vacationRequest) {
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(UPDATE_DOCTOR_REQUEST)) {
            preparedStatement.setString(1, vacationRequest.getRequest());
            preparedStatement.setString(2, vacationRequest.getDate_from());
            preparedStatement.setString(3, vacationRequest.getDate_to());
            preparedStatement.setInt(4, BooleanUtil.convertToInt(vacationRequest.isApproved()));
            preparedStatement.setLong(5, vacationRequest.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteDoctorRequest(VacationRequest vacationRequest) {
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(DELETE_DOCTOR_REQUEST)) {
            preparedStatement.setLong(1, vacationRequest.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static VacationRequestsDAOImpl getInstance() {
        synchronized (VacationRequestsDAOImpl.class) {
            if (instance == null) {
                instance = new VacationRequestsDAOImpl();
            }
        }
        return instance;
    }
}
