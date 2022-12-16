package mk.finki.ukim.mk.lab1.controller;

import mk.finki.ukim.mk.lab1.model.Balloon;
import mk.finki.ukim.mk.lab1.model.Order;
import mk.finki.ukim.mk.lab1.model.ShoppingCard;
import mk.finki.ukim.mk.lab1.model.User;
import mk.finki.ukim.mk.lab1.service.interfaces.BalloonService;
import mk.finki.ukim.mk.lab1.service.interfaces.OrderService;
import mk.finki.ukim.mk.lab1.service.interfaces.ShoppingCardService;
import org.postgresql.core.Parser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final ShoppingCardService shoppingCardService;
    private final BalloonService balloonService;

        public OrderController(OrderService orderService, ShoppingCardService shoppingCardService, BalloonService balloonService) {
        this.orderService = orderService;
            this.shoppingCardService = shoppingCardService;
            this.balloonService = balloonService;
    }

    @GetMapping
    public String getOrders(Model model,HttpServletRequest request){
            User user=(User)request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        model.addAttribute("orders",this.orderService.allOrders());
        model.addAttribute("listShoppingCards", this.shoppingCardService.getAllShoppingCardFromWithUserId(user.getId()));
        return "user-orders";
    }

    @PostMapping("/selectBalloon")
    public String selectBalloon(String name,Model model, HttpServletRequest request, HttpServletResponse response){
        model.addAttribute("user",request.getSession().getAttribute("user"));
        model.addAttribute("name",name);
        request.getSession().setAttribute("name",name);
        return "select-balloon-size";
    }
    @PostMapping("/confirm-info")
    public String confirmInfo(String size,String name,Model model, HttpServletRequest request, HttpServletResponse response){
        model.addAttribute("user",request.getSession().getAttribute("user"));
        model.addAttribute("name",request.getSession().getAttribute("name"));
        model.addAttribute("size",size);
        return "confirmation-info";
    }
    @GetMapping("/new-order")
    public String newOrder(String size,String name,Model model, HttpServletRequest request, HttpServletResponse response){
        name= String.valueOf(request.getSession().getAttribute("name"));
        model.addAttribute("user",request.getSession().getAttribute("user"));
        model.addAttribute("name",name);
        model.addAttribute("size",size);
        request.getSession().setAttribute("size",size);

        User user=(User)request.getSession().getAttribute("user");
        Balloon balloon=this.balloonService.searchByNameOrDescription(name);
        Order order=new Order();
        order.setUser(user);
        order.setBalloon(balloon);
        this.orderService.save(order);
        return "redirect:/order";
    }
    //Put order in the shopping card
    @PostMapping("/toShoppingCard")
    public String getOrderInfo(String orderId, String shoppingCardId,Model model,HttpServletRequest request){
            Order order=this.orderService.getOrderById(Long.parseLong(orderId));
            model.addAttribute("order",order);
            ShoppingCard shoppingCard=shoppingCardService.getShoppingCardWithId(Long.valueOf(shoppingCardId));
            List<Order> orderList=shoppingCard.getOrders();
            orderList.add(order);
            //shoppingCard.setOrders(orderList);
            this.shoppingCardService.saveShoppingCard(shoppingCard);
            return "redirect:/order";
    }
}
