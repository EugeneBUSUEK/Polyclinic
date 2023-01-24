package ru.rsreu.polyclinic.configuration;

import ru.rsreu.polyclinic.enums.RoleType;
import ru.rsreu.polyclinic.enums.Route;

import java.util.*;

public class AuthConfig {
    private static final Map<RoleType, List<Route>> roleRoutes = setRoleRoutes();
//    = Map.ofEntries(
//            Map.entry(RoleType.POLYC_ADMIN, List.of(
//                    Route.LOGIN,
//                    Route.PROFILE,
//                    Route.POLYC_ADMIN_EDIT_PATIENTS,
//                    Route.POLYC_ADMIN_VIEW_EDIT_CHARTS,
//                    Route.EDIT_CURRENT_CHART,
//                    Route.POLYC_ADMIN_CHECK_VACATIONS,
//                    Route.CHECK_VACATION_DETAILS,
//                    Route.POLYC_ADMIN_RECORD_PATIENT,
//                    Route.POLYC_ADMIN_SET_APPOINTMENT
//            )),
//            Map.entry(RoleType.DOCTOR, List.of(
//                    Route.LOGIN,
//                    Route.PROFILE,
//                    Route.DOCTOR_CHECK_VACATIONS,
//                    Route.DOCTOR_CHECK_APPOINTMENTS,
//                    Route.PATIENT_CARD,
//                    Route.DOCTOR_RECORD_PATIENT_TO_DOCTOR,
//                    Route.DOCTOR_CHOOSE
//            )),
//            Map.entry(RoleType.MODER, List.of(
//                    Route.LOGIN,
//                    Route.PROFILE,
//                    Route.MODER
//            )),
//            Map.entry(RoleType.SYS_ADMIN, List.of(
//                    Route.LOGIN,
//                    Route.PROFILE,
//                    Route.SYS_ADMIN
//            ))
//    );

    private static final Map<RoleType, Route> roleStartPage = setRoleStartPage();
//            = Map.ofEntries(
//            Map.entry(RoleType.DOCTOR, Route.LOGIN),
//            Map.entry(RoleType.MODER, Route.LOGIN),
//            Map.entry(RoleType.POLYC_ADMIN, Route.LOGIN),
//            Map.entry(RoleType.SYS_ADMIN, Route.LOGIN)
//    );

    public static Map<RoleType, List<Route>> setRoleRoutes() {
        Map<RoleType, List<Route>> map = new HashMap<>();
        map.put(RoleType.POLYCLINIC_ADMINISTRATOR, Arrays.asList(
                Route.LOGIN,
                Route.PROFILE,
                Route.POLYC_ADMIN_EDIT_PATIENTS,
                Route.POLYC_ADMIN_VIEW_EDIT_CHARTS,
                Route.EDIT_CURRENT_CHART,
                Route.POLYC_ADMIN_CHECK_VACATIONS,
                Route.CHECK_VACATION_DETAILS,
                Route.POLYC_ADMIN_RECORD_PATIENT,
                Route.POLYC_ADMIN_SET_APPOINTMENT));
        map.put(RoleType.DOCTOR, Arrays.asList(
                Route.LOGIN,
                Route.PROFILE,
                Route.DOCTOR_CHECK_VACATIONS,
                Route.DOCTOR_CHECK_APPOINTMENTS,
                Route.PATIENT_CARD,
                Route.DOCTOR_RECORD_PATIENT_TO_DOCTOR,
                Route.DOCTOR_CHOOSE));
        map.put(RoleType.MODERATOR, Arrays.asList(
                Route.LOGIN,
                Route.PROFILE,
                Route.MODER
        ));
        map.put(RoleType.SYSTEM_ADMINISTRATOR, Arrays.asList(
                Route.LOGIN,
                Route.PROFILE,
                Route.SYS_ADMIN
        ));
        return map;
    }

    public static Map<RoleType, Route> setRoleStartPage() {
        Map<RoleType, Route> map = new HashMap<>();
        map.put(RoleType.DOCTOR, Route.LOGIN);
        map.put(RoleType.MODERATOR, Route.LOGIN);
        map.put(RoleType.POLYCLINIC_ADMINISTRATOR, Route.LOGIN);
        map.put(RoleType.SYSTEM_ADMINISTRATOR, Route.LOGIN);
        return map;
    }

    public static Route getStartPage(RoleType role) {
        return roleStartPage.get(role);
    }

    public static List<Route> getRoleRoutes(RoleType role) {
        return roleRoutes.get(role);
    }
}
