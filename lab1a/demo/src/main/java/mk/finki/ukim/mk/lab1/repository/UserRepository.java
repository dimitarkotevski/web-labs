package mk.finki.ukim.mk.lab1.repository;

import mk.finki.ukim.mk.lab1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u where u.username=:username and u.password=:password")
    Optional<User> findByUsernameAndPassword(String username,String password);
}
