package ru.rsreu.polyclinic.database.dao.impl;

import com.prutzkow.resourcer.ProjectResourcer;
import ru.rsreu.polyclinic.data.User;
import ru.rsreu.polyclinic.database.ConnectionPool;
import ru.rsreu.polyclinic.database.dao.SessionsDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SessionsDAOImpl implements SessionsDAO {

    private static volatile SessionsDAOImpl instance;

    private static final String UPDATE_USER_SESSION = ProjectResourcer.getInstance().getString("query.update.user.sessions");
    private static final String INSERT_USER_SESSION = ProjectResourcer.getInstance().getString("query.insert.user.sessions");
    private static final String UPDATE_USER_SESSION_SIGN_OUT = ProjectResourcer.getInstance().getString("query.update.user.sessions.signout");


    @Override
    public void updateSession(User user) {
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(UPDATE_USER_SESSION)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteSessionSignOut(User user) {
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(UPDATE_USER_SESSION_SIGN_OUT)) {
            preparedStatement.setLong(1, user.getId());
            preparedStatement.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void createSession(int id) {
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(INSERT_USER_SESSION)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }















    public static SessionsDAOImpl getInstance() {
        synchronized (SessionsDAOImpl.class) {
            if (instance == null) {
                instance = new SessionsDAOImpl();
            }
        }
        return instance;
    }
}
