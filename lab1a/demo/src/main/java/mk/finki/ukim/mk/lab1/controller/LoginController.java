package mk.finki.ukim.mk.lab1.controller;

import mk.finki.ukim.mk.lab1.model.ShoppingCard;
import mk.finki.ukim.mk.lab1.model.User;
import mk.finki.ukim.mk.lab1.model.UserFullname;
import mk.finki.ukim.mk.lab1.model.exception.WrongCredentialsException;
import mk.finki.ukim.mk.lab1.repository.UserRepository;
import mk.finki.ukim.mk.lab1.service.interfaces.LoginService;
import mk.finki.ukim.mk.lab1.service.interfaces.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;
    private final UserRepository userRepository;
    private final UserService userService;

    public LoginController(LoginService loginService, UserRepository userRepository, UserService userService) {
        this.loginService = loginService;
        this.userRepository = userRepository;
        this.userService = userService;
    }
    @GetMapping
    public String showLoginPage(){
        return "login";
    }
    @PostMapping("/register")
    public void registerUser(String name, String username, UserFullname personFullName, String password, LocalDateTime dateOfBirth, List<ShoppingCard> cards ){
        User user=new User(name,username,personFullName,password,dateOfBirth,cards);
        this.userService.register(user);
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
    @GetMapping("/login?error=BadCredentials")
    public String errorShow(){
        return "";
    }
}
