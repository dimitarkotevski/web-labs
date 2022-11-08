package mk.finki.ukim.mk.lab1.repository;

import mk.finki.ukim.mk.lab1.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab1.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {
    public void placeOrder(Order order) {
        DataHolder.orders.add(order);
    }

    public List<Order> findAllOrders() {
        return DataHolder.orders;
    }
}
