package ru.rsreu.polyclinic.database.dao;

import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.RequestSet;
import ru.rsreu.polyclinic.data.RequestsTableRow;
import ru.rsreu.polyclinic.data.VacationRequest;

import java.util.List;
import java.util.Optional;

public interface VacationRequestsDAO {

    RequestSet returnRequestsOfDoctorPolomani(Doctor doctor);
    List<RequestsTableRow> returnRequestsOfDoctor(Doctor doctor);

    List<RequestsTableRow> returnAllRequests(List<Doctor> doctors);
    List<RequestsTableRow> returnAllRequestsForAdmin(List<Doctor> doctors);

    void updateDoctorRequest(VacationRequest vacationRequest);
    Optional<RequestsTableRow> addDoctorRequest(RequestsTableRow requestsTableRow);

    void deleteDoctorRequest(VacationRequest vacationRequest);
}
