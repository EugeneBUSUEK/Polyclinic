package ru.rsreu.polyclinic.data;

import java.util.HashMap;
import java.util.Map;

public class Chart {

//    private String[][] chart = {{"09:00:00", "13:00:00"},
//            {"09:00:00", "13:00:00"},
//            {"09:00:00", "13:00:00"},
//            {"09:00:00", "13:00:00"},
//            {"09:00:00", "13:00:00"},
//            {"09:00:00", "13:00:00"},
//            {"09:00:00", "13:00:00"}};

    private Map<Integer, String[]> chart;

    public Chart() {
        chart = new HashMap<>();
        chart.put(1, new String[]{"09:00:00", "13:00:00"});
        chart.put(2, new String[]{"09:00:00", "13:00:00"});
        chart.put(3, new String[]{"09:00:00", "13:00:00"});
        chart.put(4, new String[]{"09:00:00", "13:00:00"});
        chart.put(5, new String[]{"09:00:00", "13:00:00"});
        chart.put(6, new String[]{"", ""});
        chart.put(0, new String[]{"", ""});
    }

    public String getFrom(int i) {
        return chart.get(i)[0];
    }

    public void setFrom(int i, String from) {
        String[] day = new String[2];
        day[0] = from;
        day[1] = getTo(i);
        chart.replace(i, day);
    }

    public String getTo(int i) {
        return chart.get(i)[1];
    }

    public void setTo(int i, String to) {
        String[] day = new String[2];
        day[0] = getFrom(i);
        day[1] = to;
        chart.replace(i, day);
    }
}
