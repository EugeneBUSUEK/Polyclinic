package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.RequestSet;
import ru.rsreu.polyclinic.data.User;
import ru.rsreu.polyclinic.data.VacationRequest;
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

import static ru.rsreu.polyclinic.constant.Routes.CHECK_VACATION_DETAILS;
import static ru.rsreu.polyclinic.constant.Routes.POLYC_ADMIN_CHECK_VACATIONS;

public class CheckVacationDetailsCommand extends FrontCommand{
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
        RequestSet rs = new RequestSet();
        User user = new User();
        user.setId(Long.parseLong(request.getParameter("id")));
        user.setName(request.getParameter("name"));
        Doctor doctor = this.doctorDetailsDAO.returnDoctor(user);
        RequestSet requestSet = this.vacationRequestsDAO.returnRequestsOfDoctor(doctor);
        for (VacationRequest req : requestSet.getVacationRequestList()) {
            if (req.getId() == Long.parseLong(request.getParameter("vacation_id"))) {
                rs.setDoctor(doctor);
                rs.getVacationRequestList().add(req);
                break;
            }
        }
        HttpSession session = request.getSession();
        session.setAttribute("requestDetails", rs);
        forward(CHECK_VACATION_DETAILS);
    }

    @Override
    public void process() throws ServletException, IOException {
        forward(CHECK_VACATION_DETAILS);
    }
}
