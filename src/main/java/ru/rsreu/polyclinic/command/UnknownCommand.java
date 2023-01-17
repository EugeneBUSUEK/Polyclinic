package ru.rsreu.polyclinic.command;

import java.io.IOException;

import static ru.rsreu.polyclinic.constant.Routes.PROFILE;

public class UnknownCommand extends FrontCommand {
    @Override
    public void process() throws IOException {
        redirect(PROFILE);
    }
}
