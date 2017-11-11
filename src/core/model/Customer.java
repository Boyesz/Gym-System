package core.model;

import core.exceptions;

import java.time.LocalDate;
import java.util.Date;

public class Customer {
    int ID;
    String name;
    LocalDate registrationDate;
    int gymID;
    LocalDate birthDay;
    String email;
    String login;
    Ticket ticket;
    public Customer(String name, LocalDate registrationDate, LocalDate validFor, int opportunity, LocalDate buyTime, int gymID, LocalDate birthDay, LocalDate lastUpdate, String email, String login) throws NoNameException, NoRegistrationDateException, GymIDException, NoEmailException, NoLoginException, NoBirthDayException {
        if(name == null)
            throw new NoNameException("Name must be set.");
        if(registrationDate == null)
            throw new NoRegistrationDateException("RegistrationDate cannot be null.");
        if(gymID == 0 || gymID < 0)
            throw new GymIDException("GymID cannot be null or negtive.");
        if(email == null)
            throw new NoEmailException("Email cannot be set.");
        if(login == null)
            throw new NoLoginException("You must give login.");
        if(birthDay == null)
            throw new NoBirthDayException("BirthDay must be set.");
        this.name = name;
        this.registrationDate = registrationDate;
        this.gymID = gymID;
        this.birthDay = birthDay;
        this.email = email;
        this.login = login;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getGymID() {
        return gymID;
    }

    public void setGymID(int gymID) {
        this.gymID = gymID;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
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
}
