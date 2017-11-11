package hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions;

public class GymAlreadyExistsException extends Exception {
    public GymAlreadyExistsException() {
    }

    public GymAlreadyExistsException(String s) {
        super(s);
    }

    public GymAlreadyExistsException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public GymAlreadyExistsException(Throwable throwable) {
        super(throwable);
    }

    public GymAlreadyExistsException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
