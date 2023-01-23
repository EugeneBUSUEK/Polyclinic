package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.data.CardRecord;
import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.Patient;
import ru.rsreu.polyclinic.data.User;
import ru.rsreu.polyclinic.database.dao.CardRecordingsDAO;
import ru.rsreu.polyclinic.database.dao.DAOFactory;
import ru.rsreu.polyclinic.database.dao.DoctorDetailsDAO;
import ru.rsreu.polyclinic.database.dao.OutpatientCardsDAO;

import javax.print.Doc;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static ru.rsreu.polyclinic.constant.Routes.*;

public class AddRecordCommand extends FrontCommand{
    private OutpatientCardsDAO outpatientCardsDAO;
    private CardRecordingsDAO cardRecordingsDAO;
    private DoctorDetailsDAO doctorDetailsDAO;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

        outpatientCardsDAO = DAOFactory.getOutpatientCardsDAO();
        cardRecordingsDAO = DAOFactory.getCardRecordingsDAO();
        doctorDetailsDAO = DAOFactory.getDoctorDetailsDAO();
    }

    @Override
    public void send() throws ServletException, IOException {
        HttpSession session = request.getSession();
        Patient patient = new Patient();
        patient.setId(Long.parseLong(request.getParameter("id")));
        CardRecord cardRecord = new CardRecord();
        cardRecord.setPatient(patient);
        cardRecord.setDiagnosis(request.getParameter("diagnosis"));
        cardRecord.setTreatmentCourse(request.getParameter("treatmentCourse"));
//        cardRecord.setTime();
        User user = (User) session.getAttribute("user");
        Doctor doctor = this.doctorDetailsDAO.returnDoctor(user);
        cardRecord.setDoctor(doctor);
        CardRecord cardRecordAfter = this.cardRecordingsDAO.addRecord(cardRecord).orElse(null);
        if (cardRecordAfter == null) {
            request.setAttribute("invalidAddRecord", true);
            forward(DOCTOR_CHOOSE);
        } else {
            redirect(DOCTOR_CHOOSE);
        }

    }

    @Override
    public void process() throws ServletException, IOException {
        forward(DOCTOR_CHOOSE);

    }
}
