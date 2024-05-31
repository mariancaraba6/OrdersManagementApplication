package Model;

public class Orders {
    private int orderId;
    private int clientId;
    private int productId;
    private int orderQuantity;
    public Orders() {
    }
    public Orders(int orderId, int clientId, int productId, int orderQuantity) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.productId = productId;
        this.orderQuantity = orderQuantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", clientId=" + clientId +
                ", productId=" + productId +
                ", orderQuantity=" + orderQuantity +
                '}';
    }
}
