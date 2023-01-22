package ru.rsreu.polyclinic.command;

import ru.rsreu.polyclinic.data.VacationRequest;
import ru.rsreu.polyclinic.database.dao.DAOFactory;
import ru.rsreu.polyclinic.database.dao.DoctorDetailsDAO;
import ru.rsreu.polyclinic.database.dao.UserDAO;
import ru.rsreu.polyclinic.database.dao.VacationRequestsDAO;
import ru.rsreu.polyclinic.util.BooleanUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.rsreu.polyclinic.constant.Routes.POLYC_ADMIN_CHECK_VACATIONS;

public class RejectVacationCommand extends FrontCommand{
    private UserDAO userDAO;
    private DoctorDetailsDAO doctorDetailsDAO;
    private VacationRequestsDAO vacationRequestsDAO;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

        userDAO = DAOFactory.getUserDAO();
        doctorDetailsDAO = DAOFactory.getDoctorDetailsDAO();
        vacationRequestsDAO = DAOFactory.getVacationRequestsDAO();
    }

    @Override
    public void send() throws ServletException, IOException {
        VacationRequest vacationRequest = new VacationRequest();
        vacationRequest.setId(Long.parseLong(request.getParameter("id")));
        this.vacationRequestsDAO.deleteDoctorRequest(vacationRequest);

        redirect(POLYC_ADMIN_CHECK_VACATIONS);
    }

    @Override
    public void process() throws ServletException, IOException {
        forward(POLYC_ADMIN_CHECK_VACATIONS);
    }
}
