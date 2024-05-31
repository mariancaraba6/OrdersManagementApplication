package BusinessLogic;

import DataAccess.BillDAO;
import DataAccess.OrdersDAO;
import Model.Bill;
import Model.Orders;

import java.util.List;

public class BillDLL {
    public static List<Bill> findAllBills() {
        BillDAO billDAO = new BillDAO();
        return billDAO.findAll();
    }

    public static Bill findBillById(int id) {
        BillDAO billDAO = new BillDAO();
        return billDAO.findById(id, "billId");
    }

    public static void insertOrder(Bill bill) {
        BillDAO billDAO = new BillDAO();
        billDAO.insert(bill);

    }
}
