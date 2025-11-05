package SU3.password_validator;

public class ShortPasswordException extends RuntimeException {
    public ShortPasswordException(String message) {
        super(message);
    }
}
