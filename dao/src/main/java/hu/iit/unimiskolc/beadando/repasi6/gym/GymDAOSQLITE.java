package hu.iit.unimiskolc.beadando.repasi6.gym;

import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.GymAlreadyExistsException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.GymNotFoundException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.model.Gym;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.GymDAO;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.exceptions.PersistenceException;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.exceptions.StorageNotAvailableException;


import java.io.*;
import java.sql.*;
import java.util.List;

public class GymDAOSQLITE implements GymDAO {


    @Override
    public void createGym(Gym gym) throws GymAlreadyExistsException, PersistenceException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlite:./" + "gym";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                String sql = "CREATE TABLE IF NOT EXISTS Gym (\n"
                        + "	gymid integer PRIMARY KEY,\n"
                        + "	name text NOT NULL,\n"
                        + "	city text NOT NULL\n"
                        + "	login text NOT NULL\n"
                        + "	email text NOT NULL\n"
                        + ");";
                Statement statement = conn.createStatement();
                statement.execute(sql);
                sql = "INSERT INTO Gym(gymid,name,city,login,email) VALUES (?,?,?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1,gym.getGymID());
                preparedStatement.setString(2,gym.getGymName());
                preparedStatement.setString(3,gym.getCity());
                preparedStatement.setString(4,gym.getLogin());
                preparedStatement.setString(5,gym.getEmail());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Gym> readGym() throws StorageNotAvailableException, PersistenceException {
        return null;
    }

    @Override
    public Gym readGym(int gymID) throws StorageNotAvailableException, PersistenceException {
        return null;
    }

    @Override
    public void deleteGym(int gymID) throws GymNotFoundException, PersistenceException {

    }

    @Override
    public void updateGym(Gym gym) throws GymNotFoundException, PersistenceException {

    }
}
