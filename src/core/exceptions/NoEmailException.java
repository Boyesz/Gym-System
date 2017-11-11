package core.exceptions;

public class NoEmailException extends Throwable {
    public NoEmailException(String email_must_be_set) {
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

    public NoEmailException() {
    }
}
