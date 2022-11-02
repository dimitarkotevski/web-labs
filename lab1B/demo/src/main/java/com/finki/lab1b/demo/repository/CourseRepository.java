package com.finki.lab1b.demo.repository;

import com.finki.lab1b.demo.bootstrap.DataHolder;
import com.finki.lab1b.demo.model.Course;
import com.finki.lab1b.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  class CourseRepository {

    public List<Course> findAllCourses(){
        return DataHolder.courseList;
    }
    public Course findById(Long courseId){
        return DataHolder.courseList.stream().filter(c->c.getCourseId().equals(String.valueOf(courseId))).findFirst().get();
    }
    public List<Student> findAllStudentsByCourse(Long courseId){
        return DataHolder.courseList.stream().filter(c->
                c.getCourseId().equals( String.valueOf(courseId))
        ).findFirst().get().getStudents();
    }
    public Course addStudentToCourse(Student student, Course course){
        DataHolder.courseList.stream().filter(c->c==course).findFirst().get().getStudents().add(student);
        return course;
    }
}
