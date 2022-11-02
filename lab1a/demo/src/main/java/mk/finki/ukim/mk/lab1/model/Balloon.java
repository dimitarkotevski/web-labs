package mk.finki.ukim.mk.lab1.model;

import lombok.Data;

@Data
public class Balloon {
    Long id;
    String name;
    String description;
    public Balloon(String name, String description) {
        this.id = (long)(Math.random()*1000);
        this.name = name;
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
}
