package ru.rsreu.polyclinic.data;

import java.util.ArrayList;
import java.util.List;

public class RequestSet {
    private Doctor doctor;
    private List<VacationRequest> vacationRequestList;

    public RequestSet() {
        vacationRequestList = new ArrayList<>();
    }

    public RequestSet(Doctor doctor, List<VacationRequest> vacationRequestList) {
        this.doctor = doctor;
        this.vacationRequestList = vacationRequestList;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<VacationRequest> getVacationRequestList() {
        return vacationRequestList;
    }

    public void setVacationRequestList(List<VacationRequest> vacationRequestList) {
        this.vacationRequestList = vacationRequestList;
    }

    public void addRequest(VacationRequest vacationRequest) {
        getVacationRequestList().add(vacationRequest);
    }
}
