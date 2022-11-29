package mk.finki.ukim.mk.lab1.bootstrap;

import mk.finki.ukim.mk.lab1.model.Balloon;
import mk.finki.ukim.mk.lab1.model.Manufacture;
import mk.finki.ukim.mk.lab1.model.Order;
import mk.finki.ukim.mk.lab1.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
//
@Component
public class DataHolder {
    public static List<Balloon> balloons = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();
    public static List<Manufacture> manufactures =new ArrayList<>();
    public static List<User> users=new ArrayList<>();

    public static boolean order=true;

    @PostConstruct
    public void init(){
        Manufacture manufacture = new Manufacture("Dimitar Manufacture","Macedonia","Orce Nikolov,Skopje");
        Manufacture manufacture1 = new Manufacture("Sandra Manufacture","Bulgaria","Makedonska,Sofia");
        Manufacture manufacture2 = new Manufacture("Tija Manufacture","Bulgaria","Makedonska,Sofia");
        manufactures.add(manufacture);
        manufactures.add(manufacture1);
        manufactures.add(manufacture2);

        //Data
        balloons.add(new Balloon("A3","balon1 description", manufacture));
        balloons.add(new Balloon("Z","balon2 description", manufacture2));
        balloons.add(new Balloon("A1","balon3 description", manufacture1));
        balloons.add(new Balloon("C","balon4 description", manufacture1));
        balloons.add(new Balloon("M5","balon5 description", manufacture1));

        orders.add(new Order("red","10","Dime","Demir Hisar"));
        orders.add(new Order("green","15","Ivan","Debar"));
        orders.add(new Order("blue","6","Ace","Demir Kapija"));
        orders.add(new Order("yellow","20","Miki","Bitola"));
        orders.add(new Order("white","16","Tija","Skopje"));

        User user=new User("dime","dime");
        users.add(user);
    }
}
