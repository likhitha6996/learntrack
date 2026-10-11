package com.airtribe.learntrack.entity;

import java.time.LocalDate;

public class Enrollment {
    private int id;
    private int studentId;
    private int courseId;
    private LocalDate enrollmentDate;
    private String status; // e.g., "ACTIVE", "COMPLETED", "CANCELLED"

    // Parameterized Constructor
    public Enrollment(int id, int studentId, int courseId, String status) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = LocalDate.now(); // Automatically captures current date
        this.status = status;
    }

    // Encapsulation Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Enrollment [ID=" + id + ", StudentID=" + studentId + ", CourseID=" + courseId +
                ", Date=" + enrollmentDate + ", Status=" + status + "]";
    }
}