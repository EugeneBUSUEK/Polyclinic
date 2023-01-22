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


    @Override
    public RequestSet returnRequestsOfDoctor(Doctor doctor) {
        RequestSet requestSet = new RequestSet();
        requestSet.setDoctor(doctor);
        ResultSet rs = null;
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_DOCTOR_REQUESTS)) {
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                VacationRequest vacationRequest = new VacationRequest();
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

    public static VacationRequestsDAOImpl getInstance() {
        synchronized (VacationRequestsDAOImpl.class) {
            if (instance == null) {
                instance = new VacationRequestsDAOImpl();
            }
        }
        return instance;
    }
}
