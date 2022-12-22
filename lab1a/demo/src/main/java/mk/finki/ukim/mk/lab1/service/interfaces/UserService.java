package mk.finki.ukim.mk.lab1.service.interfaces;

import mk.finki.ukim.mk.lab1.model.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User getUserByUserName(String username);

    User register(User user);
}
