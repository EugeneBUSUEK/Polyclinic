package ru.rsreu.polyclinic.database;

import ru.rsreu.polyclinic.database.dao.DAOFactory;
import ru.rsreu.polyclinic.database.oracledao.OracleDAOFactory;

public enum DatabaseType {

    ORACLE {
        @Override
        public DAOFactory getDAOFactory() {
            return OracleDAOFactory.getInstance();
        }

    };

    public abstract DAOFactory getDAOFactory();

}
