package ru.rsreu.polyclinic.database.oracledao;

import com.prutzkow.resourcer.ProjectResourcer;
import ru.rsreu.polyclinic.data.User;
import ru.rsreu.polyclinic.database.ConnectionPool;
import ru.rsreu.polyclinic.database.dao.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OracleUserDAO implements UserDAO {

    private static final String SELECT_ALL_WORKERS = ProjectResourcer.getInstance().getString("query.select.all.workers");
    private static final String SELECT_WORKER_BY_ID = ProjectResourcer.getInstance().getString("query.select.worker.by.id");
    private static final String SELECT_WORKER_BY_LOGIN = ProjectResourcer.getInstance().getString("query.select.worker.by.login");
    private static final String UPDATE_WORKER = ProjectResourcer.getInstance().getString("query.update.worker");
    private static final String DELETE_WORKER = ProjectResourcer.getInstance().getString("query.delete.worker");
    private static final String INSERT_WORKER = ProjectResourcer.getInstance().getString("query.insert.worker");

    @Override
    public ArrayList<User> findAll() {
        ArrayList<User> users = new ArrayList<>();

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WORKERS);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                users.add(giveUser(rs));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return users;
    }

    @Override
    public User getUserById(int id) {

        User user = null;

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WORKER_BY_ID);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user = giveUser(rs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return user;
    }

    @Override
    public User getUserById(String id) {
        return getUserById(Integer.parseInt(id));
    }

    @Override
    public User getUserByLogin(String login) {
        User user = null;

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WORKER_BY_LOGIN);
            preparedStatement.setString(1, login);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user = giveUser(rs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return user;
    }

    @Override
    public void updateUser(User user) {
        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_WORKER);
            insertUser(preparedStatement, user);

            preparedStatement.setLong(6, user.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteUser(User user) {
        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_WORKER);
            preparedStatement.setLong(1, user.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addUser(User user) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_WORKER);

            insertUser(preparedStatement, user);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private User giveUser(ResultSet resultSet) throws SQLException {
        User worker = new User();

        worker.setId(resultSet.getLong("worker_id"));
        worker.setLogin(resultSet.getString("login"));
        worker.setPassword(resultSet.getString("password"));
//        worker.setRole(RoleType.getRole(resultSet.getInt("role_id")));
//        worker.setBlocked(NumericHelper.convertToBool(resultSet.getInt("blocked")));
//        worker.setStatusAuthorize(NumericHelper.convertToBool(resultSet.getInt("status")));

        return worker;
    }

    private void insertUser(PreparedStatement preparedStatement, User worker) throws SQLException {
        preparedStatement.setString(1, worker.getLogin());
        preparedStatement.setString(2, worker.getPassword());
//        preparedStatement.setInt(3, worker.getRole().getId());
//        preparedStatement.setInt(4, NumericHelper.convertToInt(worker.isBlocked()));
//        preparedStatement.setInt(5, NumericHelper.convertToInt(worker.isAuthorized()));
    }
}
