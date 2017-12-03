package hu.iit.unimiskolc.beadando.repasi6.gym.core.model;

import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;

public class Customer {
    int id;
    String name;
    LocalDate registrationDate;
    int gymID;
    LocalDate birthDay;
    String email;
    String login;
    Ticket ticket;
    public Customer(int id, String name, LocalDate registrationDate, int gymID, LocalDate birthDay, String email, String login) throws NoNameException, NoRegistrationDateException, GymIDException, NoEmailException, NoLoginException, NoBirthDayException {
        setName(name);
        setRegistrationDate(registrationDate);
        setGymID(gymID);
        setEmail(email);
        setBirthDay(birthDay);
        setLogin(login);
        setID(id);
    }


    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NoNameException {
        if(name == null)
            throw new NoNameException("Name must be set.");
        this.name = name;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) throws NoRegistrationDateException {
        if(registrationDate == null)
            throw new NoRegistrationDateException("RegistrationDate cannot be null.");
        this.registrationDate = registrationDate;
    }

    public int getGymID() {
        return gymID;
    }

    public void setGymID(int gymID) throws GymIDException {
        if(gymID == 0 || gymID < 0)
            throw new GymIDException("GymID cannot be null or negtive.");
        this.gymID = gymID;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) throws NoBirthDayException {
        if(birthDay == null)
            throw new NoBirthDayException("BirthDay must be set.");
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws NoEmailException {
        if(email == null)
            throw new NoEmailException("Email cannot be set.");
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) throws NoLoginException {
        if(login == null)
            throw new NoLoginException("You must give login.");
        this.login = login;
    }
}
