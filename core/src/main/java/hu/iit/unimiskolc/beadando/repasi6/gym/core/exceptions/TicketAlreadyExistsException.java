package hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions;

public class TicketAlreadyExistsException extends Exception {
    public TicketAlreadyExistsException() {
    }

    public TicketAlreadyExistsException(String message) {
        super(message);
    }

    public TicketAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TicketAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public TicketAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
