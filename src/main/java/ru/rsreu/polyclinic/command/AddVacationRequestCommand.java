package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.data.*;
import ru.rsreu.polyclinic.database.dao.DAOFactory;
import ru.rsreu.polyclinic.database.dao.OutpatientCardsDAO;
import ru.rsreu.polyclinic.database.dao.VacationRequestsDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static ru.rsreu.polyclinic.constant.Routes.DOCTOR_CHECK_VACATIONS;
import static ru.rsreu.polyclinic.constant.Routes.POLYC_ADMIN_EDIT_PATIENTS;

public class AddVacationRequestCommand extends FrontCommand{
    private VacationRequestsDAO vacationRequestsDAO;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

        vacationRequestsDAO = DAOFactory.getVacationRequestsDAO();
    }

    @Override
    public void send() throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Doctor doctor = new Doctor();
        doctor.setUser(user);
        RequestsTableRow doctorRequest = new RequestsTableRow();
        doctorRequest.setDoctor(doctor);
        doctorRequest.setRequest(request.getParameter("reason"));
        doctorRequest.setDate_from(request.getParameter("time_from"));
        doctorRequest.setDate_to(request.getParameter("time_to"));
        RequestsTableRow doctorRequestAfter = this.vacationRequestsDAO.addDoctorRequest(doctorRequest).orElse(null);
        if (doctorRequestAfter == null) {
            request.setAttribute("invalidAddVacation", true);
            forward(DOCTOR_CHECK_VACATIONS);
        } else {
            redirect(DOCTOR_CHECK_VACATIONS);
        }

    }

    @Override
    public void process() throws ServletException, IOException {
        forward(DOCTOR_CHECK_VACATIONS);

    }
}
