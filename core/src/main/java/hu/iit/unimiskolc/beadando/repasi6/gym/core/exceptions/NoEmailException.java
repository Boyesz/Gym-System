package hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions;

public class NoEmailException extends Exception {
    public NoEmailException() {
    }

    public NoEmailException(String message) {
        super(message);
    }

    public NoEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoEmailException(Throwable cause) {
        super(cause);
    }

    public NoEmailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
