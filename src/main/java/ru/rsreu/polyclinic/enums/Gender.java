package ru.rsreu.polyclinic.enums;

public enum Gender {
    MALE("m"),
    FEMALE("f");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return this.gender;
    }
}
