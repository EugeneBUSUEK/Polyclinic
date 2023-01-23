package ru.rsreu.polyclinic.database.dao;

import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.RequestSet;
import ru.rsreu.polyclinic.data.RequestsTableRow;
import ru.rsreu.polyclinic.data.VacationRequest;

import java.util.List;

public interface VacationRequestsDAO {

    RequestSet returnRequestsOfDoctor(Doctor doctor);

    List<RequestsTableRow> returnAllRequests(List<Doctor> doctors);

    void updateDoctorRequest(VacationRequest vacationRequest);

    void deleteDoctorRequest(VacationRequest vacationRequest);
}
