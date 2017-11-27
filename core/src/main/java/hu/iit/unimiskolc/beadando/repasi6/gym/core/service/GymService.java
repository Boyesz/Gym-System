package hu.iit.unimiskolc.beadando.repasi6.gym.core.service;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.GymAlreadyExistsException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.GymNotFoundException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.model.*;

import java.util.Collection;
import java.util.List;

public interface GymService {
    void createGym(Gym gym) throws GymAlreadyExistsException;

    int getMaxGymID();

    void deleteGymByID(int gymID) throws GymNotFoundException;

    void updateGym(Gym gym) throws GymNotFoundException;

    /**
     * If there is no gym it should not return null.
     * @return
     */
    Collection<Gym> getGym();

    Gym getGymByID(int gymID) throws GymNotFoundException;

}
