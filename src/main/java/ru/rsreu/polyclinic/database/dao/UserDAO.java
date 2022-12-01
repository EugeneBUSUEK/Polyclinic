package ru.rsreu.polyclinic.database.dao;

import ru.rsreu.polyclinic.data.User;

import java.util.ArrayList;

public interface UserDAO {

    ArrayList<User> findAll();

    User getUserById(Long id);

    User getUserById(String id);

    User getUserByLogin(String login);

    void updateUser(User user);

    void deleteUser(User user);

    void addUser(User user);

}
