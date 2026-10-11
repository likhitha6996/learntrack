package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.util.IdGenerator;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    // Overloaded Method Version 1: Add a fully formed Student object
    public void addStudent(Student student) {
        students.add(student);
    }

    // Overloaded Method Version 2: Convenience method taking raw details (Method Overloading example)
    public void addStudent(String firstName, String lastName, String email, String batch) {
        int id = IdGenerator.getNextStudentId();
        Student newStudent = new Student(id, firstName, lastName, email, batch);
        students.add(newStudent);
    }

    // List all students
    public List<Student> listStudents() {
        return students;
    }

    // Find student by ID
    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; // Returned if not found
    }

    // Update student details
    public boolean updateStudent(int id, String newBatch, boolean activeStatus) {
        Student student = findStudentById(id);
        if (student != null) {
            student.setBatch(newBatch);
            student.setActive(activeStatus);
            return true;
        }
        return false;
    }

    // Soft delete (Deactivate student by setting active = false)
    public boolean removeStudent(int id) {
        Student student = findStudentById(id);
        if (student != null) {
            student.setActive(false); // Soft deletion as per requirement
            return true;
        }
        return false;
    }
}