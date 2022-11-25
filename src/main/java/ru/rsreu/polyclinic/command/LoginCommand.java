package ru.rsreu.polyclinic.command;

import javax.servlet.ServletException;

import java.io.IOException;

import static ru.rsreu.polyclinic.constant.Routes.LOGIN;

public class LoginCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        forward(LOGIN);
    }
}
