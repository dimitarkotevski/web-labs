package mk.finki.ukim.mk.lab1.model;

import lombok.Data;

@Data
public class Order {
    Long id;
    String balloonColor;
    String balloonSize;
    String clientName;
    String clientAddress;
    Long orderId;
    public Order(String balloonColor, String balloonSize, String clientName, String clientAddress) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.orderId = (long)(Math.random()*1000);
    }
}
