package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.data.Appointment;
import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.Patient;
import ru.rsreu.polyclinic.data.User;
import ru.rsreu.polyclinic.database.dao.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static ru.rsreu.polyclinic.constant.Routes.POLYC_ADMIN_RECORD_PATIENT;
import static ru.rsreu.polyclinic.constant.Routes.POLYC_ADMIN_SET_APPOINTMENT;

public class SetAppointmentCommand extends FrontCommand{
    private UserDAO userDAO;
    private DoctorDetailsDAO doctorDetailsDAO;
    private OutpatientCardsDAO outpatientCardsDAO;
    private AppointmentsDAO appointmentsDAO;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

        userDAO = DAOFactory.getUserDAO();
        doctorDetailsDAO = DAOFactory.getDoctorDetailsDAO();

        outpatientCardsDAO = DAOFactory.getOutpatientCardsDAO();
        appointmentsDAO = DAOFactory.getAppointmentsDAO();
    }

    @Override
    public void send() throws ServletException, IOException {
//        User user = new User();
//        user.setId(Long.parseLong(request.getParameter("doctor_id")));
//        user.setName(request.getParameter("doctor_name"));
//        Doctor doctor = new Doctor();
//        doctor.setUser(user);
//        doctor.setSpecialization(request.getParameter("spec"));
//        Patient patient = new Patient();
//        patient.setId(Long.parseLong(request.getParameter("patient_id")));
//        patient.setName(request.getParameter("patient_name"));
//        patient.setPhoneNumber(request.getParameter("phone"));
//        List<Appointment> appointmentList = this.appointmentsDAO.returnAppointmentsForDoctor(doctor);
//
//        HttpSession session = request.getSession();
//        session.setAttribute("patient", patient);
//        session.setAttribute("doctor", doctor);
//        session.setAttribute("appointmentList", appointmentList);
//        forward(POLYC_ADMIN_SET_APPOINTMENT);
    }

    @Override
    public void process() throws ServletException, IOException {
        User user = new User();
        user.setId(Long.parseLong(request.getParameter("doctor_id")));
        user.setName(request.getParameter("doctor_name"));
        Doctor doctor = new Doctor();
        doctor.setUser(user);
        doctor.setSpecialization(request.getParameter("spec"));
        Patient patient = new Patient();
        patient.setId(Long.parseLong(request.getParameter("patient_id")));
        patient.setName(request.getParameter("patient_name"));
        patient.setPhoneNumber(request.getParameter("phone"));
        List<Appointment> appointmentList = this.appointmentsDAO.returnAppointmentsForDoctor(doctor);

        HttpSession session = request.getSession();
        session.setAttribute("patient", patient);
        session.setAttribute("doctor", doctor);
        session.setAttribute("appointmentList", appointmentList);
        forward(POLYC_ADMIN_SET_APPOINTMENT);
    }
}
