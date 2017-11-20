package hu.iit.unimiskolc.beadando.repasi6.gym;

import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.CustomerAlreadyExistsException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.CustomerNotFoundException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.model.Customer;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.CustomerDAO;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.exceptions.PersistenceException;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.exceptions.StorageNotAvailableException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerDAOSQLITE implements CustomerDAO {
    @Override
    public void createCustomer(Customer customer) throws CustomerAlreadyExistsException, PersistenceException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlite:./" + "customer";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                String sql = "CREATE TABLE IF NOT EXISTS Customer (\n"
                        + "	id integer PRIMARY KEY,\n"
                        + "	name text NOT NULL,\n"
                        + "	registrationdate text NOT NULL,\n"
                        + "	login text NOT NULL,\n"
                        + "	birthday text NOT NULL,\n"
                        + "	email text NOT NULL,\n"
                        + "	gymid integer NOT NULL,\n"
                        + "	FOREIGN KEY (gymid) REFERENCES Gym(gymid)\n"
                        + ");";
                Statement statement = conn.createStatement();
                statement.execute(sql);
                sql = "INSERT INTO Customer(id,name,registrationdate,login,birthday,email,gymid) VALUES (?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1,customer.getID());
                preparedStatement.setString(2,customer.getName());
                preparedStatement.setString(3, String.valueOf(customer.getRegistrationDate()));
                preparedStatement.setString(4,customer.getLogin());
                preparedStatement.setString(5, String.valueOf(customer.getBirthDay()));
                preparedStatement.setString(6,customer.getEmail());
                preparedStatement.setInt(7,customer.getGymID());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(Customer customer) throws CustomerNotFoundException, PersistenceException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlite:./" + "customer";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                String sql = "UPDATE Customer SET id=?,name=?,registrationdate=?,login=?,birthday=?,email=?,gymid=?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1,customer.getID());
                preparedStatement.setString(2,customer.getName());
                preparedStatement.setString(3, String.valueOf(customer.getRegistrationDate()));
                preparedStatement.setString(4,customer.getLogin());
                preparedStatement.setString(5, String.valueOf(customer.getBirthDay()));
                preparedStatement.setString(6,customer.getEmail());
                preparedStatement.setInt(7,customer.getGymID());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer readCustomerByName(String name) throws CustomerNotFoundException, PersistenceException {
        Customer readCustomerObj = null;
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlite:./" + "customer";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                PreparedStatement preparedStatement = conn.prepareStatement("SELECT id,name,registrationdate,login,birthday,email,gymid FROM Customer Where name = ?");
                preparedStatement.setString(1,name);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    readCustomerObj.setID(resultSet.getInt("id"));
                    readCustomerObj.setName(resultSet.getString("name"));
                    readCustomerObj.setRegistrationDate(LocalDate.parse(resultSet.getString("registrationdate")));
                    readCustomerObj.setLogin(resultSet.getString("login"));
                    readCustomerObj.setBirthDay(LocalDate.parse(resultSet.getString("birthday")));
                    readCustomerObj.setEmail(resultSet.getString("email"));
                    readCustomerObj.setGymID(resultSet.getInt("gymid"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return readCustomerObj;
    }

    @Override
    public Customer readCustomerByID(int ID) throws CustomerNotFoundException, PersistenceException {
        Customer readCustomerObj = null;
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlite:./" + "customer";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                PreparedStatement preparedStatement = conn.prepareStatement("SELECT id,name,registrationdate,login,birthday,email,gymid FROM Customer Where id = ?");
                preparedStatement.setInt(1,ID);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    readCustomerObj.setID(resultSet.getInt("id"));
                    readCustomerObj.setName(resultSet.getString("name"));
                    readCustomerObj.setRegistrationDate(LocalDate.parse(resultSet.getString("registrationdate")));
                    readCustomerObj.setLogin(resultSet.getString("login"));
                    readCustomerObj.setBirthDay(LocalDate.parse(resultSet.getString("birthday")));
                    readCustomerObj.setEmail(resultSet.getString("email"));
                    readCustomerObj.setGymID(resultSet.getInt("gymid"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return readCustomerObj;
    }

    @Override
    public Collection<Customer> readCustomer(int gymid) throws StorageNotAvailableException, PersistenceException {
        Customer readCustomerObj = null;
        Collection<Customer> readCustomerList = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlite:./" + "customer";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                PreparedStatement preparedStatement = conn.prepareStatement("SELECT id,name,registrationdate,login,birthday,email,gymid FROM Customer Where");
                preparedStatement.setInt(1,gymid);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    readCustomerObj.setID(resultSet.getInt("id"));
                    readCustomerObj.setName(resultSet.getString("name"));
                    readCustomerObj.setRegistrationDate(LocalDate.parse(resultSet.getString("registrationdate")));
                    readCustomerObj.setLogin(resultSet.getString("login"));
                    readCustomerObj.setBirthDay(LocalDate.parse(resultSet.getString("birthday")));
                    readCustomerObj.setEmail(resultSet.getString("email"));
                    readCustomerObj.setGymID(resultSet.getInt("gymid"));
                    readCustomerList.add(readCustomerObj);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return readCustomerList;
    }

    @Override
    public void deleteCustomerByID(int ID) throws CustomerNotFoundException, PersistenceException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlite:./" + "customer";

        try (Connection conn = DriverManager.getConnection(url)) {
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM Customer Where id = ?");
            preparedStatement.setInt(1,ID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
