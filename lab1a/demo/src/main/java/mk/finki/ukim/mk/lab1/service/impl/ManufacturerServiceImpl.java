package mk.finki.ukim.mk.lab1.service.impl;

import mk.finki.ukim.mk.lab1.model.Manufacture;
import mk.finki.ukim.mk.lab1.repository.inMemory.InMemoryManufacturerRepository;
import mk.finki.ukim.mk.lab1.service.interfaces.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private final InMemoryManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(InMemoryManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacture> findAll() {
        return this.manufacturerRepository.findAll();
    }
}
