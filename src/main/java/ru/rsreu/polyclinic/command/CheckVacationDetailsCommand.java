package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.data.*;
import ru.rsreu.polyclinic.database.dao.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static ru.rsreu.polyclinic.constant.Routes.CHECK_VACATION_DETAILS;

public class CheckVacationDetailsCommand extends FrontCommand{
    private UserDAO userDAO;
    private DoctorDetailsDAO doctorDetailsDAO;
    private VacationRequestsDAO vacationRequestsDAO;
    private AppointmentsDAO appointmentsDAO;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

        userDAO = DAOFactory.getUserDAO();
        doctorDetailsDAO = DAOFactory.getDoctorDetailsDAO();
        vacationRequestsDAO = DAOFactory.getVacationRequestsDAO();
        appointmentsDAO = DAOFactory.getAppointmentsDAO();
    }

    @Override
    public void send() throws ServletException, IOException {
//        RequestSet rs = new RequestSet();
//        User user = new User();
//        user.setId(Long.parseLong(request.getParameter("id")));
//        user.setName(request.getParameter("name"));
//        Doctor doctor = this.doctorDetailsDAO.returnDoctor(user);
//        RequestSet requestSet = this.vacationRequestsDAO.returnRequestsOfDoctorPolomani(doctor);
//        for (VacationRequest req : requestSet.getVacationRequestList()) {
//            if (req.getId() == Long.parseLong(request.getParameter("vacation_id"))) {
//                rs.setDoctor(doctor);
//                rs.getVacationRequestList().add(req);
//                break;
//            }
//        }
//        //второй сет с аппонтментсами ------------------------------------
//        List<Appointment> appointments = this.appointmentsDAO.returnAppointmentsForDoctor(doctor);
//        HttpSession session = request.getSession();
//        session.setAttribute("requestDetails", rs);
//        session.setAttribute("doctorAppointments", appointments);
//        forward(CHECK_VACATION_DETAILS);
    }

    @Override
    public void process() throws ServletException, IOException {
        RequestSet rs = new RequestSet();
        User user = new User();
        user.setId(Long.parseLong(request.getParameter("id")));
        user.setName(request.getParameter("name"));
        Doctor doctor = this.doctorDetailsDAO.returnDoctor(user);
        RequestSet requestSet = this.vacationRequestsDAO.returnRequestsOfDoctorPolomani(doctor);
        for (VacationRequest req : requestSet.getVacationRequestList()) {
            if (req.getId() == Long.parseLong(request.getParameter("vacation_id"))) {
                rs.setDoctor(doctor);
                rs.getVacationRequestList().add(req);
                break;
            }
        }
        //второй сет с аппонтментсами ------------------------------------
        List<Appointment> appointments = this.appointmentsDAO.returnAppointmentsForDoctor(doctor);
        HttpSession session = request.getSession();
        session.setAttribute("requestDetails", rs);
        session.setAttribute("doctorAppointments", appointments);
        forward(CHECK_VACATION_DETAILS);
    }
}
