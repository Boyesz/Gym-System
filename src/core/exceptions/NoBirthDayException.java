package core.exceptions;

public class NoBirthDayException extends Throwable {
    public NoBirthDayException(String s) {
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

    public NoBirthDayException() {
    }
}
