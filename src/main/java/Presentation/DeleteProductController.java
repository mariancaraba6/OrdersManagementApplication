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

import static BusinessLogic.ClientsBLL.deleteClient;

public class DeleteProductController {

    @FXML
    private Button clientIdLabel;

    @FXML
    private Button executeDelete;

    @FXML
    private Button goBack;

    @FXML
    private TextField idToBeDeleted;

    @FXML
    void handleClicks(ActionEvent event) {
        int id = Integer.parseInt(idToBeDeleted.getText());
        deleteClient(id);
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
