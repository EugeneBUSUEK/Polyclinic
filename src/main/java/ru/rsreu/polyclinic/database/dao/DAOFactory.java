package ru.rsreu.polyclinic.database.dao;

import ru.rsreu.polyclinic.database.dao.impl.DoctorDetailsDAOImpl;
import ru.rsreu.polyclinic.database.dao.impl.SessionsDAOImpl;
import ru.rsreu.polyclinic.database.dao.impl.UserDAOImpl;

public final class DAOFactory {
    private DAOFactory() {
    }


    public static UserDAO getUserDAO() {
        return UserDAOImpl.getInstance();
    }

    public static DoctorDetailsDAO getDoctorDetailsDAO() {
        return DoctorDetailsDAOImpl.getInstance();
    }

    public static SessionsDAO getSessionsDAO() {
        return SessionsDAOImpl.getInstance();
    }

}
