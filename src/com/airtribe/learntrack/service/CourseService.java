package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.util.IdGenerator;
import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private List<Course> courses = new ArrayList<>();

    // Add a pre-formed Course object
    public void addCourse(Course course) {
        courses.add(course);
    }

    // Convenience method using IdGenerator for auto-incrementing course IDs
    public void addCourse(String courseName, String description, int durationInWeeks) {
        int id = IdGenerator.getNextCourseId();
        Course newCourse = new Course(id, courseName, description, durationInWeeks);
        courses.add(newCourse);
    }

    // List all courses
    public List<Course> listCourses() {
        return courses;
    }

    // Find a course by its ID
    public Course findCourseById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }
}