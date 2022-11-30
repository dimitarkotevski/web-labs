package mk.finki.ukim.mk.lab1.web.servlets;

import mk.finki.ukim.mk.lab1.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab1.model.Balloon;
import mk.finki.ukim.mk.lab1.model.Order;
import mk.finki.ukim.mk.lab1.model.User;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "confirmation-info-servlet",urlPatterns = "/ConfirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;

    public ConfirmationInfoServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clientName = req.getParameter("clientName");
        String clientAddress = req.getParameter("clientAddress");
        String color=(String) req.getSession().getAttribute("color");
        String size=(String)req.getSession().getAttribute("size");
        User user=new User(clientAddress,"");
        Balloon balloon=new Balloon(color,size,null);
        Order order=new Order(balloon,user);
        String ipAddress=req.getRemoteAddr();
        String browser=req.getHeader("user-agent");
        if (clientName == null || clientName.isEmpty()){
            resp.sendRedirect("/servlet");
        }
        if(clientAddress==null || clientAddress.isEmpty()){
            resp.sendRedirect("/servlet");
        }
        req.getSession().setAttribute("size", size);
        req.getSession().setAttribute("color",color);
        req.getSession().setAttribute("clientName",clientName);
        req.getSession().setAttribute("clientAddress",clientAddress);
        req.getSession().setAttribute("ipAddress",ipAddress);
        req.getSession().setAttribute("browser",browser);
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("size", size);
        context.setVariable("color",color);
        context.setVariable("clientName", clientName);
        context.setVariable("clientAddress",clientAddress);
        context.setVariable("ipAddress", ipAddress);
        context.setVariable("browser",browser);
        springTemplateEngine.process("confirmationInfo.html", context, resp.getWriter());
        DataHolder.balloons.add(new Balloon( color,size,null));
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
