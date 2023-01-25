package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.User;
import ru.rsreu.polyclinic.database.dao.DAOFactory;
import ru.rsreu.polyclinic.database.dao.UserDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static ru.rsreu.polyclinic.constant.Routes.SYS_ADMIN;

public class SysAdminCommand extends FrontCommand{
    private UserDAO userDAO;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

        userDAO = DAOFactory.getUserDAO();
    }

    @Override
    public void send() throws ServletException, IOException {
//        List<Doctor> rs = this.userDAO.returnAllUsersForAdminEdit();
//        for (Doctor doc : rs) {
//            switch (doc.getUser().getRole()) {
//                case "moderator" : {
//                    doc.getUser().setRole("Moderator");
//                    break;
//                }
//                case "system_administrator" : {
//                    doc.getUser().setRole("System Administrator");
//                    break;
//                }
//                case "polyclinic_administrator" : {
//                    doc.getUser().setRole("Polyclinic Administrator");
//                    break;
//                }
//                case "doctor" : {
//                    doc.getUser().setRole("Doctor");
//                    break;
//                }
//            }
//        }
//        HttpSession session = request.getSession();
//        session.setAttribute("listOfUsersAdmin", rs);
//        redirect(SYS_ADMIN);
    }

    @Override
    public void process() throws ServletException, IOException {
        List<Doctor> rs = this.userDAO.returnAllUsersForAdminEdit();
        for (Doctor doc : rs) {
            switch (doc.getUser().getRole()) {
                case "moderator" : {
                    doc.getUser().setRole("Moderator");
                    break;
                }
                case "system_administrator" : {
                    doc.getUser().setRole("System Administrator");
                    break;
                }
                case "polyclinic_administrator" : {
                    doc.getUser().setRole("Polyclinic Administrator");
                    break;
                }
                case "doctor" : {
                    doc.getUser().setRole("Doctor");
                    break;
                }
            }
        }
        HttpSession session = request.getSession();
        session.setAttribute("listOfUsersAdmin", rs);
        forward(SYS_ADMIN);
    }
}
