package ru.rsreu.polyclinic.database.dao;

import ru.rsreu.polyclinic.database.dao.impl.*;

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

    public static OutpatientCardsDAO getOutpatientCardsDAO() {
        return OutpatientCardsDAOImpl.getInstance();
    }
    public static DoctorChartsDAO getDoctorChartsDAO() {
        return DoctorChartsDAOImpl.getInstance();
    }
    public static VacationRequestsDAO getVacationRequestsDAO() {
        return VacationRequestsDAOImpl.getInstance();
    }
    public static AppointmentsDAO getAppointmentsDAO() {
        return AppointmentsDAOImpl.getInstance();
    }
}
