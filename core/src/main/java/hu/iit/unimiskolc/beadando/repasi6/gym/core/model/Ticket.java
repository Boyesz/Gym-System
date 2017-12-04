package hu.iit.unimiskolc.beadando.repasi6.gym.core.model;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.GymIDException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.NoBuyTimeException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.NoLastUpdateException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.NoValidForException;

import java.time.LocalDate;

public class Ticket {

    LocalDate validFor;
    LocalDate buyTime;
    LocalDate lastUpdate;
    int opportunity;
    int customerID;
    public Ticket(LocalDate validFor,LocalDate buyTime,LocalDate lastUpdate,int opportunity,int customerID) throws NoValidForException, NoBuyTimeException, GymIDException, NoLastUpdateException {
        setOpportunity(opportunity);
        setValidFor(validFor);
        setLastUpdate(lastUpdate);
        setBuyTime(buyTime);
        setCustomerID(customerID);
    }

    public LocalDate getValidFor() {
        return validFor;
    }

    public void setValidFor(LocalDate validFor) throws NoValidForException {
        if(validFor == null)
            throw new NoValidForException("Valid for must be set.");
        this.validFor = validFor;
    }

    public LocalDate getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(LocalDate buyTime) throws NoBuyTimeException {
        if(buyTime == null)
            throw new NoBuyTimeException("BuyTime cannot be null.");
        this.buyTime = buyTime;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) throws NoLastUpdateException {
        if(lastUpdate == null)
            throw new NoLastUpdateException("Last update must be set.");
        this.lastUpdate = lastUpdate;
    }

    public int getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(int opportunity) {
        this.opportunity = opportunity;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) throws GymIDException {
        if(customerID == 0 || customerID <0)
            throw new GymIDException("ID cannot be null or negative.");
        this.customerID = customerID;
    }
}
