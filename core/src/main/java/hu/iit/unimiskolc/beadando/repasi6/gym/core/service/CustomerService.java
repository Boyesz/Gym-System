package hu.iit.unimiskolc.beadando.repasi6.gym.core.service;

import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.CustomerAlreadyExistsException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.CustomerNotFoundException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.model.Customer;

import java.util.Collection;

public interface CustomerService {

    public void createCustomer(Customer customer) throws CustomerAlreadyExistsException;

    public void updateCustomer(Customer customer) throws CustomerNotFoundException;

    public Customer readCustomerByName(String name)throws CustomerNotFoundException;

    public Customer readCustomerByID(int ID) throws CustomerNotFoundException;

    public Collection<Customer> readCustomer(int gymid) ;

    public void deleteCustomerByID(int ID) throws CustomerNotFoundException;

}
