package mk.finki.ukim.mk.lab1.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "shop_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    Balloon balloon;
    @ManyToOne
    User user;
    @ManyToMany
    private List<ShoppingCard> cards;

    public Order(Balloon balloon, User user) {
        this.balloon=balloon;
        this.user = user;
    }

    public Order() {

    }
}
