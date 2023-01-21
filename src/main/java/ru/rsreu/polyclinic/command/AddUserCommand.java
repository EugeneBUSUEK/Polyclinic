package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.User;
import ru.rsreu.polyclinic.database.dao.DAOFactory;
import ru.rsreu.polyclinic.database.dao.DoctorDetailsDAO;
import ru.rsreu.polyclinic.database.dao.SessionsDAO;
import ru.rsreu.polyclinic.database.dao.UserDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.rsreu.polyclinic.constant.Routes.LOGIN;
import static ru.rsreu.polyclinic.constant.Routes.SYS_ADMIN;

public class AddUserCommand extends FrontCommand{
    private UserDAO userDAO;
    private DoctorDetailsDAO doctorDetailsDAO;
    private SessionsDAO sessionsDAO;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

        userDAO = DAOFactory.getUserDAO();
        doctorDetailsDAO = DAOFactory.getDoctorDetailsDAO();
        sessionsDAO = DAOFactory.getSessionsDAO();
    }

    @Override
    public void send() throws ServletException, IOException {
        User user = new User();
//        user.setId(Long.parseLong(request.getParameter("id")));
        user.setLogin(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setName(request.getParameter("name"));
        user.setRole(request.getParameter("role"));
//        user.setBlocked(Boolean.parseBoolean(request.getParameter("isBlocked")));
        User userAfter = this.userDAO.addUser(user).orElse(null);
        if (userAfter == null) {
            request.setAttribute("invalidAddUser", true);
            forward(SYS_ADMIN);
        } else {
            this.sessionsDAO.createSession(userAfter);
            if (request.getParameter("role").equals("doctor")) {
                Doctor doctor = new Doctor();
                doctor.setUser(userAfter);
                doctor.setSpecialization(request.getParameter("spec"));
                doctor.setCabinet(request.getParameter("cabinet"));
//            doctor.setInVacation(Boolean.parseBoolean(request.getParameter("inVacation")));
//                this.userDAO.addUser(user);
                this.doctorDetailsDAO.addDoctorDetails(doctor);
                redirect(SYS_ADMIN);
            } else {
                redirect(SYS_ADMIN);
            }
        }

    }

    @Override
    public void process() throws ServletException, IOException {
        forward(SYS_ADMIN);

    }
}
