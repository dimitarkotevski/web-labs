package mk.finki.ukim.mk.lab1.controller;

import mk.finki.ukim.mk.lab1.model.User;
import mk.finki.ukim.mk.lab1.model.exception.WrongCredentialsException;
import mk.finki.ukim.mk.lab1.service.interfaces.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
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
            return "redirect:/balloons";
        }
        catch(WrongCredentialsException exception){
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login";

        }
    }
}
