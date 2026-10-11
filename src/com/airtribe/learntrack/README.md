# LearnTrack - Student & Course Management System

LearnTrack is a robust, console-based Java application designed to manage students, courses, and enrollments using a clean **layered architecture** and strict **Object-Oriented Programming (OOP)** principles.

## Features
- **Student Management:** Add, view, search by ID, and deactivate students.
- **Course Management:** Add, view, and toggle active/inactive status for courses.
- **Enrollment Management:** Enroll students in courses, view active enrollments, and update statuses (`ACTIVE`, `COMPLETED`, `CANCELLED`).
- **Robust Exception Handling:** Gracefully handles invalid menu inputs and missing entities using a custom `EntityNotFoundException`.

---
## How to compile and run
     Compilation :  Open your terminal in the root directory containing the com folder and run:
   javac com/airtribe/learntrack/**/*.java com/airtribe/learntrack/*.java
    Execution
    Run the main application entry point:
   java com.airtribe.learntrack.Main
## Project Structure & Layered Architecture
```text
com.airtribe.learntrack
│
├── entity/             # Domain data models
│   ├── Person.java
│   ├── Student.java
│   ├── Course.java
│   └── Enrollment.java
│
├── service/            # Business logic & in-memory data management
│   ├── StudentService.java
│   ├── CourseService.java
│   └── EnrollmentService.java
│
├── util/               # Shared utilities
│   └── IdGenerator.java
│
├── exception/          # Custom exceptions
│   └── EntityNotFoundException.java
│
└── Main.java           # Console UI & application entry point
## Class Diagram
+------------------+ 
       |      Person      |
       +------------------+
       | - id             |
       | - firstName      |
       | - lastName       |
       | - email          |
       +------------------+
                ▲
                │ (Inheritance)
       +------------------+           +------------------+           +------------------+
       |     Student      |           |      Course      |           |    Enrollment    |
       +------------------+           +------------------+           +------------------+
       | - batch          |           | - courseName     |           | - studentId      |
       | - active         |           | - durationInWeeks|           | - courseId       |
       +------------------+           +------------------+           | - status         |
                                                                     +------------------+
                │                              │                              │
                ▼                              ▼                              ▼
     +--------------------+         +--------------------+         +--------------------+
     |   StudentService   |         |   CourseService    |         | EnrollmentService  |
     +--------------------+         +--------------------+         +--------------------+
                │                              │                              │
                └───────────────┬──────────────┘                              │
                                │                                             │
                                ▼                                             ▼
                        +---------------+                             +---------------+
                        |  IdGenerator  |◄────────────────────────────|  Main (UI)    |
                        +---------------+                             +---------------+
```