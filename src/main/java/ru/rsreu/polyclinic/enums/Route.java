package ru.rsreu.polyclinic.enums;

public enum Route {



    PROFILE ( "", "/profile"),
    LOGIN ("", "/login"),
    MODER("", "/moderator"),
    SYS_ADMIN("", "/sysAdmin"),
    POLYC_ADMIN_EDIT_PATIENTS("", "/polycAdminEditPatient"),
    POLYC_ADMIN_VIEW_EDIT_CHARTS("", "/polycAdminViewEditCharts"),
    EDIT_CURRENT_CHART("", "/polycAdminEditCurrentCharts"),
    POLYC_ADMIN_CHECK_VACATIONS("", "/polycAdminCheckVacation"),
    CHECK_VACATION_DETAILS("", "/polycAdminCheckVacationDetails"),
    POLYC_ADMIN_RECORD_PATIENT("", "/polycAdminRecordPatient"),
    POLYC_ADMIN_SET_APPOINTMENT("", "/polycAdminSetAppointment"),
    DOCTOR_CHECK_VACATIONS("", "/doctorCheckCreateVacations"),
    DOCTOR_CHECK_APPOINTMENTS("", "/doctorCheckAppointments"),
    PATIENT_CARD("", "/doctorPatientCard"),
    DOCTOR_RECORD_PATIENT_TO_DOCTOR("", "/doctorRecordPatientToDoctor"),
    DOCTOR_CHOOSE("", "/doctorChoose"),



    //-----------------------------------------------
//    ADMIN_DASHBOARD_ADD_USER("Dashboard", "/admin-dashboard/add-user"),
//    ADMIN_DASHBOARD_DELETE_USER("Dashboard", "/admin-dashboard/delete-user"),
//    ADMIN_DASHBOARD_EDIT_USER("Dashboard", "/admin-dashboard/edit-user"),
//    ADMIN_DASHBOARD("Dashboard", "/admin-dashboard"),
//
//    MODERATOR_DASHBOARD("Dashboard", "/moderator-dashboard"),
//
//    TEAMS_JOIN_REQUEST_DECISION("Join Request Decision", "/teams/join-request-decision"),
//    TEAMS_JOIN_REQUEST("Available Teams", "/teams/join-request"),
//    TEAMS_AVAILABLE("Available Teams", "/teams/available"),
//    TEAM_LEAVE("Create Team", "/teams/leave"),
//    TEAM_AVAILABLE_EXPERTS("Team Experts", "/teams/available-experts"),
//    TEAM_EXPERTS("Team Experts", "/teams/experts"),
//    TEAM_CREATE("Create Team", "/teams/create"),
//    TEAMS_CHAT_LAST_MESSAGES("Team Chat Last Message", "/team/chat-last-messages"),
//    TEAM_CHAT("Team Chat", "/teams/chat"),
//    TEAMS("Teams", "/teams"),
//
//    NOTIFICATIONS("Notifications", "/notifications"),
//
//    LOGOUT("Logout", "/logout"),
//    SIGNIN("Sign In", "/signin"),
//    SIGNUP("Sign Up", "/signup"),

    NOT_FOUND("404", "/404");

    private final String name;
    private final String path;

    Route(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getRelative() {
        return path;
    }

    public String getAbsolute() {
        return path.substring(1);
    }
}
