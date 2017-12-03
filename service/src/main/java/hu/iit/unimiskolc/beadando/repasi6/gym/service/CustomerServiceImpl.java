package hu.iit.unimiskolc.beadando.repasi6.gym.service;

import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.CustomerAlreadyExistsException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.CustomerNotFoundException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.model.Customer;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.service.CustomerService;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.CustomerDAO;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.exceptions.PersistenceException;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.exceptions.StorageNotAvailableException;

import java.util.ArrayList;
import java.util.Collection;

public class CustomerServiceImpl implements CustomerService {

    CustomerDAO customerDAO;

    @Override
    public void createCustomer(Customer customer) throws CustomerAlreadyExistsException {
        try {
            customerDAO.createCustomer(customer);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(Customer customer) throws CustomerNotFoundException {
        try {
            customerDAO.updateCustomer(customer);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer readCustomerByName(String name) throws CustomerNotFoundException {
        try {
            customerDAO.readCustomerByName(name);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer readCustomerByID(int ID) throws CustomerNotFoundException {
        try {
            customerDAO.readCustomerByID(ID);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Customer> readCustomer(int gymid) {
        try {
            return customerDAO.readCustomer(gymid);
        } catch (StorageNotAvailableException e) {
            e.printStackTrace();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void deleteCustomerByID(int ID) throws CustomerNotFoundException {
        try {
            customerDAO.deleteCustomerByID(ID);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }
}
