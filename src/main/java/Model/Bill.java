package Model;

import java.time.LocalDateTime;

/**
 * Represents the Bill record class that is identical with the table in the database
 * @author maria
 * @since June 2024
 */
public record Bill(Integer billId, int orderId, int clientId, int productId, double orderQuantity, LocalDateTime dateOfBill) {

}