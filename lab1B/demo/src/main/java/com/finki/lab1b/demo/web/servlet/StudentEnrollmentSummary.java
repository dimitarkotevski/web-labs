package com.finki.lab1b.demo.web.servlet;

import com.finki.lab1b.demo.bootstrap.DataHolder;
import com.finki.lab1b.demo.model.Course;
import com.finki.lab1b.demo.model.Student;
import com.finki.lab1b.demo.service.interfaces.CourseService;
import com.finki.lab1b.demo.service.interfaces.StudentService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "student-enrollment-summary",urlPatterns = "/StudentEnrollmentSummary")
public class StudentEnrollmentSummary extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final CourseService courseService;
    private final StudentService studentService;

    public StudentEnrollmentSummary(SpringTemplateEngine springTemplateEngine, CourseService courseService, StudentService studentService) {
        this.springTemplateEngine = springTemplateEngine;
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context=new WebContext(req,resp,req.getServletContext());
        this.springTemplateEngine.process("studentInCourse.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context=new WebContext(req,resp,req.getServletContext());

        String username=req.getParameter("username");


        String courseId= String.valueOf(req.getSession().getAttribute("courseId"));

        ArrayList<Student> student= new ArrayList<>(DataHolder.studentList.stream().filter(s->s.getUsername().equals(username)).toList());
        ArrayList<Student> studentInCourse= new ArrayList<>( this.courseService.listStudentsByCourse(Long.valueOf(courseId)) );
        studentInCourse.addAll(student);

        DataHolder.courseList.stream().filter(c->c.getCourseId().equals(courseId)).findFirst().get().setStudents(studentInCourse);
        Course course=DataHolder.courseList.stream().filter(c->c.getCourseId().equals(courseId)).findFirst().get();

        context.setVariable("courseName",course.getName());
        context.setVariable("students",course.getStudents());

        this.springTemplateEngine.process("studentInCourse.html",context,resp.getWriter());
    }
}
