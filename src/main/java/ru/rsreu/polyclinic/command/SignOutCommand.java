package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.data.User;
import ru.rsreu.polyclinic.database.dao.DAOFactory;
import ru.rsreu.polyclinic.database.dao.SessionsDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static ru.rsreu.polyclinic.constant.Routes.LOGIN;

public class SignOutCommand extends FrontCommand{
    private SessionsDAO sessionsDAO;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

        sessionsDAO = DAOFactory.getSessionsDAO();
    }

    @Override
    public void send() throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        this.sessionsDAO.deleteSessionSignOut(user);
        redirect(LOGIN);
    }

    @Override
    public void process() throws ServletException, IOException {
        forward(LOGIN);

    }
}
