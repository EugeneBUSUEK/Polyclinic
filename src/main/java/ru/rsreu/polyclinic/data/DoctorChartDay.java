package ru.rsreu.polyclinic.data;

public class DoctorChartDay {
    private User user;
    private Integer dayOfWeek;
    private String fromTime;
    private String toTime;

    public DoctorChartDay() {}

    public DoctorChartDay(User user, Integer dayOfWeek, String fromTime, String toTime) {
        this.user = user;
        this.dayOfWeek = dayOfWeek;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }
}
