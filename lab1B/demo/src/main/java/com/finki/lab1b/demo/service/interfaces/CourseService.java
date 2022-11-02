package com.finki.lab1b.demo.service.interfaces;

import com.finki.lab1b.demo.model.Course;
import com.finki.lab1b.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    List<Student> listStudentsByCourse(Long courseId);
    Course addStudentInCourse(String username, Long courseId);
    List<Course> getAllCourses();
}
