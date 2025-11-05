package SU3.password_validator;

public class NoUppercaseException extends RuntimeException {
    public NoUppercaseException(String message) {
        super(message);
    }
}
