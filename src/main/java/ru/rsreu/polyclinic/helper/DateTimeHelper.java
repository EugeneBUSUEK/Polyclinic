package ru.rsreu.polyclinic.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeHelper {
    private static final String TODAY_DATE_PATTERN = "HH:mm:ss";
    private static final String OTHERS_DATE_PATTERN = "dd-MM-yyyy HH:mm:ss";
    private static final String TIME_PATTERN = "HH:mm:ss";
    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_TIME_PATTERN = "dd-MM-yyyy HH:mm:ss";

    private DateTimeHelper() {
    }

    public static String getDateAsString(Date date) {
        if (isToday(date)) {
            return "Today, " + new SimpleDateFormat(TODAY_DATE_PATTERN).format(date);
        }

        return new SimpleDateFormat(OTHERS_DATE_PATTERN).format(date);
    }

    public static Date getDateFromString(String stringDate) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);
        Date date = new Date();
        try {
            date = formatter.parse(stringDate);
            return date;
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getTimeFromString(String stringTime) {
        SimpleDateFormat formatter = new SimpleDateFormat(TIME_PATTERN);
        Date date = new Date();
        try {
            date = formatter.parse(stringTime);
            return date;
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
//
    public static Date getDateTimeFromString(String stringDateTime) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_TIME_PATTERN);
        Date date = new Date();
        try {
            date = formatter.parse(stringDateTime);
            return date;
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    private static boolean isToday(Date date) {
        return isSameDay(date, Calendar.getInstance().getTime());
    }

    private static boolean isSameDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException();
        }

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        return isSameDay(cal1, cal2);
    }

    private static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException();
        }

        return (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
    }
}
