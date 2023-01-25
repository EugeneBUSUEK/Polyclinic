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

public class DeleteUserCommand extends FrontCommand{
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
        String login = request.getParameter("username");
        if (login.equals(user.getLogin())) {
            request.setAttribute("invalidAdminSelfDelete", true);
            forward(SYS_ADMIN);
        } else {
            long id = Long.parseLong(request.getParameter("id"));
            user = new User();
            user.setId(id);
            this.userDAO.deleteUser(user);
//            List<Doctor> rs = this.userDAO.returnAllUsersForAdminEdit();
//            session.setAttribute("listOfUsersAdmin", rs);
            redirect(SYS_ADMIN);
        }
    }

    @Override
    public void process() throws ServletException, IOException {
//        forward(SYS_ADMIN);
    }
}
