package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.data.User;
import ru.rsreu.polyclinic.database.dao.DAOFactory;
import ru.rsreu.polyclinic.database.dao.SessionsDAO;
import ru.rsreu.polyclinic.database.dao.UserDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static ru.rsreu.polyclinic.constant.Routes.*;

public class LoginCommand extends FrontCommand {


    private UserDAO userDAO;
    private SessionsDAO sessionsDAO;





    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

        userDAO = DAOFactory.getUserDAO();
        sessionsDAO = DAOFactory.getSessionsDAO();
    }

//    @Override
//    public void process() throws ServletException, IOException {
//        HttpSession session = request.getSession(false);
//
//        User user = AppUtils.getLoginWorker(session);
//
//        if (user != null) {
//            redirect("profile");
//        } else {
//            forward("login");
//        }
//    }

    @Override
    public void send() throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");


        //User user = this.userDAO.getUserByLogin(login).orElseThrow(RuntimeException::new);

        User user = this.userDAO.getUserByLogin(login).orElse(null);

        if (user == null || !user.getPassword().equals(password) || user.isBlocked()) {
            request.setAttribute("invalidAuth", true);
            forward(LOGIN);
        } else {
            this.sessionsDAO.updateSession(user);
            HttpSession session = request.getSession();

            //user.setStatusAuthorize(true);
            //userDAO.updateUser(user);

            session.setAttribute("user", user);

            redirect(PROFILE);
        }
    }

    @Override
    public void process() throws ServletException, IOException {
        forward(LOGIN);
    }
//    @Override
//    public void send() throws ServletException, IOException{
//        forward(HOME);
//    }
}
