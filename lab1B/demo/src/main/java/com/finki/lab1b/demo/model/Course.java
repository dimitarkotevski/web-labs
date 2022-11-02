package com.finki.lab1b.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class Course {
    String courseId;
    String name;
    String description;

    List<Student> students;

    public Course(String courseId, String name, String description, List<Student> students) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.students = students;
    }
}
