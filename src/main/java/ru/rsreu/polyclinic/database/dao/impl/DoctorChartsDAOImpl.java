package ru.rsreu.polyclinic.database.dao.impl;

import com.prutzkow.resourcer.ProjectResourcer;
import ru.rsreu.polyclinic.data.*;
import ru.rsreu.polyclinic.database.ConnectionPool;
import ru.rsreu.polyclinic.database.dao.DoctorChartsDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorChartsDAOImpl implements DoctorChartsDAO {

    private static volatile DoctorChartsDAOImpl instance;

    private static final String UPDATE_DOCTOR_CHARTS = ProjectResourcer.getInstance().getString("query.update.doctor.charts");
    private static final String INSERT_DOCTOR_CHARTS = ProjectResourcer.getInstance().getString("query.insert.doctor.charts");
    private static final String SELECT_DOCOTR_CHARTS = ProjectResourcer.getInstance().getString("query.select.doctor.charts");
    private static final String SELECT_DOCOTR_CHART_FOR_DAY = ProjectResourcer.getInstance().getString("query.select.doctor.chart.day");



    @Override
    public DoctorChart returnDoctorCharts(Doctor doctor) {
        ResultSet rs = null;
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_DOCOTR_CHARTS)) {
            preparedStatement.setLong(1, doctor.getUser().getId());
            rs = preparedStatement.executeQuery();

            DoctorChart doctorChart = new DoctorChart();
            doctorChart.setDoctor(doctor);
            Chart chart = new Chart();
                while (rs.next()) {
                        chart.setFrom(rs.getInt(2), rs.getString(3));
                        chart.setTo(rs.getInt(2), rs.getString(4));
                }
            doctorChart.setChart(chart);


            return doctorChart;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<String> returnDoctorChartForDay(Long id, Integer dayOfWeek) {
        ResultSet rs = null;
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_DOCOTR_CHART_FOR_DAY)) {
            preparedStatement.setLong(1, id);
            preparedStatement.setInt(2, dayOfWeek);
            rs = preparedStatement.executeQuery();

            List<String> chart = new ArrayList<>();
            while (rs.next()) {
                chart.add(rs.getString(1));
                chart.add(rs.getString(2));
            }
            return chart;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void editDoctorCharts(DoctorChartDay doctorChartDay) {
        try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(UPDATE_DOCTOR_CHARTS)) {
            preparedStatement.setString(1, doctorChartDay.getFromTime());
            preparedStatement.setString(2, doctorChartDay.getToTime());
            preparedStatement.setLong(3, doctorChartDay.getUser().getId());
            preparedStatement.setInt(4, doctorChartDay.getDayOfWeek());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addDoctorCharts(Doctor doctor, Chart chart) {
        for (int i = 0; i < 7; i++) {
            try (PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(INSERT_DOCTOR_CHARTS)) {
                preparedStatement.setLong(1, doctor.getUser().getId());
                preparedStatement.setInt(2, i);
                preparedStatement.setString(3, chart.getFrom(i));
                preparedStatement.setString(4, chart.getFrom(i));
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static DoctorChartsDAOImpl getInstance() {
        synchronized (DoctorChartsDAOImpl.class) {
            if (instance == null) {
                instance = new DoctorChartsDAOImpl();
            }
        }
        return instance;
    }
}
