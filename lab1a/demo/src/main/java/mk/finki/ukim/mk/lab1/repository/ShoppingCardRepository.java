package mk.finki.ukim.mk.lab1.repository;

import mk.finki.ukim.mk.lab1.model.ShoppingCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoppingCardRepository extends JpaRepository<ShoppingCard,Long> {
    @Query("select s from ShoppingCard s where s.user.id=:id")
    List<ShoppingCard> getUserShoppingCard(Long id);
}
