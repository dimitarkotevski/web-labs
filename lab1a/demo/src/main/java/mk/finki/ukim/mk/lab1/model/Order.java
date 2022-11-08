package mk.finki.ukim.mk.lab1.model;

import lombok.Data;

@Data
public class Order {
    Long orderId;
    String balloonColor;
    String balloonSize;
    String clientName;
    String clientAddress;
    public Order(String balloonColor, String balloonSize, String clientName, String clientAddress) {
        this.orderId = (long)(Math.random()*1000);
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
    }
}
