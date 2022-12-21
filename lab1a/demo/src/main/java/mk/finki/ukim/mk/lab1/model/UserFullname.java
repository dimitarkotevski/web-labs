package mk.finki.ukim.mk.lab1.model;

import java.io.Serializable;

public class UserFullname implements Serializable {
    private String name ;
    private String surname;

    public UserFullname(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
