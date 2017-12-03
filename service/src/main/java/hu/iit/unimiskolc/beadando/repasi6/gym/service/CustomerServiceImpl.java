package hu.iit.unimiskolc.beadando.repasi6.gym.service;

import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.CustomerAlreadyExistsException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.CustomerNotFoundException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.model.Customer;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.service.CustomerService;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.CustomerDAO;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.PersistenceException;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.exceptions.StorageNotAvailableException;

import java.util.ArrayList;
import java.util.Collection;

public class CustomerServiceImpl implements CustomerService {

    CustomerDAO customerDAO;

    public CustomerServiceImpl(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }

    @Override
    public void createCustomer(Customer customer) throws CustomerAlreadyExistsException, PersistenceException {
            customerDAO.createCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) throws CustomerNotFoundException, PersistenceException {
            customerDAO.updateCustomer(customer);
    }

    @Override
    public Customer readCustomerByName(String name) throws CustomerNotFoundException, PersistenceException {
            return customerDAO.readCustomerByName(name);
    }

    @Override
    public Customer readCustomerByID(int ID) throws CustomerNotFoundException, PersistenceException {
            return customerDAO.readCustomerByID(ID);
    }

    @Override
    public Collection<Customer> readCustomer(int gymid) throws PersistenceException{
        try {
            return customerDAO.readCustomer(gymid);
        } catch (StorageNotAvailableException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void deleteCustomerByID(int ID) throws CustomerNotFoundException, PersistenceException {
            customerDAO.deleteCustomerByID(ID);
    }

    @Override
    public int getMaxID() throws CustomerNotFoundException, PersistenceException {
            return customerDAO.getMaxID();
    }
}
