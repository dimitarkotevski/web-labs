package mk.finki.ukim.mk.lab1.repository;

import mk.finki.ukim.mk.lab1.model.Balloon;
import mk.finki.ukim.mk.lab1.model.Manufacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalloonRepository extends JpaRepository<Balloon,Long> {
    @Query("select b from Balloon b where b.name = :text")
    Balloon findAllByNameOrDescription(String text);
    @Query("select b from Balloon b order by b.name asc ")
    List<Balloon> orderAsc();
    @Query("select b from Balloon b order by b.name desc ")
    List<Balloon> orderDesc();
}
