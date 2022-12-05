package ru.rsreu.polyclinic.enums;

public enum RoleType {
    POLYC_ADMIN("polyclinic_administrator"),
    SYS_ADMIN("system_administrator"),
    DOCTOR("doctor"),
    MODER("moderator");

    private final String role;

    RoleType(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}
