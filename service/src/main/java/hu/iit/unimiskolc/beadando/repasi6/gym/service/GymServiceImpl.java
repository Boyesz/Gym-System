package hu.iit.unimiskolc.beadando.repasi6.gym.service;

import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.GymAlreadyExistsException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.GymNotFoundException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.model.Gym;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.service.GymService;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.GymDAO;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.exceptions.PersistenceException;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.exceptions.StorageNotAvailableException;

import java.util.ArrayList;
import java.util.List;

public class GymServiceImpl implements GymService {

    private GymDAO gymDAO;

    public GymServiceImpl(GymDAO gymDAO) {
        this.gymDAO = gymDAO;
    }


    @Override
    public void createGym(Gym gym) throws GymAlreadyExistsException{
        try {
            gymDAO.createGym(gym);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteGymByID(int gymID) throws GymNotFoundException {
        gymDAO.deleteGym(gymID);
    }

    @Override
    public void updateGym(Gym gym) throws GymNotFoundException {
        gymDAO.updateGym(gym);
    }

    @Override
    public List<Gym> getGym() {
        try {
            return gymDAO.readGym();
        } catch (StorageNotAvailableException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();

    }


    @Override
    public Gym getGymByID(int gymID) throws GymNotFoundException {
        try {
            return gymDAO.readGym(gymID);
        } catch (StorageNotAvailableException e) {
            throw new GymNotFoundException();
        }
    }
}
