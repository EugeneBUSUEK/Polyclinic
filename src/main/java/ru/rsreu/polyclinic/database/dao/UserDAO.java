package ru.rsreu.polyclinic.database.dao;

import ru.rsreu.polyclinic.data.Doctor;
import ru.rsreu.polyclinic.data.ModerTableRow;
import ru.rsreu.polyclinic.data.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    List<ModerTableRow> returnAllUsersModer();
    List<User> returnAllUsers();

    List<Doctor> returnAllUsersForAdminEdit();


    void blockUser(User user);

    List<User> findAll();

    Optional<User> getUserById(Long id);

    Optional<User> getUserByLogin(String login);

    void updateUser(User user);

    void deleteUser(User user);

    Optional<User> addUser(User user);



}
