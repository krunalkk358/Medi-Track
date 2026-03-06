package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.interfac.Searchable;
import com.airtribe.meditrack.util.DataStore;

import java.util.List;
import java.util.stream.Collectors;


public class PatientService implements Searchable<Patient> {

    private DataStore<Patient> patientStore = new DataStore<>();

    public void addPatient(Patient patient) {
        patientStore.add(patient);
    }

    public List<Patient> getAllPatients() {
        return patientStore.getAll();
    }

    public Patient getPatientById(int id) {

        return patientStore.getAll()
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

    }

    @Override
    public List<Patient> searchByName(String name) {

        return patientStore.getAll()
                .stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());

    }

}