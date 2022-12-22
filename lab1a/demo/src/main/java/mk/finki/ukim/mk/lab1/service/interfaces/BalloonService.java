package mk.finki.ukim.mk.lab1.service.interfaces;

import mk.finki.ukim.mk.lab1.model.Balloon;
import mk.finki.ukim.mk.lab1.model.Manufacture;

import java.util.List;
import java.util.function.Supplier;


public interface BalloonService {

    List<Balloon> listAll();
    Balloon searchByNameOrDescription(String text);

    void deleteBalloon(Long id);
    Balloon findBalloonById(Long id);

    Balloon changeBalloon(Long id,String name,String description, Manufacture manufacture);
    void addBalloon( String name, String description,Manufacture manufacture );

    List<Balloon> balloonOrderAsc();

    List<Balloon> balloonOrderDesc();

    void deleteById(Long id);

    Balloon save(String name, String description, Manufacture manufacture);
}
