package ru.rsreu.polyclinic.command;

import javax.servlet.ServletException;

import java.io.IOException;

import static ru.rsreu.polyclinic.constant.Routes.PROFILE;

public class ProfileCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        forward(PROFILE);
    }
}
