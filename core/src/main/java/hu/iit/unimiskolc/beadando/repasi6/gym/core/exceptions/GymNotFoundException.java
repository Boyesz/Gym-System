package hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions;

public class GymNotFoundException extends Exception {
    public GymNotFoundException() {
    }

    public GymNotFoundException(String s) {
        super(s);
    }

    public GymNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public GymNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public GymNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
