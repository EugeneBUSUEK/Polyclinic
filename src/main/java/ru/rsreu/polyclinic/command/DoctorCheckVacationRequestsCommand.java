package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.data.*;
import ru.rsreu.polyclinic.database.dao.DAOFactory;
import ru.rsreu.polyclinic.database.dao.DoctorDetailsDAO;
import ru.rsreu.polyclinic.database.dao.UserDAO;
import ru.rsreu.polyclinic.database.dao.VacationRequestsDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static ru.rsreu.polyclinic.constant.Routes.CHECK_VACATION_DETAILS;
import static ru.rsreu.polyclinic.constant.Routes.DOCTOR_CHECK_VACATIONS;

public class DoctorCheckVacationRequestsCommand extends FrontCommand{
    private UserDAO userDAO;
    private DoctorDetailsDAO doctorDetailsDAO;
    private VacationRequestsDAO vacationRequestsDAO;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

        userDAO = DAOFactory.getUserDAO();
        doctorDetailsDAO = DAOFactory.getDoctorDetailsDAO();
        vacationRequestsDAO = DAOFactory.getVacationRequestsDAO();
    }

    @Override
    public void send() throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Doctor doctor = new Doctor();
        doctor.setUser(user);
        List<RequestsTableRow> requestsList = this.vacationRequestsDAO.returnRequestsOfDoctor(doctor);
        session.setAttribute("doctorRequestList", requestsList);
        forward(DOCTOR_CHECK_VACATIONS);
    }

    @Override
    public void process() throws ServletException, IOException {
        forward(DOCTOR_CHECK_VACATIONS);
    }
}
