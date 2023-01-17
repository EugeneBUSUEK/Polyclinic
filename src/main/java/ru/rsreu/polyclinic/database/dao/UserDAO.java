package ru.rsreu.polyclinic.database.dao;

import ru.rsreu.polyclinic.data.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserDAO {

    List<List<String>> returnAllUsers();

    List<User> findAll();

    Optional<User> getUserById(Long id);

    Optional<User> getUserByLogin(String login);

    void updateUser(User user);

    void deleteUser(User user);

    Optional<User> addUser(User user);

}
