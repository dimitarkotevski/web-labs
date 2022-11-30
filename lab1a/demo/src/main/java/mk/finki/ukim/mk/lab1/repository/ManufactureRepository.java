package mk.finki.ukim.mk.lab1.repository;

import mk.finki.ukim.mk.lab1.model.Manufacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufactureRepository extends JpaRepository<Manufacture,Long> {
}
