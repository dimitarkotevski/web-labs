package mk.finki.ukim.mk.lab1.bootstrap;

import mk.finki.ukim.mk.lab1.model.Balloon;
import mk.finki.ukim.mk.lab1.model.Manufacture;
import mk.finki.ukim.mk.lab1.model.Order;
import mk.finki.ukim.mk.lab1.model.User;
import mk.finki.ukim.mk.lab1.repository.BalloonRepository;
import mk.finki.ukim.mk.lab1.repository.ManufactureRepository;
import mk.finki.ukim.mk.lab1.repository.OrderRepository;
import mk.finki.ukim.mk.lab1.repository.UserRepository;
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
    //repositories
    private final UserRepository userRepository;
    private final ManufactureRepository manufactureRepository;
    private final OrderRepository orderRepository;
    private final BalloonRepository balloonRepository;


    public DataHolder(UserRepository userRepository, ManufactureRepository manufactureRepository, OrderRepository orderRepository, BalloonRepository balloonRepository) {
        this.userRepository = userRepository;
        this.manufactureRepository = manufactureRepository;
        this.orderRepository = orderRepository;
        this.balloonRepository = balloonRepository;
    }

    @PostConstruct
    public void init(){
//        Manufacture manufacture = new Manufacture("Dimitar Manufacture","Macedonia","Orce Nikolov,Skopje");
//        Manufacture manufacture1 = new Manufacture("Sandra Manufacture","Bulgaria","Makedonska,Sofia");
//        Manufacture manufacture2 = new Manufacture("Tija Manufacture","Bulgaria","Makedonska,Sofia");
//        manufactures.add(manufacture);
//        manufactures.add(manufacture1);
//        manufactures.add(manufacture2);
//
//        this.manufactureRepository.saveAll(manufactures);
//        //Data
//        User user=new User("dime","dime");
//        User user1=new User("kote","kote");
//        users.add(user);
//        users.add(user1);
//        this.userRepository.saveAll(users);
//
//        balloons.add(new Balloon("A3","balon1 description", manufacture));
//        balloons.add(new Balloon("Z","balon2 description", manufacture2));
//        balloons.add(new Balloon("A1","balon3 description", manufacture1));
//        balloons.add(new Balloon("C","balon4 description", manufacture1));
//        balloons.add(new Balloon("M5","balon5 description", manufacture1));
//        this.balloonRepository.saveAll(balloons);
//
//        orders.add(new Order("red","10","Dime",user));
//        orders.add(new Order("green","15","Ivan",user));
//        orders.add(new Order("blue","6","Ace",user1));
//        orders.add(new Order("yellow","20","Miki",user1));
//        orders.add(new Order("white","16","Tija",user));
//        this.orderRepository.saveAll(orders);

    }
}
