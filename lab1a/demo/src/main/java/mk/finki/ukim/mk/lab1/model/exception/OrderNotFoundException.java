package mk.finki.ukim.mk.lab1.model.exception;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(){
        super("Order not found");
    }
}
