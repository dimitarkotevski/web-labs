package mk.finki.ukim.mk.lab1.service.interfaces;

import mk.finki.ukim.mk.lab1.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderService {
    List<Order> allOrders();

    void save(Order order);

    Order getOrderById(Long id);
}
