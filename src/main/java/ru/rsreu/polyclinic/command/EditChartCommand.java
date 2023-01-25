package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.DoctorChart;
import ru.rsreu.polyclinic.data.DoctorChartDay;
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

import static ru.rsreu.polyclinic.constant.Routes.*;

public class EditChartCommand extends FrontCommand{

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

//    @Override
//    public void send() throws ServletException, IOException {
//        List<Doctor> rs = this.userDAO.returnAllUsersForAdminEdit();
//        List<DoctorChart> doctorCharts = new ArrayList<>();
//        for (Doctor doctor : rs) {
//            doctorCharts.add(this.doctorChartsDAO.returnDoctorCharts(doctor));
//        }
//        HttpSession session = request.getSession();
//        session.setAttribute("listOfDoctorCharts", doctorCharts);
//        forward(POLYC_ADMIN_VIEW_EDIT_CHARTS);
//    }

    @Override
    public void send() throws ServletException, IOException {

        HttpSession session = request.getSession();
//        session.setAttribute("doctorIdForChart", Long.parseLong(request.getParameter("id")));
//        session.setAttribute("doctorNameForChart", request.getParameter("name"));

        User user = new User();
        user.setId(Long.parseLong(request.getParameter("id")));
        user.setName(request.getParameter("name"));
        session.setAttribute("userParams", user);

        DoctorChartDay doctorChartDay = new DoctorChartDay();
        doctorChartDay.setUser(user);
        doctorChartDay.setDayOfWeek(Integer.parseInt(request.getParameter("day")));
        doctorChartDay.setFromTime(request.getParameter("from_time")+":00");
        doctorChartDay.setToTime(request.getParameter("to_time")+":00");

        this.doctorChartsDAO.editDoctorCharts(doctorChartDay);
        redirect(EDIT_CURRENT_CHART_REDIRECT);
    }

    @Override
    public void process() throws ServletException, IOException {
//        forward(EDIT_CURRENT_CHART);
    }
}
