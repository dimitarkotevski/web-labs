package mk.finki.ukim.mk.lab1.service.impl;

import mk.finki.ukim.mk.lab1.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab1.model.Order;
import mk.finki.ukim.mk.lab1.service.interfaces.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order placeOrder(String balloonColor, String clientName, String address) {
        Order order=new Order(balloonColor,"13",clientName,address);
        DataHolder.orders.add(order);
        return order;
    }
}