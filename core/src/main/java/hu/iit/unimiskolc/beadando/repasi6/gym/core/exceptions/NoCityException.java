package hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions;

public class NoCityException extends Exception {
    public NoCityException() {
    }

    public NoCityException(String message) {
        super(message);
    }

    public NoCityException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoCityException(Throwable cause) {
        super(cause);
    }

    public NoCityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
