package ru.rsreu.polyclinic.database.dao;

import ru.rsreu.polyclinic.data.Chart;

import java.util.List;

public interface DoctorChartsDAO {

    List<Chart> returnAllCharts();
    
}
