package hu.iit.unimiskolc.beadando.repasi6.gym;

import com.example.myschema.CustomerRegistrationRequest;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.*;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.model.Customer;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.time.LocalDate;
import java.util.Collection;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

   /* @ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "jelenleg nem elérhtő a szolgáltatás.")
    @ExceptionHandler(PersistenceException.class)
    public void persistenceExHandler(){}*/
    @ResponseStatus(value = HttpStatus.EXPECTATION_FAILED,reason = "nem adtál meg minden adatot.")
    @ExceptionHandler({NoEmailException.class, NoNameException.class, GymIDException.class, NoLoginException.class, NoRegistrationDateException.class, NoBirthDayException.class})
    public void neEmailExHandler(){}
    @ResponseStatus(value = HttpStatus.EXPECTATION_FAILED,reason = "már létezik ilyen felhasználó.")
    @ExceptionHandler({CustomerAlreadyExistsException.class})
    public String alreadyExists(CustomerAlreadyExistsException ex){return ex.getMessage();}


    @RequestMapping(value={"/addCustomer"}, method={RequestMethod.POST}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public int createCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) throws PersistenceException, NoEmailException, NoNameException, GymIDException, NoLoginException, NoRegistrationDateException, NoBirthDayException, CustomerAlreadyExistsException {
            customerService.createCustomer(new Customer(
                    customerRegistrationRequest.getId(),
                    customerRegistrationRequest.getName(),
                    LocalDate.now(),customerRegistrationRequest.getGymid(),
                    customerRegistrationRequest.getBirth().toGregorianCalendar().toZonedDateTime().toLocalDate(),
                    customerRegistrationRequest.getEmail(),
                    customerRegistrationRequest.getLogin()));
        return 1;
    }

    @RequestMapping(value = {"/getMaxID"},method = {RequestMethod.GET})
    @ResponseBody
    public int getMaxID() throws CustomerNotFoundException, PersistenceException {
        return customerService.getMaxID();
    }

    @RequestMapping(value = {"/getCustomers"},method = {RequestMethod.GET},consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Customer> getCustomers() throws PersistenceException {
        return customerService.readCustomer(1000);
    }
}
