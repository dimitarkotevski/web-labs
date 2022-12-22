package mk.finki.ukim.mk.lab1.controller;

import mk.finki.ukim.mk.lab1.model.ShoppingCard;
import mk.finki.ukim.mk.lab1.service.interfaces.ShoppingCardService;
import mk.finki.ukim.mk.lab1.service.interfaces.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/shopping-card")
public class ShoppingCardController {
    private final ShoppingCardService shoppingCardService;
    private final UserService userService;

    public ShoppingCardController(ShoppingCardService shoppingCardService, UserService userService) {
        this.shoppingCardService = shoppingCardService;
        this.userService = userService;
    }
    @PostMapping("/create")
    public String createShoppingCard(String dateTimeLocal, HttpServletRequest request){
        LocalDateTime localDateTime= LocalDateTime.parse(dateTimeLocal);
        ShoppingCard shoppingCard=new ShoppingCard();
        String user =request.getRemoteUser();
        shoppingCard.setUser(this.userService.getUserByUserName(user));
        shoppingCard.setDateCreated(localDateTime);
        shoppingCard.setOrders(null);
        this.shoppingCardService.saveShoppingCard(shoppingCard);
        return "redirect:/shopping-card";
    }

    @GetMapping()
    public String getShoppingCard(Model model, HttpServletRequest request){
        String user=request.getRemoteUser();
        if(user=="admin"){
            model.addAttribute("shoppingCards",this.shoppingCardService.getAllShoppingCardListed());
        }else{
            model.addAttribute("shoppingCards",this.userService.getUserByUserName(user).getCards());
        }
        model.addAttribute("username",user);
        return "shopping-card";
    }
    @GetMapping("/{id}")
    public String getShoppingCardInfo(@PathVariable Long id,Model model, HttpServletRequest request){
        ShoppingCard shoppingCard=this.shoppingCardService.getShoppingCardWithId(id);
        model.addAttribute("shoppingCard",shoppingCard);
        return "shopping-card-info";
    }
}
