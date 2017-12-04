package hu.iit.unimiskolc.beadando.repasi6.gym;

import com.example.myschema.GymRegistrationRequest;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.*;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.model.Gym;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.service.GymService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Dictionary;

@Controller
@RequestMapping("/gym")
public class GymController {

    private GymService gymService;

    public GymController(GymService gymService) {
        this.gymService = gymService;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "jelenleg nem elérhtő a szolgáltatás.")
    @ExceptionHandler(PersistenceException.class)
    public void persistenceExHandler(){}
    @ResponseStatus(value = HttpStatus.EXPECTATION_FAILED,reason = "nem adtál meg minden adatot.")
    @ExceptionHandler({NoNameException.class, NoLoginException.class, GymIDException.class, NoEmailException.class, NoCityException.class})
    public void noEmailExHandler(){}
    @ResponseStatus(value = HttpStatus.EXPECTATION_FAILED,reason = "már létezik ilyen felhasználó.")
    @ExceptionHandler({GymAlreadyExistsException.class})
    public String alreadyExists(GymAlreadyExistsException ex){return ex.getMessage();}


    @RequestMapping(value = {"/getMaxID"},method = {RequestMethod.GET},produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public int getGym() throws GymNotFoundException, PersistenceException {
        return gymService.getMaxGymID();
    }

    @RequestMapping(value={"/addGym"}, method={RequestMethod.POST}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public int gymCreate(@RequestBody GymRegistrationRequest gymRegistrationRequest) throws NoNameException, NoLoginException, GymIDException, NoEmailException, NoCityException, PersistenceException, GymAlreadyExistsException {
        Gym gym = null;
            gym = new Gym(gymRegistrationRequest.getGymID(),
                              gymRegistrationRequest.getEmail(),
                              gymRegistrationRequest.getLogin(),
                              gymRegistrationRequest.getGymName(),
                            1,gymRegistrationRequest.getCity());
        gymService.createGym(gym);
        return 1;
    }

    @RequestMapping(value = {"/getAllGymNameAndGymID"},method = {RequestMethod.GET},produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<String[]> getAllGym() throws GymNotFoundException, PersistenceException {
        return gymService.allGymNameAndGymID();
    }

}
