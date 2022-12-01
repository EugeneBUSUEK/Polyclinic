package ru.rsreu.polyclinic.data;

public class User {
    private Long id;
    private String login;
    private String password;
    private String name;
    private boolean blocked;

    public User() {}
    public User(Long id, String login, String password, String name, boolean blocked) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.blocked = blocked;
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
}
