package ru.rsreu.polyclinic.database.dao;

import ru.rsreu.polyclinic.data.Appointment;
import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.VacationRequest;

import java.util.List;
import java.util.Optional;

public interface AppointmentsDAO {
    List<Appointment> returnAppointmentsForDoctor(Doctor doctor);
    Optional<Appointment> addAppointment(Appointment appointment);

    void deleteAppointment(Appointment appointment);
}
