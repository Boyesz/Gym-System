package core.model;

import core.exceptions.GymIDException;
import core.exceptions.NoEmailException;
import core.exceptions.NoNameException;
import core.exceptions.NoLoginException;

import java.util.Collection;

public class Gym {
    int gymID;
    String email;
    String login;
    String gymName;
    String City;
    Collection<Customer> customers;

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
        this.City = city;
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
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
}
