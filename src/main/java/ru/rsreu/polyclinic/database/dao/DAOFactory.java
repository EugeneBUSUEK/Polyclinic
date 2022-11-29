package ru.rsreu.polyclinic.database.dao;

import ru.rsreu.polyclinic.database.DatabaseType;

public abstract class DAOFactory {

    public static DAOFactory getInstance(DatabaseType type) {
        return type.getDAOFactory();
    }

    public abstract UserDAO getUserDAO();
//    public abstract RoleDAO getRoleDAO();
//
//    public abstract DeviceDAO getDeviceDAO();
//
//
//
//    public abstract TenderDAO getTenderDAO();
}