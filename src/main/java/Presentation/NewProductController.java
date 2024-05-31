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

public class NewProductController {

    @FXML
    private Button descriptionLabel;

    @FXML
    private Button goBack;

    @FXML
    private TextField newProductDescription;

    @FXML
    private TextField newProductId;

    @FXML
    private TextField newProductName;

    @FXML
    private TextField newProductPrice;

    @FXML
    private TextField newProductQuantity;

    @FXML
    private Button priceLabel;

    @FXML
    private Button productIdLabel;

    @FXML
    private Button productNameLabel;

    @FXML
    private Button quantityLabel;

    @FXML
    void handleClicks(ActionEvent event) {

    }

    @FXML
    void switchToProductsScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("productsScene.fxml")));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
