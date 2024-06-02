package Presentation;

import Model.Bill;
import Model.Clients;
import Model.Orders;
import Model.Products;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

import static BusinessLogic.BillDLL.insertBill;
import static BusinessLogic.ClientsBLL.findClientById;
import static BusinessLogic.ClientsBLL.insertClient;
import static BusinessLogic.OrdersBLL.insertOrder;
import static BusinessLogic.ProductsBLL.editProduct;
import static BusinessLogic.ProductsBLL.findProductById;

/**
 * This is the GUI class for adding an order.
 * We can either add am order or we can go back to the Orders scene where we can do other actions with the Orders table.
 */
public class NewOrderController {

    @FXML
    private Button cliendIdLabel;

    @FXML
    private Button executeAdd;

    @FXML
    private Button goBack;

    @FXML
    private TextField newClientId;

    @FXML
    private TextField newOrderQuantity;

    @FXML
    private TextField newProductId;

    @FXML
    private TextField newOrderId;

    @FXML
    private Button orderIdLabel;

    @FXML
    private Button productIdLabel;

    @FXML
    private Button quantityLabel;

    @FXML
    void handleClicks(ActionEvent event) {
        int orderId = Integer.parseInt(newOrderId.getText());
        int clientId = Integer.parseInt(newClientId.getText());
        int productId = Integer.parseInt(newProductId.getText());
        int quantity = Integer.parseInt(newOrderQuantity.getText());
        Products product = findProductById(productId);
        if(quantity <= product.getQuantity()) {
            Orders order = new Orders(orderId, clientId, productId, quantity);
            product.setQuantity(product.getQuantity() - quantity);
            editProduct(product);
            insertOrder(order);
            Bill bill = new Bill(null, orderId, clientId, productId, quantity, LocalDateTime.now());
            insertBill(bill);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("There is not enough in stock!\n");
            alert.showAndWait();
        }
    }

    @FXML
    void switchToOrdersScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ordersScene.fxml")));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
