package core.service;
import core.model.Gym;
import java.util.List;

public interface IGymService {
    public boolean createGym(Gym gym);

    public boolean deleteGymByID(int gymID);

    public boolean updateGym(Gym gym);

    public List<Gym> getGym();

    public Gym getGymByID(int gymID);

}
