package mk.finki.ukim.mk.lab1.service.impl;

import mk.finki.ukim.mk.lab1.model.Manufacture;
import mk.finki.ukim.mk.lab1.model.exception.ManuFactureNotFoundException;
import mk.finki.ukim.mk.lab1.repository.ManufactureRepository;
import mk.finki.ukim.mk.lab1.service.interfaces.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufactureRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufactureRepository manufacturerRepository1) {
        this.manufacturerRepository = manufacturerRepository1;
    }

    @Override
    public List<Manufacture> findAll() {
        return this.manufacturerRepository.findAll();
    }

    @Override
    public Manufacture findById(Long manufactureId) {
        return this.manufacturerRepository.findById(manufactureId).orElseThrow(ManuFactureNotFoundException::new);
    }

    @Override
    public Manufacture save(String name1, String country1, String address1) {
        return this.manufacturerRepository.save(new Manufacture(name1,country1,address1));
    }
}
