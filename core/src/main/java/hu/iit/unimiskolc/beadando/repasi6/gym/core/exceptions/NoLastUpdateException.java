package hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions;

public class NoLastUpdateException extends Exception{
    public NoLastUpdateException() {
    }

    public NoLastUpdateException(String message) {
        super(message);
    }

    public NoLastUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoLastUpdateException(Throwable cause) {
        super(cause);
    }

    public NoLastUpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
