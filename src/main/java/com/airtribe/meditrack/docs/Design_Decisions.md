
Content:

```markdown
# Design Decisions – MediTrack System

## 1. Layered Architecture

The system follows a modular layered architecture:

Entity Layer – Domain models such as Doctor, Patient, Appointment  
Service Layer – Business logic for managing entities  
Utility Layer – Common helper classes like validation, CSV parsing, and ID generation

This separation improves maintainability and scalability.

---

## 2. Inheritance

A base abstract class **Person** is used for common attributes:

- id
- name
- age

Doctor and Patient extend this class to reuse common logic.

---

## 3. Immutable Class

`BillSummary` is implemented as an immutable class.

Reasons:
- Ensures thread safety
- Prevents accidental modification
- Represents final billing information

Rules followed:
- class declared `final`
- fields declared `final`
- no setter methods

---

## 4. Singleton Pattern

`IdGenerator` uses the Singleton pattern to ensure that only one instance manages ID generation across the system.

Benefits:
- Prevent duplicate IDs
- Centralized control
- Thread-safe ID generation

---

## 5. Generics

A generic class `DataStore<T>` is used to manage collections of objects.

Advantages:
- Code reuse
- Type safety
- Reduced duplication

---

## 6. Enums Instead of Strings

Enums are used for:

- `Specialization`
- `AppointmentStatus`

Advantages:
- Type safety
- Prevent invalid values
- Cleaner code

---

## 7. Custom Exceptions

Two custom exceptions were created:

- `InvalidDataException`
- `AppointmentNotFoundException`

This improves error handling and keeps business logic clean.

---

## 8. Java Streams

Java Streams are used for searching and filtering doctors and patients.

Benefits:
- Cleaner code
- Functional programming style
- Better readability