package hu.iit.unimiskolc.beadando.repasi6.gym.core.model;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.GymIDException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.NoEmailException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.NoLoginException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.NoNameException;

import java.util.Collection;

public class Gym {
    int gymID;
    String email;
    String login;
    String gymName;
    String city;
    Collection<Customer> customers;
    boolean verify;

    public Gym(int gymID, String email, String login, String gymName, boolean verify, String city) throws NoLoginException, NoNameException, NoEmailException, GymIDException {
        if(gymID == 0 || gymID < 0)
            throw new GymIDException("GymID cannot be null or negtive.");
        if(email == null)
            throw new NoEmailException("Email must be set.");
        if(login == null)
            throw new NoLoginException("Login must be set.");
        if(gymName == null)
            throw new NoNameException("GymName must be set.");
        this.gymID = gymID;
        this.email = email;
        this.login = login;
        this.gymName = gymName;
        this.city = city;
        this.verify = verify;
    }

    public boolean getVerify() {
        return verify;
    }

    public void setVerify(boolean verify) {
        this.verify = verify;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }

    public int getGymID() {
        return gymID;
    }

    public void setGymID(int gymID) {
        this.gymID = gymID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        city = city;
    }
}
