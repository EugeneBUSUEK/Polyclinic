package ru.rsreu.polyclinic.mapper;

import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.User;

public class Mapper {

    public static User mapUser(Long id, String username, String password, String name, boolean isBlocked, String role) {
        return new User(id, username, password, name, isBlocked, role);
    }

    public static Doctor mapUserToDoctor(User user, String spec, String cabinet, boolean inVacation) {
        Doctor doctor = new Doctor();
        doctor.setUser(user);
        doctor.setSpecialization(spec);
        doctor.setCabinet(cabinet);
        doctor.setInVacation(inVacation);
        return doctor;
    }
}
