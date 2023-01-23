package ru.rsreu.polyclinic.data;

public class CardRecord {
    private Long id;
    private Patient patient;
    private String diagnosis;
    private String treatmentCourse;
    private String time;
    private Doctor doctor;

    public CardRecord() {}

    public CardRecord(Long id, Patient patient, String diagnosis, String treatmentCourse, String time, Doctor doctor) {
        this.id = id;
        this.patient = patient;
        this.diagnosis = diagnosis;
        this.treatmentCourse = treatmentCourse;
        this.time = time;
        this.doctor = doctor;
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

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatmentCourse() {
        return treatmentCourse;
    }

    public void setTreatmentCourse(String treatmentCourse) {
        this.treatmentCourse = treatmentCourse;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
