package hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions;

public class NoRegistrationDateException extends Exception {
    public NoRegistrationDateException() {
    }

    public NoRegistrationDateException(String message) {
        super(message);
    }

    public NoRegistrationDateException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoRegistrationDateException(Throwable cause) {
        super(cause);
    }

    public NoRegistrationDateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
