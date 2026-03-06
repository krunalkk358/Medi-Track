package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.enums.Specialization;
import com.airtribe.meditrack.interfac.Searchable;
import com.airtribe.meditrack.util.DataStore;

import java.util.List;
import java.util.stream.Collectors;


public class DoctorService implements Searchable<Doctor> {

    private DataStore<Doctor> doctorStore = new DataStore<>();

    public void addDoctor(Doctor doctor) {
        doctorStore.add(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorStore.getAll();
    }

    @Override
    public List<Doctor> searchByName(String name) {

        return doctorStore.getAll()
                .stream()
                .filter(d -> d.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());

    }

    public List<Doctor> findBySpecialization(Specialization specialization) {

        return doctorStore.getAll()
                .stream()
                .filter(d -> d.getSpecialization() == specialization)
                .collect(Collectors.toList());

    }

}