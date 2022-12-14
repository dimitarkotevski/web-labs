package mk.finki.ukim.mk.lab1.controller;

import mk.finki.ukim.mk.lab1.model.Balloon;
import mk.finki.ukim.mk.lab1.model.Order;
import mk.finki.ukim.mk.lab1.model.ShoppingCard;
import mk.finki.ukim.mk.lab1.model.User;
import mk.finki.ukim.mk.lab1.service.interfaces.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final ShoppingCardService shoppingCardService;
    private final BalloonService balloonService;
    private final UserService userService;


        public OrderController(OrderService orderService, ShoppingCardService shoppingCardService, BalloonService balloonService, UserService userService) {
        this.orderService = orderService;
            this.shoppingCardService = shoppingCardService;
            this.balloonService = balloonService;
            this.userService = userService;
        }

    @GetMapping
    public String getOrders(Model model,HttpServletRequest request){
        model.addAttribute("user",request.getRemoteUser());
        model.addAttribute("orders",this.orderService.allOrders());
        model.addAttribute("shoppingCard",this.shoppingCardService.getAllShoppingCardListed());
        return "user-orders";
    }

    @PostMapping("/selectBalloon")
    public String selectBalloon(String name,Model model, HttpServletRequest request, HttpServletResponse response){
        model.addAttribute("user",request.getRemoteUser());
        model.addAttribute("name",name);
        request.getSession().setAttribute("name",name);
        return "select-balloon-size";
    }
    @PostMapping("/confirm-info")
    public String confirmInfo(String size,String name,Model model, HttpServletRequest request, HttpServletResponse response){
            User user =this.userService.getUserByUserName(request.getRemoteUser());
        model.addAttribute("user",user);
        String name1= (String) request.getSession().getAttribute("name");
        model.addAttribute("nameBalloon",name1);
        model.addAttribute("size",size);
        return "confirmation-info";
    }
    @GetMapping("/new-order")
    public String newOrder(String size,String name,Model model, HttpServletRequest request, HttpServletResponse response){
        name= String.valueOf(request.getSession().getAttribute("name"));
        model.addAttribute("user",request.getRemoteUser());
        model.addAttribute("name",name);
        model.addAttribute("size",size);
        request.getSession().setAttribute("size",size);

        String user=request.getRemoteUser();
        Balloon balloon=this.balloonService.searchByNameOrDescription(name);
        Order order=new Order();
        order.setUser(this.userService.getUserByUserName(user));
        order.setBalloon(balloon);
        this.orderService.save(order);
        return "redirect:/order";
    }
    //Put order in the shopping card
    @PostMapping("/toShoppingCard/{id}")
    public String putOrderInSelectedShoppingCard(@PathVariable Long id,String shoppingCardId,Model model,HttpServletRequest request){
        Order order=this.orderService.getOrderById(id);
        ShoppingCard shoppingCard=this.shoppingCardService.getShoppingCardWithId(Long.valueOf(shoppingCardId));
        shoppingCard.getOrders().add(order);
        order.getCards().add(shoppingCard);
        //this.orderService.save(order);
            this.shoppingCardService.saveShoppingCard(shoppingCard);
        return "redirect:http://localhost:8181/shopping-card/"+shoppingCardId;
    }
}
