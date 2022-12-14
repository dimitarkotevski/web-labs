package mk.finki.ukim.mk.lab1.service.impl;

import mk.finki.ukim.mk.lab1.model.Balloon;
import mk.finki.ukim.mk.lab1.model.Order;
import mk.finki.ukim.mk.lab1.model.User;
import mk.finki.ukim.mk.lab1.repository.OrderRepository;
import mk.finki.ukim.mk.lab1.service.interfaces.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    @Override
    public Order placeOrder(String balloonColor, String clientName, String address) {
        User user=new User(address,"");
        Balloon balloon=new Balloon(balloonColor,"",null);
        Order order=new Order(balloon,user);
        this.orderRepository.save(order);
        return order;
    }

    @Override
    public List<Order> allOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public void save(Order order) {
        this.orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return this.orderRepository.findById(id).orElseThrow();
    }
}