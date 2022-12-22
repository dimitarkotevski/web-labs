package mk.finki.ukim.mk.lab1.service.impl;

import mk.finki.ukim.mk.lab1.model.Balloon;
import mk.finki.ukim.mk.lab1.model.Manufacture;
import mk.finki.ukim.mk.lab1.model.exception.BalloonNotFoundRepository;
import mk.finki.ukim.mk.lab1.repository.BalloonRepository;
import mk.finki.ukim.mk.lab1.service.interfaces.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalloonServiceImpl implements BalloonService {
    private final BalloonRepository balloonRepository;

    public BalloonServiceImpl(BalloonRepository balloonRepository) {
        this.balloonRepository = balloonRepository;
    }


    @Override
    public List<Balloon> listAll() {
        return this.balloonRepository.findAll();
    }

    @Override
    public Balloon searchByNameOrDescription(String text) {
        return this.balloonRepository.findAllByNameOrDescription(text);
    }

    @Override
    public void deleteBalloon(Long id) {
        this.balloonRepository.deleteById(id);
    }

    @Override
    public Balloon findBalloonById(Long id) {
        return this.balloonRepository.findById(id).orElseThrow(BalloonNotFoundRepository::new);
    }

    @Override
    public Balloon changeBalloon(Long id,String name,String description, Manufacture manufacture) {
        Balloon balloon= this.balloonRepository.getBalloonById(id).orElseThrow(BalloonNotFoundRepository::new);
        balloon.setName(name);
        balloon.setDescription(description);
        balloon.setManufacture(manufacture);
        return this.balloonRepository.save(balloon);
    }

    @Override
    public void addBalloon(String name, String description, Manufacture manufacture) {
        this.balloonRepository.save(new Balloon(name,description,manufacture));
    }

    @Override
    public List<Balloon> balloonOrderAsc() {
        return this.balloonRepository.orderAsc();
    }

    @Override
    public List<Balloon> balloonOrderDesc() {
        return this.balloonRepository.orderDesc();
    }
}
