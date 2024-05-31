package Presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

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
    private Button orderIdLabel;

    @FXML
    private Button productIdLabel;

    @FXML
    private Button quantityLabel;

    @FXML
    void handleClicks(ActionEvent event) {

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
