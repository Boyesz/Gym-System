package hu.iit.unimiskolc.beadando.repasi6.gym.core.model;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.*;

import java.util.Collection;

public class Gym {
    int gymID;
    String email;
    String login;
    String gymName;
    String city;
    Collection<Customer> customers;
    int verify;

    public Gym(int gymID, String email, String login, String gymName, int verify, String city) throws NoLoginException, NoNameException, NoEmailException, GymIDException, NoCityException {
        setGymID(gymID);
        setEmail(email);
        setLogin(login);
        setGymName(gymName);
        setCity(city);
        setVerify(verify);
    }

    public int getVerify() {
        return verify;
    }

    public void setVerify(int verify) {
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

    public void setGymID(int gymID) throws GymIDException {
        if(gymID <= 0)
            throw new GymIDException("GymID cannot be null or negtive.");
        this.gymID = gymID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws NoEmailException {
        if(email.isEmpty())
            throw new NoEmailException("Email must be set.");
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) throws NoLoginException {
        if(login.isEmpty())
            throw new NoLoginException("Login must be set.");
        this.login = login;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) throws NoNameException {
        if(gymName.isEmpty())
            throw new NoNameException("GymName must be set.");
        this.gymName = gymName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws NoCityException {
        if(city.isEmpty())
            throw new NoCityException("City cannot be empty");
        this.city = city;
    }
}
