package hu.iit.unimiskolc.beadando.repasi6.gym;

import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.*;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.model.Gym;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.GymDAO;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.PersistenceException;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.exceptions.StorageNotAvailableException;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class GymDAOSQLITE implements GymDAO {

    String url = "jdbc:sqlite:./database/" + "gym";
    @Override
    public void createGym(Gym gym) throws GymAlreadyExistsException, PersistenceException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                String sql = "CREATE TABLE IF NOT EXISTS Gym (\n"
                        + "	gymid integer PRIMARY KEY,\n"
                        + "	name text NOT NULL,\n"
                        + "	city text NOT NULL,\n"
                        + "	login text NOT NULL,\n"
                        + "	email text NOT NULL,\n"
                        + " verify integer NOT NULL DEFAULT '1'"
                        + ");";
                Statement statement = conn.createStatement();
                statement.execute(sql);
                sql = "INSERT INTO Gym(gymid,name,city,login,email,verify) VALUES (?,?,?,?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1,gym.getGymID());
                preparedStatement.setString(2,gym.getGymName());
                preparedStatement.setString(3,gym.getCity());
                preparedStatement.setString(4,gym.getLogin());
                preparedStatement.setString(5,gym.getEmail());
                preparedStatement.setInt(6,gym.getVerify());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new PersistenceException("Gym creation failed.");
        }

    }

    @Override
    public Collection<Gym> readGym() throws StorageNotAvailableException, PersistenceException {
        Collection<Gym> readGyms = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                PreparedStatement preparedStatement = conn.prepareStatement("SELECT gymid,name,city,login,email,verify FROM Gym");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    readGyms.add(new Gym(resultSet.getInt("gymid"),resultSet.getString("email"),resultSet.getString("login"),resultSet.getString("name"),resultSet.getInt("verify"),resultSet.getString("city")));
                }
            }

        } catch (SQLException e) {
            throw new PersistenceException("Cannot read gyms.");
        } catch (GymIDException e) {
            throw new PersistenceException("Missing gymid.");
        } catch (NoEmailException e) {
            throw new PersistenceException("Missing email.");
        } catch (NoNameException e) {
            throw new PersistenceException("Missing gym name.");
        } catch (NoLoginException e) {
            throw new PersistenceException("Missing login.");
        } catch (NoCityException e) {
            throw new PersistenceException("Missing city.");
        }
        int i = 0;

        return readGyms;
    }

    @Override
    public Gym readGym(int gymID) throws StorageNotAvailableException, PersistenceException {
        Gym readGymObj = null;
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                PreparedStatement preparedStatement = conn.prepareStatement("SELECT gymid,name,city,login,email,verify FROM Gym Where gymid = ?");
                preparedStatement.setInt(1,gymID);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    readGymObj.setCity(resultSet.getString("city"));
                    readGymObj.setLogin(resultSet.getString("login"));
                    readGymObj.setEmail(resultSet.getString("email"));
                    readGymObj.setGymName(resultSet.getString("name"));
                    readGymObj.setGymID(gymID);
                    readGymObj.setVerify(resultSet.getInt("verify"));
                }
            }
        } catch (SQLException e) {
            throw new PersistenceException("Cannot read gym.");
        } catch (GymIDException e) {
            throw new PersistenceException("Missing gymid.");
        } catch (NoEmailException e) {
            throw new PersistenceException("Missing email.");
        } catch (NoNameException e) {
            throw new PersistenceException("Missing gym name.");
        } catch (NoLoginException e) {
            throw new PersistenceException("Missing login.");
        } catch (NoCityException e) {
            throw new PersistenceException("Missing city.");
        }
        return readGymObj;
    }

    @Override
    public void deleteGym(int gymID) throws GymNotFoundException, PersistenceException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url)) {
                PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM Gym Where gymid = ?");
                preparedStatement.setInt(1,gymID);
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenceException("Could not delete gym");
        }
    }

    @Override
    public void updateGym(Gym gym) throws GymNotFoundException, PersistenceException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url)) {
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE Gym SET gymid = ? , name = ? , city = ? , login = ?, email = ?, verify = ? ");
            preparedStatement.setInt(1,gym.getGymID());
            preparedStatement.setString(2,gym.getGymName());
            preparedStatement.setString(3,gym.getCity());
            preparedStatement.setString(4,gym.getLogin());
            preparedStatement.setString(5,gym.getEmail());
            preparedStatement.setInt(6,gym.getVerify());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenceException("Cannot update gym");
        }
    }

    @Override
    public int getMaxGymID() throws GymNotFoundException, PersistenceException {
        Gym readGymObj = null;
        int id = 1000;
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                PreparedStatement preparedStatement = conn.prepareStatement("SELECT MAX(gymid) FROM Gym");
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    id = resultSet.getInt(1);

                }
            }
        } catch (SQLException e) {
            throw new PersistenceException("Cannot read gym.");
        }
        return id+1;
    }

    @Override
    public Collection<String[]> getGymNameAndGymID() throws GymNotFoundException, PersistenceException {
        Collection<String[]> readGyms = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                PreparedStatement preparedStatement = conn.prepareStatement("SELECT gymid,name FROM Gym");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    readGyms.add(new String[]{resultSet.getString("name"), String.valueOf(resultSet.getInt("gymid"))});
                }
            }
        } catch (SQLException e) {
            throw new PersistenceException("Cannot read gyms.");
        }
        return readGyms;
    }

}
