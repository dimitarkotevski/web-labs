package mk.finki.ukim.mk.lab1.service.impl;

import mk.finki.ukim.mk.lab1.model.User;
import mk.finki.ukim.mk.lab1.repository.UserRepository;
import mk.finki.ukim.mk.lab1.service.interfaces.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIml implements UserService {
    private final UserRepository userRepository;

    public UserServiceIml(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByUserName(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public User register(User user) {
        return this.userRepository.save(user);
    }
}
