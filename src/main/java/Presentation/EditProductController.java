package Presentation;

import Model.Products;
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

import static BusinessLogic.ProductsBLL.editProduct;
import static BusinessLogic.ProductsBLL.insertProduct;

public class EditProductController {

    @FXML
    private Button descriptionLabel;

    @FXML
    private Button goBack;

    @FXML
    private TextField modProductDescription;

    @FXML
    private TextField modProductId;

    @FXML
    private TextField modProductName;

    @FXML
    private TextField modProductPrice;

    @FXML
    private TextField modProductQuantity;

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
        int id = Integer.parseInt(modProductId.getText());
        String name = modProductName.getText();
        String description = modProductDescription.getText();
        double price = Double.parseDouble(modProductPrice.getText());
        int quantity = Integer.parseInt(modProductQuantity.getText());
        Products product = new Products(id, name, description, price, quantity);
        editProduct(product);
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
