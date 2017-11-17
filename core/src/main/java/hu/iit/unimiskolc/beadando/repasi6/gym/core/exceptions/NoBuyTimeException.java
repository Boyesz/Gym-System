package hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions;

public class NoBuyTimeException extends Exception {
    public NoBuyTimeException() {
    }

    public NoBuyTimeException(String message) {
        super(message);
    }

    public NoBuyTimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoBuyTimeException(Throwable cause) {
        super(cause);
    }

    public NoBuyTimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
