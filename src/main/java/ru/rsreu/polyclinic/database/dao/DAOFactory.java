package ru.rsreu.polyclinic.database.dao;

import ru.rsreu.polyclinic.database.dao.impl.UserDAOImpl;

public final class DAOFactory {
    private DAOFactory() {
    }


    public static UserDAO getUserDAO() {
        return UserDAOImpl.getInstance();
    }

}
