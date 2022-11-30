package mk.finki.ukim.mk.lab1.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Balloon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;
    @ManyToOne
    Manufacture manufacture;
    public Balloon(String name, String description, Manufacture manufacture) {
        this.name = name;
        this.description = description;
        this.manufacture = manufacture;
    }

    public Balloon() {

    }
}
