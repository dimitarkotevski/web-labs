package mk.finki.ukim.mk.lab1.service.interfaces;

import mk.finki.ukim.mk.lab1.model.Balloon;
import mk.finki.ukim.mk.lab1.model.Manufacture;

import java.util.List;


public interface BalloonService {

    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);

    void deleteBalloon(Long id);
    Balloon findById(Long id);

    void changeBalloon(Long id,String name,String description, Manufacture manufacture);
}
