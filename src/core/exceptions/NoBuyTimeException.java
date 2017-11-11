package core.exceptions;

public class NoBuyTimeException extends Throwable {
    public NoBuyTimeException(String buyTime_cannot_be_null) {
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

    public NoBuyTimeException() {
    }
}
