package mk.finki.ukim.mk.lab1.bootstrap;

import mk.finki.ukim.mk.lab1.model.Balloon;
import mk.finki.ukim.mk.lab1.model.Manufacture;
import mk.finki.ukim.mk.lab1.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Balloon> balloons = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();
    public static List<Manufacture> manufactures =new ArrayList<>();

    @PostConstruct
    public void init(){
        Manufacture manufacture = new Manufacture("Dimitar Manufacture","Macedonia","Orce Nikolov,Skopje");
        Manufacture manufacture1 = new Manufacture("Sandra Manufacture","Bulgaria","Makedonska,Sofia");
        Manufacture manufacture2 = new Manufacture("Tija Manufacture","Bulgaria","Makedonska,Sofia");
        manufactures.add(manufacture);
        manufactures.add(manufacture1);
        manufactures.add(manufacture2);

        //Data
        balloons.add(new Balloon("balon1","balon1 description", manufacture));
        balloons.add(new Balloon("balon2","balon2 description", manufacture2));
        balloons.add(new Balloon("balon3","balon3 description", manufacture1));
        balloons.add(new Balloon("balon4","balon4 description", manufacture1));
        balloons.add(new Balloon("balon5","balon5 description", manufacture1));

        orders.add(new Order("red","10","Dime","Demir Hisar"));
        orders.add(new Order("green","15","Ivan","Debar"));
        orders.add(new Order("blue","6","Ace","Demir Kapija"));
        orders.add(new Order("yellow","20","Miki","Bitola"));
        orders.add(new Order("white","16","Tija","Skopje"));
    }
}
