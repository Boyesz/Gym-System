package hu.iit.unimiskolc.beadando.repasi6.gym.dao.exceptions;

public class LoginAlreadyExistsException extends Exception {
    public LoginAlreadyExistsException() {
    }

    public LoginAlreadyExistsException(String s) {
        super(s);
    }

    public LoginAlreadyExistsException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public LoginAlreadyExistsException(Throwable throwable) {
        super(throwable);
    }

    public LoginAlreadyExistsException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
