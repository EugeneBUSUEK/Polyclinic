package ru.rsreu.polyclinic.database.dao.impl;

import com.prutzkow.resourcer.ProjectResourcer;
import ru.rsreu.polyclinic.data.User;
import ru.rsreu.polyclinic.database.ConnectionPool;
import ru.rsreu.polyclinic.database.dao.UserDAO;
import ru.rsreu.polyclinic.util.BooleanUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {

    private static volatile UserDAOImpl instance;

    private static final String SELECT_ALL_WORKERS = ProjectResourcer.getInstance().getString("query.select.all.workers");
    private static final String SELECT_ALL_USERS = ProjectResourcer.getInstance().getString("query.select.user.list");
    private static final String SELECT_WORKER_BY_ID = ProjectResourcer.getInstance().getString("query.select.worker.by.id");
    private static final String SELECT_USER_BY_LOGIN = ProjectResourcer.getInstance().getString("query.select.user.by.login");
    private static final String UPDATE_WORKER = ProjectResourcer.getInstance().getString("query.update.worker");
    private static final String DELETE_WORKER = ProjectResourcer.getInstance().getString("query.delete.worker");
    private static final String INSERT_WORKER = ProjectResourcer.getInstance().getString("query.insert.worker");


    @Override
    public List<List<String>> returnAllUsers() {
        List<List<String>> rowsList= new ArrayList<>();
        ResultSet rs = null;
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_ALL_USERS)) {
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                List<String> row = new ArrayList<>();
                for (int i = 1; i <= 5; i++) {
                    row.add(rs.getString(i));

                }
                rowsList.add(row);
            }
            return rowsList;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return rowsList;
        }

    }

    @Override
    public List<User> findAll() {
        ArrayList<User> users = new ArrayList<>();

        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_ALL_WORKERS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                users.add(getUserFromResulSet(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return users;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_WORKER_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = getUserFromResulSet(rs);

                return Optional.of(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Optional.empty();
    }



    @Override
    public Optional<User> getUserByLogin(String login) {
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_USER_BY_LOGIN)) {

            preparedStatement.setString(1, login);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = getUserFromResulSet(rs);

                return Optional.of(user);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void updateUser(User user) {
//        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(UPDATE_WORKER)) {
//            preparedStatement.setString(1, user.getLogin());
//            preparedStatement.setString(2, user.getPassword());
//            preparedStatement.setString(3, user.getName());
//            preparedStatement.setInt(4, BooleanUtil.convertToInt(user.isBlocked()));
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
    }

    @Override
    public void deleteUser(User user) {
//        try (Connection connection = ConnectionPool.getConnection()) {
//
//            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_WORKER);
//            preparedStatement.setLong(1, user.getId());
//
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
    }

    @Override
    public Optional<User> addUser(User user) {
        String[] returnId = { "id" };
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(INSERT_WORKER, returnId)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long id = generatedKeys.getLong(1);

                    user.setId(id);

                    return Optional.of(user);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    }

    private User getUserFromResulSet(ResultSet resultSet) throws SQLException {
        User user = new User();

        user.setId(resultSet.getLong("id"));
        user.setLogin(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setName(resultSet.getString("name"));
        user.setBlocked(resultSet.getBoolean("blocked"));
        user.setRole(resultSet.getString(6));

        return user;
    }




    public static UserDAOImpl getInstance() {
        synchronized (UserDAOImpl.class) {
            if (instance == null) {
                instance = new UserDAOImpl();
            }
        }
        return instance;
    }
}
