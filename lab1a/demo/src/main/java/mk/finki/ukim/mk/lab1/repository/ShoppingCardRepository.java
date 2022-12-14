package mk.finki.ukim.mk.lab1.repository;

import mk.finki.ukim.mk.lab1.model.ShoppingCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCardRepository extends JpaRepository<ShoppingCard,Long> {
}
