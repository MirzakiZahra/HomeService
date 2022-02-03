package ir.exception;


public class EnoughCreditException extends RuntimeException {
    public EnoughCreditException(String message) {
        super(message);
    }
}

