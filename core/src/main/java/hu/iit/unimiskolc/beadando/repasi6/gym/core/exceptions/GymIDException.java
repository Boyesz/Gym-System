package hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions;

public class GymIDException extends Exception {
    public GymIDException() {
    }

    public GymIDException(String message) {
        super(message);
    }

    public GymIDException(String message, Throwable cause) {
        super(message, cause);
    }

    public GymIDException(Throwable cause) {
        super(cause);
    }

    public GymIDException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
