package mk.finki.ukim.mk.lab1.service.interfaces;

import mk.finki.ukim.mk.lab1.model.Manufacture;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ManufacturerService {
    List<Manufacture> findAll();
    Manufacture findById(Long manufactureId);

    Manufacture save(String name1, String country1, String address1);
}
