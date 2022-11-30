package mk.finki.ukim.mk.lab1.model.exception;

public class BalloonNotFoundRepository extends RuntimeException{
    public BalloonNotFoundRepository() {
        super("Balloon not found");
    }
}
