package ru.rsreu.polyclinic.data;

public class VacationRequest {
    private Long id;
    private Long doctor_id;
    private String request;
    private String date_from;
    private String date_to;
    private boolean approved;

    public VacationRequest() {}

    public VacationRequest(Long id, Long doctor_id, String request, String date_from, String date_to, boolean approved) {
        this.id = id;
        this.doctor_id = doctor_id;
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

    public Long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Long doctor_id) {
        this.doctor_id = doctor_id;
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
