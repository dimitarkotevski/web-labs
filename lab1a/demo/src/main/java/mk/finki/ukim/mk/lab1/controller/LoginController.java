package mk.finki.ukim.mk.lab1.controller;

import mk.finki.ukim.mk.lab1.model.User;
import mk.finki.ukim.mk.lab1.model.exception.WrongCredentialsException;
import mk.finki.ukim.mk.lab1.repository.UserRepository;
import mk.finki.ukim.mk.lab1.service.interfaces.LoginService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;
    private final UserRepository userRepository;

    public LoginController(LoginService loginService, UserRepository userRepository) {
        this.loginService = loginService;
        this.userRepository = userRepository;
    }
    @GetMapping
    public String showLoginPage(){
        return "login";
    }

    @PostMapping
    public String tryLogin(@RequestParam String username,
                           @RequestParam String password,
                           Model model , HttpServletRequest request){
        User user=null;
        try{
            user=loginService.login(username,password);
            request.getSession().setAttribute("user",user);
            model.addAttribute("username",username);
            request.setAttribute("username",username);
            return "redirect:/balloons";
        }
        catch(WrongCredentialsException exception){
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login";

        }
    }
    @GetMapping("/logout")
    public String logoutUser(HttpServletRequest request) throws ServletException {
        request.getSession().removeAttribute("user");
        return "redirect:/login";
    }
}
