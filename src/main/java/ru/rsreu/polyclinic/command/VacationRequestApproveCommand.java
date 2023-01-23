package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.RequestSet;
import ru.rsreu.polyclinic.data.RequestsTableRow;
import ru.rsreu.polyclinic.data.User;
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
import java.util.ArrayList;
import java.util.List;

import static ru.rsreu.polyclinic.constant.Routes.*;

public class VacationRequestApproveCommand extends FrontCommand{
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
        List<User> users = this.userDAO.returnAllUsers();
        List<Doctor> doctors = new ArrayList<>();
        for (User user : users) {
            doctors.add(this.doctorDetailsDAO.returnDoctor(user));
        }
        List<RequestsTableRow> requestSetList = this.vacationRequestsDAO.returnAllRequests(doctors);
        HttpSession session = request.getSession();
        session.setAttribute("listOfRequestSet", requestSetList);
        redirect(POLYC_ADMIN_CHECK_VACATIONS);
    }

    @Override
    public void process() throws ServletException, IOException {
        forward(POLYC_ADMIN_CHECK_VACATIONS);
    }
}
