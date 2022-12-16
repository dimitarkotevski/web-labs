package mk.finki.ukim.mk.lab1.controller;

import mk.finki.ukim.mk.lab1.model.ShoppingCard;
import mk.finki.ukim.mk.lab1.model.User;
import mk.finki.ukim.mk.lab1.service.interfaces.ShoppingCardService;
import net.bytebuddy.asm.Advice;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/shopping-card")
public class ShoppingCardController {
    private final ShoppingCardService shoppingCardService;

    public ShoppingCardController(ShoppingCardService shoppingCardService) {
        this.shoppingCardService = shoppingCardService;
    }
    @PostMapping("/create")
    public String createShoppingCard(@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") String localDateTime, HttpServletRequest request, Model model) throws ParseException {
        ShoppingCard shoppingCard=new ShoppingCard();
        User user =(User) request.getSession().getAttribute("user");
        shoppingCard.setUser(user);
        shoppingCard.setDateCreated(LocalDateTime.parse(localDateTime));
        shoppingCard.setOrders(null);
        this.shoppingCardService.saveShoppingCard(shoppingCard);
//        List<ShoppingCard> shoppingCardList=this.shoppingCardService.getAllShoppingCardListed();
        model.addAttribute("shoppingCards",user.getCards());
        return "redirect:/shopping-card";
    }

    @GetMapping()
    public String getShoppingCard(Model model, HttpServletRequest request){
        User user=(User)request.getSession().getAttribute("user");
        model.addAttribute("shoppingCards",this.shoppingCardService.getAllShoppingCardFromWithUserId(user.getId()));
        model.addAttribute("username",user.getUsername());
        return "shopping-card";
    }
    @GetMapping("/{id}")
    public String getShoppingCardInfo(@PathVariable Long id,Model model){
        ShoppingCard shoppingCard=this.shoppingCardService.getShoppingCardWithId(id);
        model.addAttribute("shoppingCard",shoppingCard);
        return "shopping-card-info";
    }
}
