package hu.iit.unimiskolc.beadando.repasi6.gym.service;

import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.TicketAlreadyExistsException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.TicketNotFoundException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.model.Ticket;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.service.TicketService;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.TicketDAO;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.PersistenceException;

public class TicketServiceImpl implements TicketService {
    TicketDAO ticketDAO;

    @Override
    public void createTicket(Ticket ticket) throws TicketAlreadyExistsException, PersistenceException {
            ticketDAO.createTicket(ticket);
    }

    @Override
    public void updateTicket(Ticket ticket) throws TicketNotFoundException, PersistenceException {
            ticketDAO.updateTicket(ticket);
    }

    @Override
    public Ticket readTicketByCustomerID(int CustomerID) throws TicketNotFoundException, PersistenceException {
            return ticketDAO.readTicketByCustomerID(CustomerID);
    }

    @Override
    public void deleteTicket(int CustomerID) throws TicketNotFoundException, PersistenceException {
            ticketDAO.deleteTicket(CustomerID);
    }
}
