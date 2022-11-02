package mk.finki.ukim.mk.lab1.service.interfaces;

import mk.finki.ukim.mk.lab1.model.Balloon;

import java.util.List;


public interface BalloonService {

    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);

}
