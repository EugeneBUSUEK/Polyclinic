package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.User;
import ru.rsreu.polyclinic.database.dao.DAOFactory;
import ru.rsreu.polyclinic.database.dao.DoctorDetailsDAO;
import ru.rsreu.polyclinic.database.dao.UserDAO;
import ru.rsreu.polyclinic.util.BooleanUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static ru.rsreu.polyclinic.constant.Routes.SYS_ADMIN;

public class EditUserCommand extends FrontCommand{
    private UserDAO userDAO;
    private DoctorDetailsDAO doctorDetailsDAO;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

        userDAO = DAOFactory.getUserDAO();
        doctorDetailsDAO = DAOFactory.getDoctorDetailsDAO();
    }

    @Override
    public void send() throws ServletException, IOException {
        User user = new User();
        user.setId(Long.parseLong(request.getParameter("id")));
        user.setLogin(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setName(request.getParameter("name"));
        user.setRole(request.getParameter("role"));
//        user.setBlocked(Boolean.parseBoolean(request.getParameter("isBlocked")));
        if (request.getParameter("role").equals("Doctor")) {
            Doctor doctor = new Doctor();
            doctor.setUser(user);
            doctor.setSpecialization(request.getParameter("spec"));
            doctor.setCabinet(request.getParameter("cabinet"));
//            doctor.setInVacation(Boolean.parseBoolean(request.getParameter("inVacation")));
            this.userDAO.updateUser(user);
            this.doctorDetailsDAO.editDoctorDetails(doctor);
        } else {
            this.userDAO.updateUser(user);
        }

        redirect(SYS_ADMIN);
    }

    @Override
    public void process() throws ServletException, IOException {
        forward(SYS_ADMIN);

    }
}
