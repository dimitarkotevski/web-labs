//package mk.finki.ukim.mk.lab1.web.servlets;
//
//import mk.finki.ukim.mk.lab1.model.Balloon;
//import mk.finki.ukim.mk.lab1.service.interfaces.BalloonService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.ArrayList;
//
//@WebServlet(name="balloon-list-servlet", urlPatterns = "/servlet")
//public class BalloonListServlet extends HttpServlet {
//    private final SpringTemplateEngine springTemplateEngine;
//    private final BalloonService balloonService;
//
//
//    public BalloonListServlet(SpringTemplateEngine springTemplateEngine, BalloonService balloonService) {
//        this.springTemplateEngine = springTemplateEngine;
//        this.balloonService = balloonService;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        WebContext context = new WebContext(req, resp, req.getServletContext());
//        context.setVariable("balloons", this.balloonService.listAll());
//        this.springTemplateEngine.process("listBalloons.html", context, resp.getWriter());
//    }
//
//}
//
