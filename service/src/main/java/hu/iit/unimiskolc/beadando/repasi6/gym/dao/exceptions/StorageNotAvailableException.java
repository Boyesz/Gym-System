package hu.iit.unimiskolc.beadando.repasi6.gym.dao.exceptions;

public class StorageNotAvailableException extends Exception {
    public StorageNotAvailableException() {
    }

    public StorageNotAvailableException(String s) {
        super(s);
    }

    public StorageNotAvailableException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public StorageNotAvailableException(Throwable throwable) {
        super(throwable);
    }

    public StorageNotAvailableException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
