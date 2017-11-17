package hu.iit.unimiskolc.beadando.repasi6.gym.core.service;

import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.TicketAlreadyExistsException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.TicketNotFoundException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.model.Ticket;

import java.util.Collection;

public interface TicketService {

    public void createTicket(Ticket ticket) throws TicketAlreadyExistsException;

    public void updateTicket(Ticket ticket) throws TicketNotFoundException;

    public Ticket readTicketByCustomerID(int CustomerID) throws TicketNotFoundException;

    public void deleteTicket(int CustomerID) throws TicketNotFoundException;

    public Collection<Ticket> readTicket();

}
