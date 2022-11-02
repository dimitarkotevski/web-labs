package com.finki.lab1b.demo.service.impl;

import com.finki.lab1b.demo.bootstrap.DataHolder;
import com.finki.lab1b.demo.model.Course;
import com.finki.lab1b.demo.model.Student;
import com.finki.lab1b.demo.repository.CourseRepository;
import com.finki.lab1b.demo.service.interfaces.CourseService;
import com.finki.lab1b.demo.service.interfaces.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    //Implementacija na site methods od /interfaces/CourseService

    //repository za courses kade kje se povikuvaat method od tamu za promena na DataHolder primenilivite
    private final CourseRepository courseRepository;
    private final StudentService studentService;

    public CourseServiceImpl(CourseRepository courseRepository, StudentService studentService) {
        this.courseRepository = courseRepository;
        this.studentService = studentService;
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        return courseRepository.findAllStudentsByCourse(courseId);
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        DataHolder.courseList.stream().filter(c->c.getCourseId().equals(courseId)).findFirst().get()
                .getStudents().addAll(
                        new ArrayList<>(Collections.singleton(DataHolder.studentList.stream().filter(s -> s.getUsername().equals(username)).findFirst().get()))
                );
        return DataHolder.courseList.stream().filter(c->c.getCourseId().equals(String.valueOf(courseId))).findFirst().get();
    }

    @Override
    public List<Course> getAllCourses(){
        return this.courseRepository.findAllCourses();
    }
}
