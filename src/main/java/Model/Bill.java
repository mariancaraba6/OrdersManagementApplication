package Model;

import java.time.LocalDateTime;

public record Bill(int billId, int orderId, int clientId, double totalAmount, LocalDateTime date) {

}