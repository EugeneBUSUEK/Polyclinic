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

import static ru.rsreu.polyclinic.constant.Routes.DOCTOR_CHECK_APPOINTMENTS;
import static ru.rsreu.polyclinic.constant.Routes.PATIENT_CARD;

public class DoctorCheckCardCommand extends FrontCommand{
    private UserDAO userDAO;
    private DoctorDetailsDAO doctorDetailsDAO;
    private VacationRequestsDAO vacationRequestsDAO;
    private AppointmentsDAO appointmentsDAO;
    private CardRecordingsDAO cardRecordingsDAO;
    private OutpatientCardsDAO outpatientCardsDAO;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

        userDAO = DAOFactory.getUserDAO();
        doctorDetailsDAO = DAOFactory.getDoctorDetailsDAO();
        vacationRequestsDAO = DAOFactory.getVacationRequestsDAO();
        appointmentsDAO = DAOFactory.getAppointmentsDAO();
        cardRecordingsDAO = DAOFactory.getCardRecordingsDAO();
        outpatientCardsDAO = DAOFactory.getOutpatientCardsDAO();
    }

    @Override
    public void send() throws ServletException, IOException {
        HttpSession session = request.getSession();
        Long id = Long.parseLong(request.getParameter("patient_id"));
        Patient patient = this.outpatientCardsDAO.getPatientBId(id).orElse(null);
        List<CardRecord> records = this.cardRecordingsDAO.returnPatientRecords(patient);
        session.setAttribute("patientRecords", records);
        session.setAttribute("patientObj", patient);
        forward(PATIENT_CARD);
    }

    @Override
    public void process() throws ServletException, IOException {
        forward(PATIENT_CARD);
    }
}
