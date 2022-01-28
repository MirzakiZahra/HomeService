package ir.exception;


public class EnoughCredit extends RuntimeException {
    public EnoughCredit(String message) {
        super(message);
    }
}

