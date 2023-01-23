package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.data.Appointment;
import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.User;
import ru.rsreu.polyclinic.database.dao.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static ru.rsreu.polyclinic.constant.Routes.DOCTOR_CHECK_APPOINTMENTS;

public class DoctorCheckCardCommand extends FrontCommand{
    private UserDAO userDAO;
    private DoctorDetailsDAO doctorDetailsDAO;
    private VacationRequestsDAO vacationRequestsDAO;
    private AppointmentsDAO appointmentsDAO;
    private CardRecordingsDAO cardRecordingsDAO;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

        userDAO = DAOFactory.getUserDAO();
        doctorDetailsDAO = DAOFactory.getDoctorDetailsDAO();
        vacationRequestsDAO = DAOFactory.getVacationRequestsDAO();
        appointmentsDAO = DAOFactory.getAppointmentsDAO();
        cardRecordingsDAO = DAOFactory.getCardRecordingsDAO();
    }

    @Override
    public void send() throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Doctor doctor = this.doctorDetailsDAO.returnDoctor(user);
        List<Appointment> appointments = this.appointmentsDAO.returnAppointmentsForDoctor(doctor);
        session.setAttribute("appointmentsDoctor", appointments);
        forward(DOCTOR_CHECK_APPOINTMENTS);
    }

    @Override
    public void process() throws ServletException, IOException {
        forward(DOCTOR_CHECK_APPOINTMENTS);
    }
}
