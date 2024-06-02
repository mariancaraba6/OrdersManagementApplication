package BusinessLogic;

import DataAccess.BillDAO;
import DataAccess.OrdersDAO;
import Model.Bill;
import Model.Orders;

import java.util.List;

/**
 * Class for the business logic of the Bill class.
 * It is used to call the methods that were implemented in the AbstractDAO class that were extended in the BillDAO class.
 * This specific class only has methods for finding all Bills, and to insert a new Bill that will be called when we insert a new Order.
 * @author maria
 * @since June 2024
 */
public class BillDLL {
    public static List<Bill> findAllBills() {
        BillDAO billDAO = new BillDAO();
        return billDAO.findAll();
    }

    public static void insertBill(Bill bill) {
        BillDAO billDAO = new BillDAO();
        billDAO.insert(bill);

    }
}
