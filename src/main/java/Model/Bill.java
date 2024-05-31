package Model;

import java.time.LocalDateTime;

public record Bill(int billId, int orderId, int clientId, int productId, double quantity, LocalDateTime date) {

}