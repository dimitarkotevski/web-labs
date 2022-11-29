package mk.finki.ukim.mk.lab1.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ShoppingCard {
    private Long id;
    private User user;
    private LocalDateTime dateCreated;
    private List<Order> orders;
}
