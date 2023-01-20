package ru.rsreu.polyclinic.data;

public class Doctor {
    private User user;
    private String specialization;
    private String cabinet;
    private boolean inVacation;

    public Doctor() {}

    public Doctor(User user, String specialization, String cabinet, boolean inVacation) {
        this.user = user;
        this.specialization = specialization;
        this.cabinet = cabinet;
        this.inVacation = inVacation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getCabinet() {
        return cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    public boolean isInVacation() {
        return inVacation;
    }

    public void setInVacation(boolean inVacation) {
        this.inVacation = inVacation;
    }
}
