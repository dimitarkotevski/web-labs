package mk.finki.ukim.mk.lab1.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user_shop")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<ShoppingCard> cards;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {

    }
}
