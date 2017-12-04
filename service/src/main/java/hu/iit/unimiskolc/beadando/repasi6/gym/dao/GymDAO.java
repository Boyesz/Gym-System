package hu.iit.unimiskolc.beadando.repasi6.gym.dao;

import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.GymAlreadyExistsException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.GymNotFoundException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.model.Gym;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.PersistenceException;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.exceptions.LoginAlreadyExistsException;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.exceptions.StorageNotAvailableException;

import java.sql.SQLException;
import java.util.Collection;

public interface GymDAO {
    public void createGym(Gym gym) throws GymAlreadyExistsException, PersistenceException, LoginAlreadyExistsException;
    public Collection<Gym> readGym() throws StorageNotAvailableException,PersistenceException;
    public Gym readGym(int gymID) throws StorageNotAvailableException,PersistenceException;
    public void deleteGym(int gymID) throws GymNotFoundException,PersistenceException;
    public void updateGym(Gym gym) throws GymNotFoundException,PersistenceException;
    public int getMaxGymID() throws GymNotFoundException, PersistenceException;
    public Collection<String[]> getGymNameAndGymID() throws GymNotFoundException,PersistenceException;
}
