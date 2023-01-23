package ru.rsreu.polyclinic.database.dao;

import ru.rsreu.polyclinic.data.Appointment;
import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.VacationRequest;

import java.util.List;

public interface AppointmentsDAO {
    List<Appointment> returnAppointmentsForDoctor(Doctor doctor);

    void deleteAppointment(Appointment appointment);
}
