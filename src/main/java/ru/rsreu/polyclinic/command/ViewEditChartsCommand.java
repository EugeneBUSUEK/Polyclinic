package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.DoctorChart;
import ru.rsreu.polyclinic.data.User;
import ru.rsreu.polyclinic.database.dao.DAOFactory;
import ru.rsreu.polyclinic.database.dao.DoctorChartsDAO;
import ru.rsreu.polyclinic.database.dao.DoctorDetailsDAO;
import ru.rsreu.polyclinic.database.dao.UserDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ru.rsreu.polyclinic.constant.Routes.EDIT_CURRENT_CHART;
import static ru.rsreu.polyclinic.constant.Routes.POLYC_ADMIN_VIEW_EDIT_CHARTS;

public class ViewEditChartsCommand extends FrontCommand{
    private UserDAO userDAO;
    private DoctorDetailsDAO doctorDetailsDAO;
    private DoctorChartsDAO doctorChartsDAO;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

        userDAO = DAOFactory.getUserDAO();
        doctorDetailsDAO = DAOFactory.getDoctorDetailsDAO();
        doctorChartsDAO = DAOFactory.getDoctorChartsDAO();
    }

    @Override
    public void send() throws ServletException, IOException {
        User user = new User();
        user.setId(Long.parseLong(request.getParameter("id")));
        user.setName(request.getParameter("name"));
        Doctor doctor = new Doctor();
        doctor.setUser(user);
        DoctorChart doctorChart = this.doctorChartsDAO.returnDoctorCharts(doctor);
        HttpSession session = request.getSession();
        session.setAttribute("doctorChart", doctorChart);
        forward(EDIT_CURRENT_CHART);
    }



    @Override
    public void process() throws ServletException, IOException {
        forward(EDIT_CURRENT_CHART);
    }
}
