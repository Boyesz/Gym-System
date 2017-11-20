package hu.iit.unimiskolc.beadando.repasi6.gym;

import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.*;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.model.Gym;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.GymDAO;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.exceptions.PersistenceException;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.exceptions.StorageNotAvailableException;


import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
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
                        + "	city text NOT NULL,\n"
                        + "	login text NOT NULL,\n"
                        + "	email text NOT NULL\n"
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
                preparedStatement.setBoolean(6,gym.getVerify());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new PersistenceException("Gym creation failed.");
        }

    }

    @Override
    public Collection<Gym> readGym() throws StorageNotAvailableException, PersistenceException {
        Collection<Gym> readGyms = new ArrayList<>();
        Gym readGymObj = null;
        /*try {
            readGymObj = new Gym(1,"init","init","init",true,"init");
        } catch (NoLoginException e) {
            e.printStackTrace();
        } catch (NoNameException e) {
            e.printStackTrace();
        } catch (NoEmailException e) {
            e.printStackTrace();
        } catch (GymIDException e) {
            e.printStackTrace();
        }*/
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlite:./" + "gym";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                PreparedStatement preparedStatement = conn.prepareStatement("SELECT gymid,name,city,login,email,verify FROM Gym");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    readGymObj.setCity(resultSet.getString("city"));
                    readGymObj.setLogin(resultSet.getString("login"));
                    readGymObj.setEmail(resultSet.getString("email"));
                    readGymObj.setGymName(resultSet.getString("name"));
                    readGymObj.setGymID(resultSet.getInt("gymid"));
                    readGymObj.setVerify(resultSet.getBoolean("verify"));
                    readGyms.add(readGymObj);
                }
            }

        } catch (SQLException e) {
            throw new PersistenceException("Cannot read gym's");
        }
        return readGyms;
    }

    @Override
    public Gym readGym(int gymID) throws StorageNotAvailableException, PersistenceException {
        Gym readGymObj = null;
        /*try {
            readGymObj = new Gym(1,"init","init","init",true,"init");
        } catch (NoLoginException e) {
            e.printStackTrace();
        } catch (NoNameException e) {
            e.printStackTrace();
        } catch (NoEmailException e) {
            e.printStackTrace();
        } catch (GymIDException e) {
            e.printStackTrace();
        }*/
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlite:./" + "gym";

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
                    readGymObj.setVerify(resultSet.getBoolean("verify"));
                }
            }
        } catch (SQLException e) {
            throw new PersistenceException("Cannot read gym.");
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
        String url = "jdbc:sqlite:./" + "gym";

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
        String url = "jdbc:sqlite:./" + "gym";

        try (Connection conn = DriverManager.getConnection(url)) {
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE Gym SET gymid = ? , name = ? , city = ? , login = ?, email = ?, verify = ? ");
            preparedStatement.setInt(1,gym.getGymID());
            preparedStatement.setString(2,gym.getGymName());
            preparedStatement.setString(3,gym.getCity());
            preparedStatement.setString(4,gym.getLogin());
            preparedStatement.setString(5,gym.getEmail());
            preparedStatement.setBoolean(6,gym.getVerify());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenceException("Cannot update gym");
        }
    }
}
