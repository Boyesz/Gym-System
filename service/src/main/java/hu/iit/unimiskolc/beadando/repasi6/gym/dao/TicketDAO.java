package hu.iit.unimiskolc.beadando.repasi6.gym.dao;

import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.TicketAlreadyExistsException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.TicketNotFoundException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.model.Ticket;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.PersistenceException;

public interface TicketDAO {

    public void createTicket(Ticket ticket) throws TicketAlreadyExistsException,PersistenceException;

    public void updateTicket(Ticket ticket) throws TicketNotFoundException,PersistenceException;

    public Ticket readTicketByCustomerID(int CustomerID) throws TicketNotFoundException,PersistenceException;

    public void deleteTicket(int CustomerID) throws TicketNotFoundException,PersistenceException;

}
