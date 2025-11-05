package SU3.password_validator;

public class NoSpecialCharacterException extends RuntimeException {
    public NoSpecialCharacterException(String message) {
        super(message);
    }
}
