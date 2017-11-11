package core.exceptions;

public class NoLastUpdateException extends Throwable {
    public NoLastUpdateException(String last_update_must_be_set) {
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

    public NoLastUpdateException() {
    }
}
