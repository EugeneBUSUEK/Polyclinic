package ru.rsreu.polyclinic.data;

public class RequestsTableRow {
    private Long id;
    private Doctor doctor;
    private String request;
    private String date_from;
    private String date_to;
    private boolean approved;

    public RequestsTableRow() {}

    public RequestsTableRow(Long id, Doctor doctor, String request, String date_from, String date_to, boolean approved) {
        this.id = id;
        this.doctor = doctor;
        this.request = request;
        this.date_from = date_from;
        this.date_to = date_to;
        this.approved = approved;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getDate_from() {
        return date_from;
    }

    public void setDate_from(String date_from) {
        this.date_from = date_from;
    }

    public String getDate_to() {
        return date_to;
    }

    public void setDate_to(String date_to) {
        this.date_to = date_to;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
