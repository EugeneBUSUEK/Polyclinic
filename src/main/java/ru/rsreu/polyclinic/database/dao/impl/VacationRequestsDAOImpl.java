package ru.rsreu.polyclinic.database.dao.impl;

import ru.rsreu.polyclinic.database.dao.VacationRequestsDAO;

public class VacationRequestsDAOImpl implements VacationRequestsDAO {

    private static volatile VacationRequestsDAOImpl instance;





    public static VacationRequestsDAOImpl getInstance() {
        synchronized (VacationRequestsDAOImpl.class) {
            if (instance == null) {
                instance = new VacationRequestsDAOImpl();
            }
        }
        return instance;
    }
}
