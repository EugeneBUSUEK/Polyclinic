package ru.rsreu.polyclinic.data;

public class User {
    private Long id;
    private String login;
    private String password;
    private String name;
    private boolean blocked;
    private String role;

    public User() {}
    public User(Long id, String login, String password, String name, boolean blocked, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.blocked = blocked;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
