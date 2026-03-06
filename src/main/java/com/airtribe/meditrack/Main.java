package com.airtribe.meditrack;

import com.airtribe.meditrack.entity.*;
import com.airtribe.meditrack.enums.*;
import com.airtribe.meditrack.exception.AppointmentNotFoundException;
import com.airtribe.meditrack.service.*;
import com.airtribe.meditrack.util.IdGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static DoctorService doctorService = new DoctorService();
	private static PatientService patientService = new PatientService();
	private static AppointmentService appointmentService = new AppointmentService();

	private static IdGenerator idGenerator = IdGenerator.getInstance();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.println("\n===== MediTrack System =====");

			System.out.println("1. Register Doctor");
			System.out.println("2. Register Patient");
			System.out.println("3. Book Appointment");
			System.out.println("4. View Appointments");
			System.out.println("5. Cancel Appointment");
			System.out.println("6. Generate Bill");
			System.out.println("7. View Doctors");
			System.out.println("8. View Patients");
			System.out.println("9. Exit");

			System.out.print("Choose option: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			try {

				switch (choice) {

					case 1 -> registerDoctor(scanner);

					case 2 -> registerPatient(scanner);

					case 3 -> bookAppointment(scanner);

					case 4 -> viewAppointments();

					case 5 -> cancelAppointment(scanner);

					case 6 -> generateBill(scanner);

					case 7 -> viewDoctors();

					case 8 -> viewPatients();

					case 9 -> {
						System.out.println("Exiting MediTrack...");
						System.exit(0);
					}

					default -> System.out.println("Invalid option");

				}

			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}

		}
	}

	private static void registerDoctor(Scanner scanner) {

		System.out.print("Doctor Name: ");
		String name = scanner.nextLine();

		System.out.print("Age: ");
		int age = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Specializations:");
		for (Specialization s : Specialization.values()) {
			System.out.println(s);
		}

		System.out.print("Choose specialization: ");
		String spec = scanner.nextLine();

		System.out.print("Consultation Fee: ");
		double fee = scanner.nextDouble();

		Doctor doctor = new Doctor(
				idGenerator.generateDoctorId(),
				name,
				age,
				Specialization.valueOf(spec.toUpperCase()),
				fee
		);

		doctorService.addDoctor(doctor);

		System.out.println("Doctor registered successfully!");
	}

	private static void registerPatient(Scanner scanner) {

		System.out.print("Patient Name: ");
		String name = scanner.nextLine();

		System.out.print("Age: ");
		int age = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Disease: ");
		String disease = scanner.nextLine();

		Patient patient = new Patient(
				idGenerator.generatePatientId(),
				name,
				age,
				disease
		);

		patientService.addPatient(patient);

		System.out.println("Patient registered successfully!");
	}

	private static void bookAppointment(Scanner scanner) {

		System.out.print("Patient ID: ");
		int patientId = scanner.nextInt();

		System.out.print("Doctor ID: ");
		int doctorId = scanner.nextInt();

		scanner.nextLine();

		Patient patient = patientService.getPatientById(patientId);

		Doctor doctor = doctorService.getAllDoctors()
				.stream()
				.filter(d -> d.getId() == doctorId)
				.findFirst()
				.orElse(null);

		if (patient == null || doctor == null) {
			System.out.println("Doctor or Patient not found!");
			return;
		}

		Appointment appointment = appointmentService.bookAppointment(
				idGenerator.generateAppointmentId(),
				doctor,
				patient,
				LocalDateTime.now()
		);

		System.out.println("Appointment booked: " + appointment);
	}

	private static void viewAppointments() {

		List<Appointment> appointments = appointmentService.getAllAppointments();

		if (appointments.isEmpty()) {
			System.out.println("No appointments found");
		} else {
			appointments.forEach(System.out::println);
		}

	}

	private static void cancelAppointment(Scanner scanner) throws AppointmentNotFoundException {

		System.out.print("Enter Appointment ID: ");

		int id = scanner.nextInt();

		appointmentService.cancelAppointment(id);

		System.out.println("Appointment cancelled successfully");
	}

	private static void generateBill(Scanner scanner) {

		System.out.print("Enter Appointment ID: ");
		int id = scanner.nextInt();

		Appointment appointment = appointmentService.getAllAppointments()
				.stream()
				.filter(a -> a.getAppointmentId() == id)
				.findFirst()
				.orElse(null);

		if (appointment == null) {
			System.out.println("Appointment not found");
			return;
		}

		Bill bill = appointmentService.generateBill(
				appointment,
				idGenerator.generateBillId()
		);

		BillSummary summary = new BillSummary(
				bill.getBillId(),
				appointment.getPatient().getName(),
				bill.getTotalAmount()
		);

		System.out.println("Bill Generated:");
		System.out.println(summary);

	}

	private static void viewDoctors() {

		doctorService.getAllDoctors()
				.forEach(System.out::println);

	}

	private static void viewPatients() {

		patientService.getAllPatients()
				.forEach(System.out::println);

	}

}