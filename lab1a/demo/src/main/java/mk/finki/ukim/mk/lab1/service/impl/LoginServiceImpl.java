package mk.finki.ukim.mk.lab1.service.impl;

import mk.finki.ukim.mk.lab1.model.User;
import mk.finki.ukim.mk.lab1.model.exception.WrongCredentialsException;
import mk.finki.ukim.mk.lab1.repository.inMemory.InMemoryUserRepository;
import mk.finki.ukim.mk.lab1.service.interfaces.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    private final InMemoryUserRepository userRepository;

    public LoginServiceImpl(InMemoryUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        return userRepository.tryLogin(username,password).orElseThrow(()-> new WrongCredentialsException());
    }
}
