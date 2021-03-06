package hu.iit.unimiskolc.beadando.repasi6.gym;

import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.*;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.model.Ticket;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.TicketDAO;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.exceptions.PersistenceException;

import java.sql.*;
import java.time.LocalDate;

public class TicketDAOSQLITE implements TicketDAO {
    String url = "jdbc:sqlite:./database/" + "ticket";
    @Override
    public void createTicket(Ticket ticket) throws TicketAlreadyExistsException, PersistenceException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


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
            throw new PersistenceException("Could not create ticket.");
        }
    }

    @Override
    public void updateTicket(Ticket ticket) throws TicketNotFoundException, PersistenceException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

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
            throw new PersistenceException("Could not update ticket.");
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
            throw new PersistenceException("Cannot read tickets.");
        } catch (NoBuyTimeException e) {
            throw new PersistenceException("Missing buytime.");
        } catch (NoValidForException e) {
            throw new PersistenceException("Missing validfor time.");
        } catch (GymIDException e) {
            throw new PersistenceException("Missing gymid.");
        } catch (NoLastUpdateException e) {
            throw new PersistenceException("Missing lastupdate.");
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

        try (Connection conn = DriverManager.getConnection(url)) {
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM Customer Where customerid = ?");
            preparedStatement.setInt(1,CustomerID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenceException("Could not delete ticket.");
        }
    }
}
