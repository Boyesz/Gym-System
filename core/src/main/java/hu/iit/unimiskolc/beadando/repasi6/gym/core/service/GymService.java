package hu.iit.unimiskolc.beadando.repasi6.gym.core.service;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.GymAlreadyExistsException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.GymNotFoundException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.model.*;
import java.util.List;

public interface GymService {
    public void createGym(Gym gym) throws GymAlreadyExistsException;

    public void deleteGymByID(int gymID) throws GymNotFoundException;

    public void updateGym(Gym gym) throws GymNotFoundException;

    /**
     * If there is no gym it should not return null.
     * @return
     */
    public List<Gym> getGym();

    public Gym getGymByID(int gymID) throws GymNotFoundException;

}
