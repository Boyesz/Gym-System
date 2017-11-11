package hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions;

public class NoBirthDayException extends Exception {
    public NoBirthDayException() {
    }

    public NoBirthDayException(String message) {
        super(message);
    }

    public NoBirthDayException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoBirthDayException(Throwable cause) {
        super(cause);
    }

    public NoBirthDayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
