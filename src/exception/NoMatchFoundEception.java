package exception;

public class NoMatchFoundEception extends RuntimeException {
    public NoMatchFoundEception(String message) {
        super(message);
    }
}
