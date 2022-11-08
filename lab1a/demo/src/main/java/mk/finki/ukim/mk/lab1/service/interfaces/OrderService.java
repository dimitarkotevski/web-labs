package mk.finki.ukim.mk.lab1.service.interfaces;

import mk.finki.ukim.mk.lab1.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderService {
    Order placeOrder(String balloonColor, String clientName, String address);
    List<Order> allOrders();
}
