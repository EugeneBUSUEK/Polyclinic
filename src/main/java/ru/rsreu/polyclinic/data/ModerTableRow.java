package ru.rsreu.polyclinic.data;

public class ModerTableRow {
    private User user;

    private String expiredAt;

    private String status;

    public ModerTableRow() {}

    public ModerTableRow(User user, String expiredAt, String status) {
        this.user = user;
        this.expiredAt = expiredAt;
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(String expiredAt) {
        this.expiredAt = expiredAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
