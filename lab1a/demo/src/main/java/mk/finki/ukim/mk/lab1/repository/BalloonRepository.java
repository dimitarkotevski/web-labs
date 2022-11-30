package mk.finki.ukim.mk.lab1.repository;

import mk.finki.ukim.mk.lab1.model.Balloon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalloonRepository extends JpaRepository<Balloon,Long> {
}
