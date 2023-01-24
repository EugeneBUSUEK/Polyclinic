package ru.rsreu.polyclinic.helper;

import ru.rsreu.polyclinic.configuration.AuthConfig;
import ru.rsreu.polyclinic.data.User;
import ru.rsreu.polyclinic.enums.RoleType;
import ru.rsreu.polyclinic.enums.Route;

import java.util.List;

public class PermissionHelper {
    private PermissionHelper() {
    }

    public static boolean hasPermission(String path, User user) {
        List<Route> routes = AuthConfig.getRoleRoutes(
                RoleType.valueOf(user.getRole().toUpperCase())
        );

        for (Route route : routes) {
            if (path.equalsIgnoreCase(route.getRelative())) {
                return true;
            }
        }

        return false;
    }
}
