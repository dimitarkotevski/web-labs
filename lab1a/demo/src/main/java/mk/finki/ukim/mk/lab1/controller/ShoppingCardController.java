package mk.finki.ukim.mk.lab1.controller;

import mk.finki.ukim.mk.lab1.model.ShoppingCard;
import mk.finki.ukim.mk.lab1.model.User;
import mk.finki.ukim.mk.lab1.service.interfaces.ShoppingCardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/shopping-card")
public class ShoppingCardController {
    private final ShoppingCardService shoppingCardService;

    public ShoppingCardController(ShoppingCardService shoppingCardService) {
        this.shoppingCardService = shoppingCardService;
    }
    @GetMapping("/create")
    public String createShoppingCard(LocalDateTime localDateTime, HttpServletRequest request){
        ShoppingCard shoppingCard=new ShoppingCard();
        User user =(User) request.getSession().getAttribute("user");
        shoppingCard.setUser(user);
        shoppingCard.setDateCreated(localDateTime);
        shoppingCard.setOrders(null);
        this.shoppingCardService.saveShoppingCard(shoppingCard);
        return "redirect:/shopping-card";
    }

    @GetMapping()
    public String getShoppingCard(Model model, HttpServletRequest request){
        User user=(User)request.getSession().getAttribute("user");
        model.addAttribute("shoppingCards",user.getCards());
        model.addAttribute("username",user.getUsername());
        return "shopping-card";
    }
    @PostMapping("/{id}")
    public String getShoppingCardInfo(@PathVariable Long id,Model model){
        ShoppingCard shoppingCard=this.shoppingCardService.getShoppingCardWithId(id);
        model.addAttribute("shoppingCard",shoppingCard);
        return "shopping-card-info";
    }
}
