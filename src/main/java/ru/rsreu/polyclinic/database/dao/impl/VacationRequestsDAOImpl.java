package ru.rsreu.polyclinic.database.dao.impl;

import com.prutzkow.resourcer.ProjectResourcer;
import ru.rsreu.polyclinic.data.*;
import ru.rsreu.polyclinic.database.ConnectionPool;
import ru.rsreu.polyclinic.database.dao.VacationRequestsDAO;
import ru.rsreu.polyclinic.util.BooleanUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VacationRequestsDAOImpl implements VacationRequestsDAO {

    private static volatile VacationRequestsDAOImpl instance;

    private static final String SELECT_DOCTOR_REQUESTS = ProjectResourcer.getInstance().getString("query.select.doctor.requests");
    private static final String SELECT_ALL_REQUESTS = ProjectResourcer.getInstance().getString("query.select.all.requests");
    private static final String SELECT_ALL_REQUESTS_FOR_ADMIN = ProjectResourcer.getInstance().getString("query.select.all.requests.admin");
    private static final String UPDATE_DOCTOR_REQUEST = ProjectResourcer.getInstance().getString("query.update.doctor.request");
    private static final String DELETE_DOCTOR_REQUEST = ProjectResourcer.getInstance().getString("query.delete.doctor.request");
    private static final String INSERT_DOCTOR_REQUEST = ProjectResourcer.getInstance().getString("query.insert.doctor.request");


    @Override
    public RequestSet returnRequestsOfDoctorPolomani(Doctor doctor) {
        RequestSet requestSet = new RequestSet();
        requestSet.setDoctor(doctor);
        ResultSet rs = null;
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_DOCTOR_REQUESTS)) {
            preparedStatement.setLong(1, doctor.getUser().getId());
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
    public List<RequestsTableRow> returnRequestsOfDoctor(Doctor doctor) {
        List<RequestsTableRow> requestsTableRows = new ArrayList<>();
        ResultSet rs = null;
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_DOCTOR_REQUESTS)) {
            preparedStatement.setLong(1, doctor.getUser().getId());
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                RequestsTableRow row = new RequestsTableRow();
                row.setDoctor(doctor);
                row.setId(rs.getLong(1));
                row.setRequest(rs.getString(3));
                row.setDate_from(rs.getString(4));
                row.setDate_to(rs.getString(5));
                row.setApproved(BooleanUtil.parseBoolean(rs.getInt(6)));
                requestsTableRows.add(row);
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
            return requestsTableRows;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<RequestsTableRow> returnRequestsOfDoctorById(Long id) {
        List<RequestsTableRow> requestsTableRows = new ArrayList<>();
        ResultSet rs = null;
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_DOCTOR_REQUESTS)) {
            preparedStatement.setLong(1, id);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                RequestsTableRow row = new RequestsTableRow();
//                row.setDoctor(doctor);
                row.setId(rs.getLong(1));
                row.setRequest(rs.getString(3));
                row.setDate_from(rs.getString(4));
                row.setDate_to(rs.getString(5));
                row.setApproved(BooleanUtil.parseBoolean(rs.getInt(6)));
                requestsTableRows.add(row);
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
            return requestsTableRows;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<RequestsTableRow> returnAllRequests(List<Doctor> doctors) {
//        RequestSet requestSet = new RequestSet();
        List<RequestsTableRow> requestsTableRows = new ArrayList<>();
        ResultSet rs = null;
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_ALL_REQUESTS)) {
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                RequestsTableRow vacationRequest = new RequestsTableRow();
                vacationRequest.setId(rs.getLong(1));
                vacationRequest.setRequest(rs.getString(3));
                vacationRequest.setDate_from(rs.getString(4));
                vacationRequest.setDate_to(rs.getString(5));
                vacationRequest.setApproved(BooleanUtil.parseBoolean(rs.getInt(6)));
                for (Doctor doctor : doctors) {
                    if (doctor.getUser().getId() == rs.getLong(2)) {
                        vacationRequest.setDoctor(doctor);
                        break;
                    }
                }
                requestsTableRows.add(vacationRequest);
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
            return requestsTableRows;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return requestsTableRows;
        }
    }

    @Override
    public List<RequestsTableRow> returnAllRequestsForAdmin(List<Doctor> doctors) {
        List<RequestsTableRow> requestsTableRows = new ArrayList<>();
        ResultSet rs = null;
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_ALL_REQUESTS_FOR_ADMIN)) {
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                RequestsTableRow vacationRequest = new RequestsTableRow();
                vacationRequest.setId(rs.getLong(1));
                vacationRequest.setRequest(rs.getString(3));
                vacationRequest.setDate_from(rs.getString(4));
                vacationRequest.setDate_to(rs.getString(5));
                vacationRequest.setApproved(BooleanUtil.parseBoolean(rs.getInt(6)));
                for (Doctor doctor : doctors) {
                    if (doctor.getUser().getId() == rs.getLong(2)) {
                        vacationRequest.setDoctor(doctor);
                        break;
                    }
                }
                requestsTableRows.add(vacationRequest);
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
            return requestsTableRows;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return requestsTableRows;
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
    public Optional<RequestsTableRow> addDoctorRequest(RequestsTableRow requestsTableRow) {
        String[] returnId = { "id" };
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(INSERT_DOCTOR_REQUEST, returnId)) {
            preparedStatement.setLong(1, requestsTableRow.getDoctor().getUser().getId());
            preparedStatement.setString(2, requestsTableRow.getRequest());
            preparedStatement.setString(3, requestsTableRow.getDate_from());
            preparedStatement.setString(4, requestsTableRow.getDate_to());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating vacation failed");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long id = generatedKeys.getLong(1);

                    requestsTableRow.setId(id);

                    return Optional.of(requestsTableRow);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
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
