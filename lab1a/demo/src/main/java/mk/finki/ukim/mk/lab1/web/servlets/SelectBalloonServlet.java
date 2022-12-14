//package mk.finki.ukim.mk.lab1.web.servlets;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "select-balloon-servlet",urlPatterns = "/selectBalloonSize")
//public class SelectBalloonServlet extends HttpServlet {
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public SelectBalloonServlet(SpringTemplateEngine springTemplateEngine) {
//        this.springTemplateEngine = springTemplateEngine;
//    }
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String color = req.getParameter("color");
//        if (color == null || color.isEmpty()){
//            resp.sendRedirect("/servlet");
//        }
//        req.getSession().setAttribute("color", color);
//        WebContext context = new WebContext(req, resp, req.getServletContext());
//        context.setVariable("color", color);
//        springTemplateEngine.process("select-balloon-size.html", context, resp.getWriter());
//    }
//}
