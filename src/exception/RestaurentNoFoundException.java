package exception;

public class RestaurentNoFoundException extends RuntimeException {
    public RestaurentNoFoundException(String message) {
        super(message);
    }
}
