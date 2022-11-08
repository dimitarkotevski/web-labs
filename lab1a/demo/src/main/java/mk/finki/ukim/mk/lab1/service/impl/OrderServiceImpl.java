package mk.finki.ukim.mk.lab1.service.impl;

import mk.finki.ukim.mk.lab1.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab1.model.Order;
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
        Order order=new Order(balloonColor,"13",clientName,address);
        this.orderRepository.placeOrder(order);
        return order;
    }

    @Override
    public List<Order> allOrders() {
        return this.orderRepository.findAllOrders();
    }
}