package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.data.Patient;
import ru.rsreu.polyclinic.data.User;
import ru.rsreu.polyclinic.database.dao.DAOFactory;
import ru.rsreu.polyclinic.database.dao.OutpatientCardsDAO;
import ru.rsreu.polyclinic.database.dao.UserDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static ru.rsreu.polyclinic.constant.Routes.POLYC_ADMIN_EDIT_PATIENTS;
import static ru.rsreu.polyclinic.constant.Routes.SYS_ADMIN;

public class DeletePatientCommand extends FrontCommand{

    private OutpatientCardsDAO outpatientCardsDAO;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

        outpatientCardsDAO = DAOFactory.getOutpatientCardsDAO();
    }

    @Override
    public void send() throws ServletException, IOException {
        HttpSession session = request.getSession();
        long id = Long.parseLong(request.getParameter("id"));
        Patient patient = new Patient();
        patient.setId(id);
        this.outpatientCardsDAO.deletePatient(patient);

        List<Patient> rs = this.outpatientCardsDAO.returnAllPatients();
        for (Patient pat : rs) {
            String date = pat.getBirthDay().split(" ")[0];
            pat.setBirthDay(date);
        }
        session.setAttribute("listOfPatients", rs);
        forward(POLYC_ADMIN_EDIT_PATIENTS);
    }

    @Override
    public void process() throws ServletException, IOException {
        forward(POLYC_ADMIN_EDIT_PATIENTS);
    }
}
