package ru.rsreu.polyclinic.database.dao;

import ru.rsreu.polyclinic.data.*;

public interface DoctorChartsDAO {

    DoctorChart returnDoctorCharts(Doctor doctor);

    void editDoctorCharts(DoctorChartDay doctorChartDay);
    void addDoctorCharts(Doctor doctor, Chart chart);

}
