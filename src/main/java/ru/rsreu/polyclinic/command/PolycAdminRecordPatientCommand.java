package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.Patient;
import ru.rsreu.polyclinic.data.RequestsTableRow;
import ru.rsreu.polyclinic.data.User;
import ru.rsreu.polyclinic.database.dao.*;
import ru.rsreu.polyclinic.enums.RoleType;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ru.rsreu.polyclinic.constant.Routes.POLYC_ADMIN_CHECK_VACATIONS;
import static ru.rsreu.polyclinic.constant.Routes.POLYC_ADMIN_RECORD_PATIENT;

public class PolycAdminRecordPatientCommand extends FrontCommand{
    private UserDAO userDAO;
    private OutpatientCardsDAO outpatientCardsDAO;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

        userDAO = DAOFactory.getUserDAO();
        outpatientCardsDAO = DAOFactory.getOutpatientCardsDAO();
    }

    @Override
    public void send() throws ServletException, IOException {
        List<Doctor> listOfUsers = this.userDAO.returnAllUsersForAdminEdit();
        List<Doctor> doctors = new ArrayList<>();
        for (Doctor user : listOfUsers) {
            if (user.getUser().getRole().equals(RoleType.DOCTOR.getRole())) {
                doctors.add(user);
            }
        }
        List<Patient> patients = this.outpatientCardsDAO.returnAllPatients();
        HttpSession session = request.getSession();
        session.setAttribute("patientList", patients);
        session.setAttribute("doctorList", doctors);
        forward(POLYC_ADMIN_RECORD_PATIENT);
    }

    @Override
    public void process() throws ServletException, IOException {
        forward(POLYC_ADMIN_RECORD_PATIENT);
    }
}
