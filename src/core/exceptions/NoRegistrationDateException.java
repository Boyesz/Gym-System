package core.exceptions;

public class NoRegistrationDateException extends Throwable {
    public NoRegistrationDateException(String s) {
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

    public NoRegistrationDateException() {
    }
}
