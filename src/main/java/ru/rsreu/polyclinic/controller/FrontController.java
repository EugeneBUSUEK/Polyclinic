package ru.rsreu.polyclinic.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.rsreu.polyclinic.command.FrontCommand;
import ru.rsreu.polyclinic.command.UnknownCommand;
import ru.rsreu.polyclinic.util.StringUtil;

import java.io.IOException;

public class FrontController extends HttpServlet {
    /**
     * @param req provide request information for HTTP servlets
     * @param res provide response information for HTTP servlets
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        FrontCommand command = getCommand(req);

        command.init(getServletContext(), req, res);
        command.process();
}

    /**
     * @param req provide request information for HTTP servlets
     * @param res provide response information for HTTP servlets
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        FrontCommand command = getCommand(req);

        command.init(getServletContext(), req, res);
        command.send();
    }

    private FrontCommand getCommand(HttpServletRequest request) {
        try {
            String path = request.getPathInfo();
            String str = String.format(
                    "ru.rsreu.polyclinic.command.%sCommand",
                    StringUtil.capitalize(path.substring(1))
            );
            Class<?> type = Class.forName(str);

            return type
                    .asSubclass(FrontCommand.class)
                    .newInstance();
        } catch (Exception e) {
            return new UnknownCommand();
        }
    }
}
