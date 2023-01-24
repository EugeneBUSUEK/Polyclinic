package ru.rsreu.polyclinic.database.dao;

import ru.rsreu.polyclinic.data.*;

import java.util.List;

public interface DoctorChartsDAO {

    DoctorChart returnDoctorCharts(Doctor doctor);
    List<String> returnDoctorChartForDay(Long id, Integer dayOfWeek);

    void editDoctorCharts(DoctorChartDay doctorChartDay);
    void addDoctorCharts(Doctor doctor, Chart chart);

}
