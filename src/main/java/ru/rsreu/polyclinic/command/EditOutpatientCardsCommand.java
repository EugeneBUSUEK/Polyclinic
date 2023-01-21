package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.data.Patient;
import ru.rsreu.polyclinic.database.dao.DAOFactory;
import ru.rsreu.polyclinic.database.dao.OutpatientCardsDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static ru.rsreu.polyclinic.constant.Routes.POLYC_ADMIN_EDIT_PATIENTS;

public class EditOutpatientCardsCommand extends FrontCommand{

    private OutpatientCardsDAO outpatientCardsDAO;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

        outpatientCardsDAO = DAOFactory.getOutpatientCardsDAO();
    }

    @Override
    public void send() throws ServletException, IOException {
        List<Patient> rs = this.outpatientCardsDAO.returnAllPatients();
        for (Patient patient : rs) {
            String date = patient.getBirthDay().split(" ")[0];
            patient.setBirthDay(date);
        }
        HttpSession session = request.getSession();
        session.setAttribute("listOfPatients", rs);
        forward(POLYC_ADMIN_EDIT_PATIENTS);
    }

    @Override
    public void process() throws ServletException, IOException {
        forward(POLYC_ADMIN_EDIT_PATIENTS);
    }

}
