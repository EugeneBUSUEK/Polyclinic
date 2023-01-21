package ru.rsreu.polyclinic.database.dao;

import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.ModerTableRow;
import ru.rsreu.polyclinic.data.Patient;
import ru.rsreu.polyclinic.data.User;

import java.util.List;
import java.util.Optional;

public interface OutpatientCardsDAO {
    List<Patient> returnAllPatients();

    List<Doctor> returnAllUsersForAdminEdit();

    void blockUser(User user);

    List<User> findAll();

    Optional<User> getUserById(Long id);

    Optional<User> getUserByLogin(String login);

    void updatePatient(User user);

    void deletePatient(User user);

    Optional<User> addPatient(User user);

}
