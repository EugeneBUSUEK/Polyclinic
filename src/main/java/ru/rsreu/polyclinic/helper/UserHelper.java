package ru.rsreu.polyclinic.helper;

import ru.rsreu.polyclinic.data.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class UserHelper {
//    private static final String USER_ID = "user_id";
//    private static final int COOKIE_MAX_AGE = 60 * 60;

    private UserHelper() {
    }

    public static Optional<User> getFromRequest(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
//        User user = (User) request.getUserPrincipal();

        return Optional.ofNullable(user);
    }
}
