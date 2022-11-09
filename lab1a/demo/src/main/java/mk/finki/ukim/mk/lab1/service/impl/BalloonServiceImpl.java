package mk.finki.ukim.mk.lab1.service.impl;

import mk.finki.ukim.mk.lab1.model.Balloon;
import mk.finki.ukim.mk.lab1.model.Manufacture;
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
        return this.balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return this.balloonRepository.findAllByNameOrDescription(text);
    }

    @Override
    public void deleteBalloon(Long id) {
        this.balloonRepository.deleteById(id);
    }

    @Override
    public Balloon findById(Long id) {
        return this.findById(id);
    }

    @Override
    public void changeBalloon(Long id,String name,String description, Manufacture manufacture) {
        this.balloonRepository.changeBalloon(id,name,description,manufacture);
    }

    @Override
    public void addBalloon(String name, String description, Manufacture manufacture) {
        this.balloonRepository.addBalloon(name,description,manufacture);
    }
}
