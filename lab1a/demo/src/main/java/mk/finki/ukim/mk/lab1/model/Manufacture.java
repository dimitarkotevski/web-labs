package mk.finki.ukim.mk.lab1.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Manufacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String address;

    public Manufacture(String name, String country, String address) {
        this.name = name;
        this.country = country;
        this.address = address;
    }

    public Manufacture() {

    }
}
