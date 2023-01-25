package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.Patient;
import ru.rsreu.polyclinic.data.User;
import ru.rsreu.polyclinic.database.dao.DAOFactory;
import ru.rsreu.polyclinic.database.dao.DoctorDetailsDAO;
import ru.rsreu.polyclinic.database.dao.OutpatientCardsDAO;
import ru.rsreu.polyclinic.database.dao.SessionsDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static ru.rsreu.polyclinic.constant.Routes.*;

public class AddPatientCommand extends FrontCommand{
    private OutpatientCardsDAO outpatientCardsDAO;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

        outpatientCardsDAO = DAOFactory.getOutpatientCardsDAO();
    }

    @Override
    public void send() throws ServletException, IOException {
        Patient patient = new Patient();
//        patient.setId(Long.parseLong(request.getParameter("id")));
        patient.setName(request.getParameter("name"));
        patient.setGender(request.getParameter("gender"));
        patient.setBirthDay(request.getParameter("birth"));
        patient.setPhoneNumber(request.getParameter("phone"));
        patient.setAddress(request.getParameter("address"));
        Patient patientAfter = this.outpatientCardsDAO.addPatient(patient).orElse(null);
        if (patientAfter == null) {
            request.setAttribute("invalidAddUser", true);
            forward(POLYC_ADMIN_EDIT_PATIENTS);
        }

//        List<Patient> rs = this.outpatientCardsDAO.returnAllPatients();
//        for (Patient pat : rs) {
//            String date = pat.getBirthDay().split(" ")[0];
//            pat.setBirthDay(date);
//        }
//        HttpSession session = request.getSession();
//        session.setAttribute("listOfPatients", rs);
        redirect(POLYC_ADMIN_EDIT_PATIENTS_REDIRECT);
    }

    @Override
    public void process() throws ServletException, IOException {
//        forward(POLYC_ADMIN_EDIT_PATIENTS);

    }
}
