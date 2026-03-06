package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Appointment;
import com.airtribe.meditrack.entity.Bill;
import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.enums.AppointmentStatus;
import com.airtribe.meditrack.exception.AppointmentNotFoundException;
import com.airtribe.meditrack.util.DataStore;
import com.airtribe.meditrack.constants.Constants;

import java.time.LocalDateTime;
import java.util.List;

public class AppointmentService {

    private DataStore<Appointment> appointmentStore = new DataStore<>();

    public Appointment createAppointment(Appointment appointment) {

        appointmentStore.add(appointment);

        return appointment;
    }

    public List<Appointment> getAllAppointments() {

        return appointmentStore.getAll();
    }

    public void cancelAppointment(int appointmentId) throws AppointmentNotFoundException {

        Appointment appointment = appointmentStore.getAll()
                .stream()
                .filter(a -> a.getAppointmentId() == appointmentId)
                .findFirst()
                .orElse(null);

        if(appointment == null) {
            throw new AppointmentNotFoundException("Appointment not found with id: " + appointmentId);
        }

        appointment.setStatus(AppointmentStatus.CANCELLED);

    }

    public Bill generateBill(Appointment appointment, int billId) {

        return new Bill(billId, appointment, Constants.TAX_RATE);

    }

    public Appointment bookAppointment(int id,
                                       Doctor doctor,
                                       Patient patient,
                                       LocalDateTime time) {

        Appointment appointment =
                new Appointment(id, doctor, patient, time, AppointmentStatus.CONFIRMED);

        appointmentStore.add(appointment);

        return appointment;
    }

}