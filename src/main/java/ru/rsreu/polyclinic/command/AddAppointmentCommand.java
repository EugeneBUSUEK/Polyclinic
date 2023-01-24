package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.data.Appointment;
import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.Patient;
import ru.rsreu.polyclinic.data.User;
import ru.rsreu.polyclinic.database.dao.AppointmentsDAO;
import ru.rsreu.polyclinic.database.dao.DAOFactory;
import ru.rsreu.polyclinic.database.dao.OutpatientCardsDAO;
import ru.rsreu.polyclinic.enums.RoleType;
//import sun.jvm.hotspot.ui.EditableAtEndDocument;

import javax.print.Doc;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static ru.rsreu.polyclinic.constant.Routes.*;

public class AddAppointmentCommand extends FrontCommand{
    private AppointmentsDAO appointmentsDAO;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

        appointmentsDAO = DAOFactory.getAppointmentsDAO();
    }

    @Override
    public void send() throws ServletException, IOException {
        String date = request.getParameter("date");
        String timeFrom = request.getParameter("time_from");
        String timeTo = request.getParameter("time_to");
        User user = new User();
        user.setId(Long.parseLong(request.getParameter("doctor_id")));
        Doctor doctor = new Doctor();
        doctor.setUser(user);
        Patient patient = new Patient();
        patient.setId(Long.parseLong(request.getParameter("patient_id")));
        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setFromTime(date + " " + timeFrom);
        appointment.setToTime(date + " " + timeTo);
        Appointment appointmentAfter = this.appointmentsDAO.addAppointment(appointment).orElse(null);
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");
        if (appointmentAfter == null) {
            request.setAttribute("invalidAddAppointment", true);
            forward(PROFILE);
        } else if (currentUser.getRole().equals(RoleType.DOCTOR.getRole())) {
            redirect(PROFILE);
        } else {
            redirect(POLYC_ADMIN_RECORD_PATIENT);
        }

    }

    @Override
    public void process() throws ServletException, IOException {
        forward(POLYC_ADMIN_RECORD_PATIENT);
    }
}
