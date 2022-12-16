package mk.finki.ukim.mk.lab1.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import mk.finki.ukim.mk.lab1.model.UserFullname;

@Data
@Entity
@Table(name = "user_shop")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    @Convert(converter = UserNameConverter.class)
    private UserFullname  personFullName;
    private String password;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime dateOfBirth;
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<ShoppingCard> cards;


    public User() {

    }
}
