package mk.finki.ukim.mk.lab1.service.impl;

import mk.finki.ukim.mk.lab1.model.User;
import mk.finki.ukim.mk.lab1.model.exception.WrongCredentialsException;
import mk.finki.ukim.mk.lab1.repository.UserRepository;
import mk.finki.ukim.mk.lab1.service.interfaces.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    private final UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password).orElseThrow(WrongCredentialsException::new);
    }
}
