package mk.finki.ukim.mk.lab1.service.interfaces;

import mk.finki.ukim.mk.lab1.model.ShoppingCard;

import java.util.List;

public interface ShoppingCardService {
    List<ShoppingCard> getAllShoppingCardFromWithUserId(Long id);

    List<ShoppingCard> getAllShoppingCardListed();

    ShoppingCard getShoppingCardWithId(Long id);

    void saveShoppingCard(ShoppingCard shoppingCard);
}
