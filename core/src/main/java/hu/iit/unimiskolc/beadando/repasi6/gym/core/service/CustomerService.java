package hu.iit.unimiskolc.beadando.repasi6.gym.core.service;

import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.CustomerAlreadyExistsException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.CustomerNotFoundException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.PersistenceException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.model.Customer;

import java.util.Collection;

public interface CustomerService {

    public void createCustomer(Customer customer) throws CustomerAlreadyExistsException, PersistenceException;

    public void updateCustomer(Customer customer) throws CustomerNotFoundException, PersistenceException;

    public Customer readCustomerByName(String name) throws CustomerNotFoundException, PersistenceException;

    public Customer readCustomerByID(int ID) throws CustomerNotFoundException, PersistenceException;

    public Collection<Customer> readCustomer(int gymid) throws PersistenceException;

    public void deleteCustomerByID(int ID) throws CustomerNotFoundException, PersistenceException;

    public int getMaxID() throws CustomerNotFoundException, PersistenceException;

}
