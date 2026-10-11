package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.util.IdGenerator;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {
    private List<Enrollment> enrollments = new ArrayList<>();

    // Enroll a student in a course with a specified status (e.g., "ACTIVE")
    public Enrollment enrollStudent(int studentId, int courseId, String status) {
        int id = IdGenerator.getNextEnrollmentId();
        Enrollment enrollment = new Enrollment(id, studentId, courseId, status);
        enrollments.add(enrollment);
        return enrollment;
    }

    // Overloaded method: Default status as "ACTIVE" if not specified
    public Enrollment enrollStudent(int studentId, int courseId) {
        return enrollStudent(studentId, courseId, "ACTIVE");
    }

    // List all enrollments
    public List<Enrollment> listEnrollments() {
        return enrollments;
    }

    // Find enrollment by ID
    public Enrollment findEnrollmentById(int id) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getId() == id) {
                return enrollment;
            }
        }
        return null;
    }

    // Update enrollment status (e.g., to "COMPLETED" or "CANCELLED")
    public boolean updateEnrollmentStatus(int id, String newStatus) {
        Enrollment enrollment = findEnrollmentById(id);
        if (enrollment != null) {
            enrollment.setStatus(newStatus);
            return true;
        }
        return false;
    }
}