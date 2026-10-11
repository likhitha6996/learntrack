package com.airtribe.learntrack;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        boolean running = true;
        while (running) {
            System.out.println("\n========================================");
            System.out.println("       LEARNTRACK MANAGEMENT SYSTEM     ");
            System.out.println("========================================");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("4. Exit");
            System.out.print("Select an option (1-4): ");

            try {
                int mainChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (mainChoice) {
                    case 1:
                        handleStudentMenu(scanner, studentService);
                        break;
                    case 2:
                        handleCourseMenu(scanner, courseService);
                        break;
                    case 3:
                        handleEnrollmentMenu(scanner, studentService, courseService, enrollmentService);
                        break;
                    case 4:
                        running = false;
                        System.out.println("Exiting LearnTrack. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option! Please choose between 1 and 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("[Error]: Please enter a valid numeric option.");
                scanner.nextLine(); // Clear bad input from scanner buffer
            } catch (EntityNotFoundException e) {
                System.out.println("[Notice]: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("[Unexpected Error]: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void handleStudentMenu(Scanner scanner, StudentService studentService) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add New Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Deactivate Student");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter First Name: ");
                    String fName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lName = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Batch: ");
                    String batch = scanner.nextLine();

                    studentService.addStudent(fName, lName, email, batch);
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    System.out.println("\n-- Student List --");
                    if (studentService.listStudents().isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student s : studentService.listStudents()) {
                            System.out.println(s);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter Student ID to Search: ");
                    int sId = scanner.nextInt();
                    Student found = studentService.findStudentById(sId);
                    if (found == null) {
                        throw new EntityNotFoundException("Student with ID " + sId + " was not found!");
                    }
                    System.out.println("Found: " + found);
                    break;
                case 4:
                    System.out.print("Enter Student ID to Deactivate: ");
                    int dId = scanner.nextInt();
                    boolean success = studentService.removeStudent(dId);
                    if (!success) {
                        throw new EntityNotFoundException("Student with ID " + dId + " not found for deactivation.");
                    }
                    System.out.println("Student deactivated successfully!");
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void handleCourseMenu(Scanner scanner, CourseService courseService) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Course Management ---");
            System.out.println("1. Add New Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Toggle Course Status (Active/Inactive)");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Course Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Enter Duration in Weeks: ");
                    int weeks = scanner.nextInt();

                    courseService.addCourse(name, desc, weeks);
                    System.out.println("Course added successfully!");
                    break;
                case 2:
                    System.out.println("\n-- Course List --");
                    if (courseService.listCourses().isEmpty()) {
                        System.out.println("No courses found.");
                    } else {
                        for (Course c : courseService.listCourses()) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter Course ID to toggle status: ");
                    int cId = scanner.nextInt();
                    Course c = courseService.findCourseById(cId);
                    if (c == null) {
                        throw new EntityNotFoundException("Course with ID " + cId + " not found!");
                    }
                    c.setActive(!c.isActive());
                    System.out.println("Course status updated! Active: " + c.isActive());
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void handleEnrollmentMenu(Scanner scanner, StudentService studentService, CourseService courseService, EnrollmentService enrollmentService) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Enrollment Management ---");
            System.out.println("1. Enroll Student in Course");
            System.out.println("2. View All Enrollments");
            System.out.println("3. Update Enrollment Status (ACTIVE, COMPLETED, CANCELLED)");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int sId = scanner.nextInt();
                    if (studentService.findStudentById(sId) == null) {
                        throw new EntityNotFoundException("Cannot enroll. Student ID " + sId + " does not exist!");
                    }

                    System.out.print("Enter Course ID: ");
                    int cId = scanner.nextInt();
                    scanner.nextLine();
                    if (courseService.findCourseById(cId) == null) {
                        throw new EntityNotFoundException("Cannot enroll. Course ID " + cId + " does not exist!");
                    }

                    System.out.print("Enter Status (ACTIVE / COMPLETED / CANCELLED): ");
                    String status = scanner.nextLine().toUpperCase();

                    Enrollment en = enrollmentService.enrollStudent(sId, cId, status);
                    System.out.println("Enrollment successful! Details: " + en);
                    break;
                case 2:
                    System.out.println("\n-- Enrollment List --");
                    if (enrollmentService.listEnrollments().isEmpty()) {
                        System.out.println("No enrollments found.");
                    } else {
                        for (Enrollment e : enrollmentService.listEnrollments()) {
                            System.out.println(e);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter Enrollment ID to update: ");
                    int eId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Status (ACTIVE, COMPLETED, CANCELLED): ");
                    String newStatus = scanner.nextLine().toUpperCase();

                    boolean updated = enrollmentService.updateEnrollmentStatus(eId, newStatus);
                    if (!updated) {
                        throw new EntityNotFoundException("Enrollment with ID " + eId + " not found!");
                    }
                    System.out.println("Enrollment status updated successfully!");
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}