package ru.rsreu.polyclinic.database.dao;

import ru.rsreu.polyclinic.data.User;

public interface SessionsDAO {

    void updateSession(User user);

    void deleteSessionSignOut(User user);

    void createSession(User user);

}
