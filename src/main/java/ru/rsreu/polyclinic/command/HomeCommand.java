package ru.rsreu.polyclinic.command;

import javax.servlet.ServletException;

import java.io.IOException;

import static ru.rsreu.polyclinic.constant.Routes.HOME;

public class HomeCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        forward(HOME);
    }
}
