package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.data.ModerTableRow;
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

import static ru.rsreu.polyclinic.constant.Routes.LOGIN;
import static ru.rsreu.polyclinic.constant.Routes.MODER;

public class SignOutCommand extends FrontCommand{
    private UserDAO userDAO;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

        userDAO = DAOFactory.getUserDAO();
    }

    @Override
    public void send() throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        this.userDAO.deleteSession(user);
        redirect(LOGIN);
    }

    @Override
    public void process() throws ServletException, IOException {
        forward(LOGIN);

    }
}
