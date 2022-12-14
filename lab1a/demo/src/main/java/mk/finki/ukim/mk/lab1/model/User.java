package mk.finki.ukim.mk.lab1.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "user_shop")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<ShoppingCard> cards;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {

    }
}
