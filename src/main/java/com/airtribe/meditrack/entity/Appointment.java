package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.enums.AppointmentStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Appointment implements Cloneable, Serializable {

    private int appointmentId;
    private Doctor doctor;
    private Patient patient;
    private LocalDateTime appointmentTime;
    private AppointmentStatus status;

    public Appointment(int appointmentId,
                       Doctor doctor,
                       Patient patient,
                       LocalDateTime appointmentTime,
                       AppointmentStatus status) {

        this.appointmentId = appointmentId;
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentTime = appointmentTime;
        this.status = status;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    @Override
    public Appointment clone() {

        try {
            Appointment cloned = (Appointment) super.clone();

            cloned.patient = patient.clone();

            return cloned;

        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", doctor=" + doctor.getName() +
                ", patient=" + patient.getName() +
                ", time=" + appointmentTime +
                ", status=" + status +
                '}';
    }
}