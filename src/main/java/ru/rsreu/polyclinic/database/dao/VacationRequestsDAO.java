package ru.rsreu.polyclinic.database.dao;

import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.RequestSet;
import ru.rsreu.polyclinic.data.VacationRequest;

public interface VacationRequestsDAO {

    RequestSet returnRequestsOfDoctor(Doctor doctor);

    void updateDoctorRequest(VacationRequest vacationRequest);
}
