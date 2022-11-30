package mk.finki.ukim.mk.lab1.model.exception;

public class ManuFactureNotFoundException extends  RuntimeException{
    public ManuFactureNotFoundException(){
        super("Manufacture not found");
    }
}
