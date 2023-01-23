package ru.rsreu.polyclinic.data;

public class Appointment {
    private Long id;
    private Patient patient;
    private Doctor doctor;
    private String fromTime;
    private String toTime;

    public Appointment() {}

    public Appointment(Long id, Patient patient, Doctor doctor, String fromTime, String toTime) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }
}
