package ru.rsreu.polyclinic.database.oracledao;

import ru.rsreu.polyclinic.database.dao.DAOFactory;
import ru.rsreu.polyclinic.database.dao.UserDAO;

public class OracleDAOFactory extends DAOFactory {

    private static volatile OracleDAOFactory instance;

    private OracleDAOFactory() {

    }
    public static OracleDAOFactory getInstance() {
        synchronized (OracleDAOFactory.class) {
            if (instance == null) {
                instance = new OracleDAOFactory();
            }
        }
        return instance;
    }

    @Override
    public UserDAO getUserDAO() {
        return new OracleUserDAO();
    }

    /*
    @Override
    public RoleDAO getRoleDAO() {
        return new OracleRoleDAO();
    }

    @Override
    public DeviceDAO getDeviceDAO() {
        return new OracleDeviceDAO();
    }



    @Override
    public TenderDAO getTenderDAO() {
        return new OracleTenderDAO();
    }

     */

}

