package mk.finki.ukim.mk.lab1.model.exception;

public class WrongCredentialsException extends RuntimeException{
    public WrongCredentialsException(){
        super("Invalid user credentials");
    }
}
