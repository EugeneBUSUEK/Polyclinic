package ru.rsreu.polyclinic.enums;

public enum RoleType {
    POLYCLINIC_ADMINISTRATOR("polyclinic_administrator"),
    SYSTEM_ADMINISTRATOR("system_administrator"),
    DOCTOR("doctor"),
    MODERATOR("moderator");

    private final String role;

    RoleType(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}
