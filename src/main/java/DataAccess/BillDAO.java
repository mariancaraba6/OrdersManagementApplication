package DataAccess;

import Model.Bill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import Connection.ConnectionFactory;

/**
 * This class is used to perform database operations related to Bill table, such as retrieving,
 * inserting, editing, and deleting clients. It has separate implementation from the other classes because the createObject
 * method from AbstractDAO calls the empty constructor, but the Bill table is implemented as a record and it cannot have an
 * empty constructor.
 * @author maria
 * @since June 2024
 */
public class BillDAO extends AbstractDAO<Bill>{
    public List<Bill> findAll( ) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectAllQuery();
        List<Bill> result = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Integer billId = resultSet.getInt("billId");
                Integer orderId = resultSet.getInt("orderId");
                Integer clientId = resultSet.getInt("clientId");
                Integer productId = resultSet.getInt("productId");
                Double quantity = resultSet.getDouble("orderQuantity");
                LocalDateTime dateOfBill = resultSet.getTimestamp("dateOfBill").toLocalDateTime();
                result.add(new Bill(billId, orderId, clientId, productId, quantity, dateOfBill));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return result;
    }
}
