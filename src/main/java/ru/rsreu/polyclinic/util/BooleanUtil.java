package ru.rsreu.polyclinic.util;

public class BooleanUtil {
    public static int convertToInt(boolean mean) {
        return mean ? 1 : 0;
    }

    public static boolean parseBoolean(int mean) {
        return mean != 0;
    }
}
