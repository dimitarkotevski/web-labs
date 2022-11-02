package com.finki.lab1b.demo.web.servlet;

import com.finki.lab1b.demo.bootstrap.DataHolder;
import com.finki.lab1b.demo.model.Student;
import com.finki.lab1b.demo.service.interfaces.CourseService;
import com.finki.lab1b.demo.service.interfaces.StudentService;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.util.ArrayUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;


@WebServlet(name = "student-list-servlet",urlPatterns = "/AddStudent")
public class ListStudentServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final CourseService courseService;
    private final StudentService studentService;

    public ListStudentServlet(SpringTemplateEngine springTemplateEngine, CourseService courseService, StudentService studentService) {
        this.springTemplateEngine = springTemplateEngine;
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context=new WebContext(req,resp, req.getServletContext());
        String courseId= req.getSession().getAttribute("courseId").toString();
        String username=req.getParameter("username");
        req.getSession().setAttribute("username",username);
        String password=req.getParameter("password");
        req.getSession().setAttribute("password",password);

        String name=req.getParameter("name");
        req.getSession().setAttribute("name",name);
        String surname=req.getParameter("surname");
        req.getSession().setAttribute("surname",surname);

        if(username!=null){
            this.studentService.save(username,password,name,surname);
        }
        List<Student> studentInCourse=this.courseService.listStudentsByCourse(Long.valueOf(courseId));
        List<Student> studentNotInCourse= DataHolder.studentList;
        studentNotInCourse.removeAll(studentInCourse);

        DataHolder.courseList.stream().filter(c->c.getCourseId().equals(courseId)).findFirst().get().setStudents(studentInCourse);


        context.setVariable("courseId",courseId);
        context.setVariable("studentInCourse",studentInCourse);
        context.setVariable("studentNotInCourse",studentNotInCourse);
        this.springTemplateEngine.process("listStudents.html",context,resp.getWriter());
        DataHolder.studentList.addAll(studentInCourse);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context=new WebContext(req,resp, req.getServletContext());
        String courseId=req.getParameter("courseId");
        req.getSession().setAttribute("courseId",courseId);
//        DataHolder dataHolder=new DataHolder();
        List<Student> studentInCourse=this.courseService.listStudentsByCourse(Long.valueOf(courseId));
        List<Student> studentNotInCourse= DataHolder.studentList;
        studentNotInCourse.removeAll(studentInCourse);

        req.setAttribute("courseId",courseId);
        context.setVariable("courseId",courseId);
        context.setVariable("studentInCourse",studentInCourse);
        context.setVariable("studentNotInCourse",studentNotInCourse);
        this.springTemplateEngine.process("listStudents.html",context,resp.getWriter());
        DataHolder.studentList.addAll(studentInCourse);
    }
}
