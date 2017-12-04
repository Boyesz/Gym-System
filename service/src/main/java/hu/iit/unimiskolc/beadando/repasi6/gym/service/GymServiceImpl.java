package hu.iit.unimiskolc.beadando.repasi6.gym.service;

import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.GymAlreadyExistsException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.GymNotFoundException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.model.Gym;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.service.GymService;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.GymDAO;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.PersistenceException;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.exceptions.LoginAlreadyExistsException;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.exceptions.StorageNotAvailableException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class GymServiceImpl implements GymService {

    private GymDAO gymDAO;

    public GymServiceImpl(GymDAO gymDAO) {
        this.gymDAO = gymDAO;
    }


    @Override
    public void createGym(Gym gym) throws GymAlreadyExistsException, PersistenceException {
        try {
            gymDAO.createGym(gym);
        } catch (LoginAlreadyExistsException e) {
            throw new GymAlreadyExistsException();
        }
    }

    @Override
    public int getMaxGymID() throws GymNotFoundException, PersistenceException {
           return gymDAO.getMaxGymID();
    }

    @Override
    public void deleteGymByID(int gymID) throws GymNotFoundException, PersistenceException {
            gymDAO.deleteGym(gymID);
    }

    @Override
    public void updateGym(Gym gym) throws GymNotFoundException {
        try {
            gymDAO.updateGym(gym);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Gym> getGym() throws PersistenceException {
        try {
            return gymDAO.readGym();
        } catch (StorageNotAvailableException e) {
            throw new PersistenceException(e);
        }
    }


    @Override
    public Gym getGymByID(int gymID) throws GymNotFoundException, PersistenceException {
        try {
            return gymDAO.readGym(gymID);
        } catch (StorageNotAvailableException e) {
            throw new GymNotFoundException();
        }
    }

    @Override
    public Collection<String[]> allGymNameAndGymID() throws GymNotFoundException, PersistenceException {
            return gymDAO.getGymNameAndGymID();
    }
}
