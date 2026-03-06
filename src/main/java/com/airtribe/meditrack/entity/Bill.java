package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.interfac.Payable;

import java.io.Serializable;

public class Bill implements Payable, Serializable {

    private int billId;
    private Appointment appointment;
    private double taxRate;
    private double totalAmount;

    public Bill(int billId, Appointment appointment, double taxRate) {

        this.billId = billId;
        this.appointment = appointment;
        this.taxRate = taxRate;

        calculateTotal();
    }

    private void calculateTotal() {

        double fee = appointment.getDoctor().getConsultationFee();

        totalAmount = fee + (fee * taxRate);
    }

    @Override
    public double generateBill() {
        return totalAmount;
    }

    public int getBillId() {
        return billId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Appointment getAppointment() {
        return appointment;
    }
}