package mk.finki.ukim.mk.lab1.repository.inMemory;

import mk.finki.ukim.mk.lab1.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab1.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InMemoryUserRepository {
    public Optional<User> tryLogin(String username, String password) {
        return DataHolder.users.stream().filter(i->i.getUsername().equals(username)
                && i.getPassword().equals(password)).findFirst();
    }
    public Optional<User> findByUsername(String username) {
        return DataHolder.users.stream().filter(i->i.getUsername().equals(username)).findFirst();
    }
}
