package com.airtribe.meditrack.util;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {

    private static IdGenerator instance;

    private AtomicInteger doctorCounter = new AtomicInteger(1);
    private AtomicInteger patientCounter = new AtomicInteger(1);
    private AtomicInteger appointmentCounter = new AtomicInteger(1);
    private AtomicInteger billCounter = new AtomicInteger(1);

    private IdGenerator() {}

    public static IdGenerator getInstance() {

        if (instance == null) {
            synchronized (IdGenerator.class) {
                if (instance == null) {
                    instance = new IdGenerator();
                }
            }
        }

        return instance;
    }

    public int generateDoctorId() {
        return doctorCounter.getAndIncrement();
    }

    public int generatePatientId() {
        return patientCounter.getAndIncrement();
    }

    public int generateAppointmentId() {
        return appointmentCounter.getAndIncrement();
    }

    public int generateBillId() {
        return billCounter.getAndIncrement();
    }
}