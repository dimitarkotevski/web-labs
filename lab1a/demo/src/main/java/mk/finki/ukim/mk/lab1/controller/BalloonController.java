package mk.finki.ukim.mk.lab1.controller;

import mk.finki.ukim.mk.lab1.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab1.model.Balloon;
import mk.finki.ukim.mk.lab1.model.Manufacture;
import mk.finki.ukim.mk.lab1.service.interfaces.BalloonService;
import mk.finki.ukim.mk.lab1.service.interfaces.ManufacturerService;
import mk.finki.ukim.mk.lab1.service.interfaces.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/balloons")
public class BalloonController {
    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;
    private final OrderService orderService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService, OrderService orderService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
        this.orderService = orderService;
    }

    @GetMapping()
    public String getBalloonPage(@RequestParam(required = false) String error,
                                 Model model, HttpServletRequest request){
        model.addAttribute("hasError",true);
        if(error!=null && !error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        if(DataHolder.order){
            model.addAttribute("balloons",this.balloonService.balloonOrderAsc());
        }else{
            model.addAttribute("balloons",this.balloonService.balloonOrderDesc());
        }
        model.addAttribute("user",request.getRemoteUser());
        return "listBalloons";
    }
    @GetMapping("/changeOrder")
    public String changeOrder(Model model, HttpServletRequest request){
//        if(DataHolder.order){
//            request.getSession().removeAttribute("balloons");
//            request.getSession().setAttribute("balloons",this.balloonService.balloonOrderAsc());
//        }else{
//            request.getSession().removeAttribute("balloons");
//            request.getSession().setAttribute("balloons",this.balloonService.balloonOrderDesc());
//        }
        DataHolder.order=!DataHolder.order;
        return "redirect:/balloons";
    }

    @PostMapping("/add")
    public String saveBalloon(@RequestParam String name,@RequestParam String description,@RequestParam Long manufactureId){
        Manufacture manu=this.manufacturerService.findById(manufactureId);
        this.balloonService.addBalloon(name,description, manu);
        return "redirect:/balloons";
    }
    @GetMapping("/add")
    public String addBalloon(Model model){
        model.addAttribute("manufactures",this.manufacturerService.findAll());
        return "add-balloon";
    }

    @PostMapping("/edit/{id}")
    public String editBalloon(@PathVariable Long id, @RequestParam String name,@RequestParam String description,@RequestParam Long manufacture){
        Manufacture manu=this.manufacturerService.findById(manufacture);
        this.balloonService.changeBalloon(id,name,description,manu);
        return "redirect:/balloons";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        balloonService.deleteBalloon(id);
        return "redirect:/balloons";
    }

    @GetMapping("edit-form/{id}")
    public String getEditBalloonPage(@PathVariable Long id,Model model){
        Balloon balloon=null;
        try{
            if(this.balloonService.findBalloonById(id)==null){
                return "redirect:/balloons";
            }
            balloon=this.balloonService.findBalloonById(id);
            List<Manufacture> manufactureList =this.manufacturerService.findAll();

            model.addAttribute("balloon",balloon);
            model.addAttribute("manufactures", manufactureList);

            return "edit-balloon";

        }catch (Exception ex){
            model.addAttribute("error",ex.getMessage());
            return "redirect:/balloons?error="+ex.getMessage();
        }

    }
    @GetMapping("/add-form")
    public String getAddBalloonPage(Model model){
        List<Manufacture> manufacturers = this.manufacturerService.findAll();
        model.addAttribute("manufacturers", manufacturers);
        return "add-balloon";
    }
    @GetMapping("/orders")
    public String getOrders(Model model){
        model.addAttribute("orders",this.orderService.allOrders());
        return "user-orders";
    }

}
