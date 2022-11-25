package ru.rsreu.polyclinic.command;

import java.io.IOException;

import static ru.rsreu.polyclinic.constant.Routes.HOME;

public class UnknownCommand extends FrontCommand {
    @Override
    public void process() throws IOException {
        redirect(HOME);
    }
}
