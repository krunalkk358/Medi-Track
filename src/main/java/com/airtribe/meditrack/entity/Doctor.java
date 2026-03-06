package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.enums.Specialization;

import java.io.Serializable;

public class Doctor extends Person implements Serializable {

    private Specialization specialization;
    private double consultationFee;

    public Doctor(int id, String name, int age,
                  Specialization specialization,
                  double consultationFee) {

        super(id, name, age);
        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialization=" + specialization +
                ", consultationFee=" + consultationFee +
                '}';
    }
}