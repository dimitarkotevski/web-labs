package mk.finki.ukim.mk.lab1.repository;

import mk.finki.ukim.mk.lab1.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab1.model.Manufacture;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManufacturerRepository {
    public List<Manufacture> findAll(){
        return DataHolder.manufactures;
    }
}
