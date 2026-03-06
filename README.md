# MediTrack – Clinic & Appointment Management System

## Project Overview

MediTrack is a modular Clinic & Appointment Management System developed using Core Java.  
The system allows clinics to manage doctors, patients, appointments, and billing through a menu-driven console interface.

This project demonstrates strong implementation of Object-Oriented Programming (OOP) principles, Java Collections, Exception Handling, Design Patterns, and Java utility features.

The system is designed to simulate real-world clinic workflows including doctor registration, patient registration, appointment scheduling, appointment cancellation, and billing generation.

---

## Learning Objectives

This project demonstrates practical implementation of the following Java concepts:

- Java setup and JVM basics
- Object-Oriented Programming (OOP)
- Encapsulation
- Inheritance
- Polymorphism
- Abstraction
- Immutable classes
- Deep vs Shallow Copy
- Generics
- Java Collections
- Custom Exception Handling
- File I/O and CSV parsing
- Java Streams and Lambdas
- Singleton Design Pattern
- Strategy Pattern (Billing logic)
- Modular architecture

---

## Features

The MediTrack system provides the following functionalities:

### Doctor Management
- Register doctors
- Store doctor specialization
- Manage consultation fees
- Search doctors by name or specialization

### Patient Management
- Register patients
- Maintain patient medical information
- Search patient records

### Appointment Management
- Book appointments
- View appointment history
- Cancel appointments
- Track appointment status

### Billing System
- Generate bills for appointments
- Apply tax calculation
- Immutable bill summary generation

### System Features
- Menu-driven console interface
- Unique ID generation using Singleton
- Custom exception handling
- Generic data storage
- Modular package structure

---

## Project Architecture

The project follows a layered modular architecture.

```
Entity Layer      → Domain models
Service Layer     → Business logic
Utility Layer     → Helper classes
Exception Layer   → Custom exceptions
Interface Layer   → Abstraction contracts
Constants Layer   → Global configurations
```

This structure ensures clean code separation and maintainability.

---

## Project Structure

```
src/main/java/com/airtribe/meditrack

├── Main.java

├── constants
│   └── Constants.java

├── entity
│   ├── Person.java
│   ├── Doctor.java
│   ├── Patient.java
│   ├── Appointment.java
│   ├── Bill.java
│   └── BillSummary.java

├── enums
│   ├── Specialization.java
│   └── AppointmentStatus.java

├── service
│   ├── DoctorService.java
│   ├── PatientService.java
│   └── AppointmentService.java

├── util
│   ├── Validator.java
│   ├── DateUtil.java
│   ├── CSVUtil.java
│   ├── IdGenerator.java
│   ├── DataStore.java
│   └── AIHelper.java

├── exception
│   ├── AppointmentNotFoundException.java
│   └── InvalidDataException.java

├── interface
│   ├── Searchable.java
│   └── Payable.java

└── test
    └── TestRunner.java
```

---

## OOP Concepts Implemented

### Encapsulation
All entity fields are private and accessed through getter/setter methods.

### Inheritance
Doctor and Patient inherit from the base class Person.

### Polymorphism
Method overriding and interface implementations demonstrate polymorphic behavior.

### Abstraction
Interfaces such as Payable and Searchable define system contracts.

### Immutable Class
BillSummary is implemented as an immutable class.

### Cloning
Patient and Appointment demonstrate cloning behavior.

---

## Design Patterns Used

### Singleton Pattern

IdGenerator ensures only one instance manages ID generation.

Benefits:

- Prevents duplicate IDs
- Centralized ID management

### Strategy Pattern

Billing logic is implemented through the Payable interface.

---

## Technologies Used

- Java 17+
- Maven
- IntelliJ IDEA
- Git
- GitHub

---

## How to Run the Project

### Step 1 – Clone Repository

```
git clone https://github.com/your-username/meditrack.git
```

### Step 2 – Navigate to Project Folder

```
cd meditrack
```

### Step 3 – Build Project

```
mvn clean install
```

### Step 4 – Run Application

```
java com.airtribe.meditrack.Main
```

---

## Console Menu

```
===== MediTrack System =====

1. Register Doctor
2. Register Patient
3. Book Appointment
4. View Appointments
5. Cancel Appointment
6. Generate Bill
7. View Doctors
8. View Patients
9. Exit
```

---

## Example Execution

### Doctor Registration

```
Doctor Name: Krunal
Age: 28
Specialization: CARDIOLOGY
Consultation Fee: 500
Doctor registered successfully!
```

### Patient Registration

```
Patient Name: John
Age: 45
Disease: Fever
Patient registered successfully!
```

### Appointment Booking

```
Appointment booked successfully
Appointment{appointmentId=1, doctor=Krunal, patient=John, status=CONFIRMED}
```

### Billing

```
Bill Generated:
BillSummary{billId=1, patientName='John', totalAmount=590.0}
```

---

## Error Handling

The system includes custom exceptions:

- InvalidDataException – Thrown when invalid input data is provided
- AppointmentNotFoundException – Thrown when appointment ID is not found

These exceptions improve error management and maintain clean business logic.

---

## JVM Understanding

The project documentation includes a detailed JVM report covering:

- Class Loader Subsystem
- Runtime Data Areas (Heap, Stack, Method Area)
- Execution Engine
- JIT Compiler
- Garbage Collection
- Write Once Run Anywhere concept

---

## Documentation

Additional documentation is included in the docs folder:

```
docs
├── JVM_Report.md
├── Setup_Instructions.md
└── Design_Decisions.md
```

These files explain:

- Java environment setup
- JVM architecture
- System design decisions

---

## Future Enhancements

Possible improvements for the system include:

- Doctor schedule management
- Appointment conflict detection
- REST API using Spring Boot
- Database integration (MySQL/PostgreSQL)
- Web-based UI
- Email/SMS appointment notifications

---

## Author

**Krunal K K**

Java Developer  
Airtribe Java Program Participant