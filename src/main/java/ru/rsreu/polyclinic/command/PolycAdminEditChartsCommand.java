package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.DoctorChart;
import ru.rsreu.polyclinic.data.Patient;
import ru.rsreu.polyclinic.database.dao.DAOFactory;
import ru.rsreu.polyclinic.database.dao.DoctorChartsDAO;
import ru.rsreu.polyclinic.database.dao.OutpatientCardsDAO;
import ru.rsreu.polyclinic.database.dao.UserDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ru.rsreu.polyclinic.constant.Routes.POLYC_ADMIN_EDIT_CHARTS;
import static ru.rsreu.polyclinic.constant.Routes.POLYC_ADMIN_EDIT_PATIENTS;

public class PolycAdminEditChartsCommand extends FrontCommand{
    private UserDAO userDAO;
    private DoctorChartsDAO doctorChartsDAO;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

        userDAO = DAOFactory.getUserDAO();
        doctorChartsDAO = DAOFactory.getDoctorChartsDAO();
    }

    @Override
    public void send() throws ServletException, IOException {
        List<Doctor> rs = this.userDAO.returnAllUsersForAdminEdit();
        List<DoctorChart> doctorCharts = new ArrayList<>();
        for (Doctor doctor : rs) {
            doctorCharts.add(this.doctorChartsDAO.returnDoctorCharts(doctor));
        }
        HttpSession session = request.getSession();
        session.setAttribute("listOfDoctorCharts", doctorCharts);
        forward(POLYC_ADMIN_EDIT_CHARTS);
    }

    @Override
    public void process() throws ServletException, IOException {
        forward(POLYC_ADMIN_EDIT_CHARTS);
    }
}
