package mk.finki.ukim.mk.lab1.bootstrap;

import mk.finki.ukim.mk.lab1.model.Balloon;
import mk.finki.ukim.mk.lab1.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Balloon> balloons = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();

    @PostConstruct
    public void init(){
        //Data
        balloons.add(new Balloon("balon1","balon1 description"));
        balloons.add(new Balloon("balon2","balon2 description"));
        balloons.add(new Balloon("balon3","balon3 description"));
        balloons.add(new Balloon("balon4","balon4 description"));
        balloons.add(new Balloon("balon5","balon5 description"));

        orders.add(new Order("red","10","Dime","Demir Hisar"));
        orders.add(new Order("green","15","Ivan","Debar"));
        orders.add(new Order("blue","6","Ace","Demir Kapija"));
        orders.add(new Order("yellow","20","Miki","Bitola"));
        orders.add(new Order("white","16","Tija","Skopje"));
    }
}
