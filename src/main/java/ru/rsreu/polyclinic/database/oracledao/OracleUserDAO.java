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
    public User getUserById(Long id) {

        User user = null;

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WORKER_BY_ID);
            preparedStatement.setLong(1, id);

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
        return getUserById(Long.parseLong(id));
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

//            preparedStatement.setLong(6, user.getId());

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
        User user = new User();

        user.setId(resultSet.getLong("id"));
        user.setLogin(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
//        user.setBlocked(NumericHelper.convertToBool(resultSet.getInt("blocked")));

        return user;
    }

    private void insertUser(PreparedStatement preparedStatement, User user) throws SQLException {
        preparedStatement.setString(1, user.getLogin());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getName());
//        preparedStatement.setInt(4, NumericHelper.convertToInt(user.isBlocked()));
    }
}
