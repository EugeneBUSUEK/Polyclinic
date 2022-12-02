package ru.rsreu.polyclinic.util;

import ru.rsreu.polyclinic.data.User;

import javax.servlet.http.HttpSession;

public class AppUtils {

    public static User getLoginUser(HttpSession session) {
        return (User) session.getAttribute("worker");
    }

    public static void storeLoginUser(HttpSession session, User user) {
        session.setAttribute("user", user);
    }

}
