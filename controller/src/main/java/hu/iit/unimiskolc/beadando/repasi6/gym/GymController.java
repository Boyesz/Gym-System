package hu.iit.unimiskolc.beadando.repasi6.gym;

import com.example.myschema.GymRegistrationRequest;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.*;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.model.Gym;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/gym")
public class GymController {

    private GymService gymService;

    public GymController(GymService gymService) {
        this.gymService = gymService;
    }
    /*{
"gymID" : 1000,"gymName" : "Test",
  "login" : "test",
  "email" : "asd@asd.hu",
  "city" : "testCity"
}*/
    @RequestMapping(value={"/addGym"}, method={RequestMethod.POST}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void gymCreate(@RequestBody GymRegistrationRequest gymRegistrationRequest) throws GymAlreadyExistsException {
        Gym gym = null;
        try {
            gym = new Gym(gymRegistrationRequest.getGymID(),
                    gymRegistrationRequest.getEmail(),
                    gymRegistrationRequest.getLogin(),
                    gymRegistrationRequest.getGymName(),
                    true,gymRegistrationRequest.getCity());
        } catch (NoLoginException e) {
            e.printStackTrace();
        } catch (NoNameException e) {
            e.printStackTrace();
        } catch (NoEmailException e) {
            e.printStackTrace();
        } catch (GymIDException e) {
            e.printStackTrace();
        }
        gymService.createGym(gym);
    }

    @RequestMapping(value = "/Employee/{employeeId}", method = RequestMethod.GET)
    public ModelAndView getGym(@PathVariable (value = "gymID")int gymID) throws GymNotFoundException {
        return new ModelAndView("gym","command",gymService.getGymByID(gymID));
    }

}
