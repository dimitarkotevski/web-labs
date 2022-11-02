package com.finki.lab1b.demo.web.servlet;

import com.finki.lab1b.demo.bootstrap.DataHolder;
import com.finki.lab1b.demo.service.interfaces.CourseService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//localhost:8080/listCourses
@WebServlet(name = "courses-list-servlet",urlPatterns = "/listCourses")
public class CoursesListServlet extends HttpServlet {
    //SpringTemplate od thymeleaf za da mozi da se pratat na html vo resource/templates/listCourses.html
    private final SpringTemplateEngine springTemplateEngine;
    private final CourseService courseService;

    public CoursesListServlet(SpringTemplateEngine springTemplateEngine, CourseService courseService) {
        this.springTemplateEngine = springTemplateEngine;
        this.courseService = courseService;
    }
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException {

        WebContext context=new WebContext(req,resp,req.getServletContext());
        context.setVariable("courses", this.courseService.getAllCourses());
        req.getSession().setAttribute("courses",this.courseService.getAllCourses());
        this.springTemplateEngine.process("listCourses.html",context,resp.getWriter());
    }
}
