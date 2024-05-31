package Model;

import java.time.LocalDateTime;

public record Bill(Integer billId, int orderId, int clientId, int productId, double orderQuantity, LocalDateTime dateOfBill) {

}