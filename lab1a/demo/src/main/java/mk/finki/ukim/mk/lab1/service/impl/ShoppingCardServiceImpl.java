package mk.finki.ukim.mk.lab1.service.impl;

import mk.finki.ukim.mk.lab1.model.ShoppingCard;
import mk.finki.ukim.mk.lab1.model.exception.ShoppingCardNotFoundException;
import mk.finki.ukim.mk.lab1.repository.ShoppingCardRepository;
import mk.finki.ukim.mk.lab1.service.interfaces.ShoppingCardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCardServiceImpl implements ShoppingCardService {
    private final ShoppingCardRepository shoppingCardRepository;

    public ShoppingCardServiceImpl(ShoppingCardRepository shoppingCardRepository) {
        this.shoppingCardRepository = shoppingCardRepository;
    }

    @Override
    public List<ShoppingCard> getAllShoppingCardFromWithUserId(Long id) {
        return this.shoppingCardRepository.getUserShoppingCard(id);
    }

    @Override
    public List<ShoppingCard> getAllShoppingCardListed() {
        return this.shoppingCardRepository.findAll();
    }

    @Override
    public ShoppingCard getShoppingCardWithId(Long id) {
        return this.shoppingCardRepository.findById(id).orElseThrow(ShoppingCardNotFoundException::new);
    }

    @Override
    public void saveShoppingCard(ShoppingCard shoppingCard) {
        this.shoppingCardRepository.save(shoppingCard);
    }
}
