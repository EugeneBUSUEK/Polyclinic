package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.database.dao.DAOFactory;
import ru.rsreu.polyclinic.database.dao.UserDAO;
import ru.rsreu.polyclinic.util.BooleanUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static ru.rsreu.polyclinic.constant.Routes.MODER;

public class BlockUserCommand extends FrontCommand{

    private UserDAO userDAO;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

        userDAO = DAOFactory.getUserDAO();
    }

    @Override
    public void send() throws ServletException, IOException {
        String login = request.getParameter("username");
//        login = login.substring(0,login.length() - 1);
        boolean isBlocked = Boolean.parseBoolean(request.getParameter("isBlocked"));
        this.userDAO.blockUser(login, !isBlocked);
        redirect(MODER);
    }

    @Override
    public void process() throws ServletException, IOException {
        forward(MODER);
    }
}
