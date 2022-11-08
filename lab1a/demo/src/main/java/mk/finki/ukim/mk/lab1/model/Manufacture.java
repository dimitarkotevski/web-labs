package mk.finki.ukim.mk.lab1.model;

import lombok.Data;

@Data
public class Manufacture {
    private Long id;
    private String name;
    private String country;
    private String address;

    public Manufacture(String name, String country, String address) {
        this.id = (long)(Math.random()*1000);
        this.name = name;
        this.country = country;
        this.address = address;
    }
}
