//package mk.finki.ukim.mk.lab1.web.servlets;
//
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;

//@WebServlet(name = "balloon-order-servlet",urlPatterns = "/BalloonOrder")
//public class BalloonOrderServlet extends HttpServlet {
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public BalloonOrderServlet(SpringTemplateEngine springTemplateEngine) {
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String size = req.getParameter("size");
//        String color=(String) req.getSession().getAttribute("color");
//        if (size == null || size.isEmpty()){
//            resp.sendRedirect("/servlet");
//        }
//        req.getSession().setAttribute("size", size);
//        req.getSession().setAttribute("color",color);
//        WebContext context = new WebContext(req, resp, req.getServletContext());
//        context.setVariable("size", size);
//        context.setVariable("color",color);
//        springTemplateEngine.process("deliveryInfo.html", context, resp.getWriter());
//    }
//}
