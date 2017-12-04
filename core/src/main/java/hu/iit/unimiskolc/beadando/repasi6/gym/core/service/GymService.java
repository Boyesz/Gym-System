package hu.iit.unimiskolc.beadando.repasi6.gym.core.service;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.GymAlreadyExistsException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.GymNotFoundException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.PersistenceException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.model.*;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Dictionary;
import java.util.List;

public interface GymService {
    void createGym(Gym gym) throws GymAlreadyExistsException, PersistenceException;

    int getMaxGymID() throws GymNotFoundException, PersistenceException;

    void deleteGymByID(int gymID) throws GymNotFoundException, PersistenceException;

    void updateGym(Gym gym) throws GymNotFoundException;

    /**
     * If there is no gym it should not return null.
     * @return
     */
    Collection<Gym> getGym() throws PersistenceException;

    Gym getGymByID(int gymID) throws GymNotFoundException, PersistenceException;

    Collection<String[]> allGymNameAndGymID() throws GymNotFoundException, PersistenceException;

}
