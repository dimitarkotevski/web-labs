package mk.finki.ukim.mk.lab1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("/logout")
public class LogoutController {
    @GetMapping
    public String logoutUser(HttpServletRequest request) throws ServletException {
        request.getSession().invalidate();
        return "redirect:/login";
    }
}
