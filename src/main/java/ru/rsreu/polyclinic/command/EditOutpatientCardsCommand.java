package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.Patient;
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

import static ru.rsreu.polyclinic.constant.Routes.POLIC_ADMIN_EDIT_PATIENTS;
import static ru.rsreu.polyclinic.constant.Routes.SYS_ADMIN;

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
        redirect(POLIC_ADMIN_EDIT_PATIENTS);
    }

    @Override
    public void process() throws ServletException, IOException {
        forward(POLIC_ADMIN_EDIT_PATIENTS);
    }

}
