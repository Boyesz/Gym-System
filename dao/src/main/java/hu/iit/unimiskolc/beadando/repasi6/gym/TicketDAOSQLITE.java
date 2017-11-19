package hu.iit.unimiskolc.beadando.repasi6.gym;

import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.TicketAlreadyExistsException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.TicketNotFoundException;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.model.Ticket;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.TicketDAO;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.exceptions.PersistenceException;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.exceptions.StorageNotAvailableException;

import java.sql.*;
import java.time.LocalDate;
import java.util.Collection;

public class TicketDAOSQLITE implements TicketDAO {
    @Override
    public void createTicket(Ticket ticket) throws TicketAlreadyExistsException, PersistenceException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlite:./" + "ticket";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                String sql = "CREATE TABLE IF NOT EXISTS  Ticket(\n"
                        + " customerid integer PRIMARY KEY,\n"
                        + "	buytime text NOT NULL,\n"
                        + "	lastupdate text NOT NULL,\n"
                        + "	validfor text NOT NULL,\n"
                        + "	opportunity integer NOT NULL\n"
                        + ");";
                Statement statement = conn.createStatement();
                statement.execute(sql);
                sql = "INSERT INTO Ticket(customerid,buytime,lastupdate,validfor,opportunity) VALUES (?,?,?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1,ticket.getCustomerID());
                preparedStatement.setString(2, String.valueOf(ticket.getBuyTime()));
                preparedStatement.setString(3, String.valueOf(ticket.getLastUpdate()));
                preparedStatement.setString(4, String.valueOf(ticket.getValidFor()));
                preparedStatement.setInt(5,ticket.getOpportunity());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTicket(Ticket ticket) throws TicketNotFoundException, PersistenceException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlite:./" + "ticket";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                String sql = "UPDATE Ticket SET customerid=?,buytime=?,lastupdate=?,validfor=?,opportunity=?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1,ticket.getCustomerID());
                preparedStatement.setString(2, String.valueOf(ticket.getBuyTime()));
                preparedStatement.setString(3, String.valueOf(ticket.getLastUpdate()));
                preparedStatement.setString(4, String.valueOf(ticket.getValidFor()));
                preparedStatement.setInt(5,ticket.getOpportunity());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ticket readTicketByCustomerID(int CustomerID) throws TicketNotFoundException, PersistenceException {
        Ticket readTicketObj = null;
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlite:./" + "ticket";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                PreparedStatement preparedStatement = conn.prepareStatement("SELECT customerid,buytime,lastupdate,validfor,opportunity FROM Customer Where customerid = ?");
                preparedStatement.setInt(1,CustomerID);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    readTicketObj.setCustomerID(resultSet.getInt("customerid"));
                    readTicketObj.setBuyTime(LocalDate.parse(resultSet.getString("buytime")));
                    readTicketObj.setLastUpdate(LocalDate.parse(resultSet.getString("lastupdate")));
                    readTicketObj.setValidFor(LocalDate.parse(resultSet.getString("validfor")));
                    readTicketObj.setOpportunity(resultSet.getInt("opportunity"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return readTicketObj;
    }

    @Override
    public void deleteTicket(int CustomerID) throws TicketNotFoundException, PersistenceException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlite:./" + "ticket";

        try (Connection conn = DriverManager.getConnection(url)) {
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM Customer Where customerid = ?");
            preparedStatement.setInt(1,CustomerID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
