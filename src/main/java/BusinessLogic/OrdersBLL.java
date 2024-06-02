package BusinessLogic;

import DataAccess.OrdersDAO;
import Model.Orders;

import java.util.List;
/**
 * Class for the business logic of the Orders class.
 * It is used to call the methods that were implemented in the AbstractDAO class that were extended in the OrdersDAO class
 * @author maria
 * @since June 2024
 */
public class OrdersBLL {
    public static List<Orders> findAllOrders() {
        OrdersDAO ordersDAO = new OrdersDAO();
        return ordersDAO.findAll();
    }

    public static Orders findOrderById(int id) {
        OrdersDAO ordersDAO = new OrdersDAO();
        return ordersDAO.findById(id, "orderId");
    }

    public static void insertOrder(Orders order) {
        OrdersDAO ordersDAO = new OrdersDAO();
        ordersDAO.insert(order);
    }

    public static void editOrder (Orders order) {
        OrdersDAO ordersDAO = new OrdersDAO();
        ordersDAO.update(order, "orderId");
    }

    public static void deleteOrder (int idToBeDeleted) {
        OrdersDAO ordersDAO = new OrdersDAO();
        ordersDAO.delete(idToBeDeleted, "orderId");
    }
}
