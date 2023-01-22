package ru.rsreu.polyclinic.data;

public class DoctorChart {
    private Doctor doctor;
    private Chart chart;

    public DoctorChart() {}

    public DoctorChart(Doctor doctor, Chart chart) {
        this.doctor = doctor;
        this.chart = chart;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Chart getChart() {
        return chart;
    }

    public void setChart(Chart chart) {
        this.chart = chart;
    }
}
