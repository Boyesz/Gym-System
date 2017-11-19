package hu.iit.unimiskolc.beadando.repasi6.gym.service;

import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.TicketAlreadyExistsException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.TicketNotFoundException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.model.Ticket;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.service.TicketService;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.TicketDAO;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.exceptions.PersistenceException;

import java.util.Collection;

public class TicketServiceImpl implements TicketService {
    TicketDAO ticketDAO;

    @Override
    public void createTicket(Ticket ticket) throws TicketAlreadyExistsException {
        try {
            ticketDAO.createTicket(ticket);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTicket(Ticket ticket) throws TicketNotFoundException {
        try {
            ticketDAO.updateTicket(ticket);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ticket readTicketByCustomerID(int CustomerID) throws TicketNotFoundException {
        try {
            ticketDAO.readTicketByCustomerID(CustomerID);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteTicket(int CustomerID) throws TicketNotFoundException {
        try {
            ticketDAO.deleteTicket(CustomerID);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }
}
