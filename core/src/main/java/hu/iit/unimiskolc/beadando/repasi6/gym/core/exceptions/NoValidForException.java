package hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions;

public class NoValidForException extends Exception {
    public NoValidForException() {
    }

    public NoValidForException(String message) {
        super(message);
    }

    public NoValidForException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoValidForException(Throwable cause) {
        super(cause);
    }

    public NoValidForException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
