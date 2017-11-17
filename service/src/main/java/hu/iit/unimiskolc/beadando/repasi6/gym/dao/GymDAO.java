package hu.iit.unimiskolc.beadando.repasi6.gym.dao;

import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.GymAlreadyExistsException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.GymNotFoundException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.model.Gym;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.exceptions.PersistenceException;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.exceptions.StorageNotAvailableException;

import java.util.List;

public interface GymDAO {
    public void createGym(Gym gym) throws GymAlreadyExistsException,PersistenceException;
    public List<Gym> readGym() throws StorageNotAvailableException,PersistenceException;
    public Gym readGym(int gymID) throws StorageNotAvailableException,PersistenceException;
    public void deleteGym(int gymID) throws GymNotFoundException,PersistenceException;
    public void updateGym(Gym gym) throws GymNotFoundException,PersistenceException;
}
