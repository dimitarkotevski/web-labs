package mk.finki.ukim.mk.lab1.service.interfaces;

import mk.finki.ukim.mk.lab1.model.User;

public interface LoginService {
    User login(String username, String password);
}
