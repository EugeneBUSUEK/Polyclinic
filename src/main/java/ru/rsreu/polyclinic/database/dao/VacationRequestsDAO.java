package ru.rsreu.polyclinic.database.dao;

import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.RequestSet;

public interface VacationRequestsDAO {

    RequestSet returnRequestsOfDoctor(Doctor doctor);
}
