package ru.rsreu.polyclinic.database.dao;

import ru.rsreu.polyclinic.data.CardRecord;
import ru.rsreu.polyclinic.data.Patient;

import java.util.List;

public interface CardRecordingsDAO {

    List<CardRecord> returnAllRecords();

    List<CardRecord> returnPatientRecords(Patient patient);
}
