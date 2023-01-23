package ru.rsreu.polyclinic.database.dao;

import ru.rsreu.polyclinic.data.CardRecord;
import ru.rsreu.polyclinic.data.Patient;

import java.util.List;
import java.util.Optional;

public interface CardRecordingsDAO {

    List<CardRecord> returnAllRecords();

    List<CardRecord> returnPatientRecords(Patient patient);

    Optional<CardRecord> addRecord(CardRecord cardRecord);
}
