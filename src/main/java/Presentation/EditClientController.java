package Presentation;

import Model.Clients;
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

import static BusinessLogic.ClientsBLL.editClient;
import static BusinessLogic.ClientsBLL.insertClient;

public class EditClientController {

    @FXML
    private Button clientAddressLabel;

    @FXML
    private Button clientAgeLabel;

    @FXML
    private Button clientEmailLabel;

    @FXML
    private Button clientIdLabel;

    @FXML
    private Button clientNameLabel;

    @FXML
    private Button goBack;

    @FXML
    private TextField modClientAddress;

    @FXML
    private TextField modClientAge;

    @FXML
    private TextField modClientEmail;

    @FXML
    private TextField modClientId;

    @FXML
    private TextField modClientName;

    @FXML
    void handleClicks(ActionEvent event) {
        int id = Integer.parseInt(modClientId.getText());
        String name = modClientName.getText();
        String address = modClientAddress.getText();
        String email = modClientEmail.getText();
        int age = Integer.parseInt(modClientAge.getText());
        Clients client = new Clients(id, name, address, email, age);
        editClient(client);
    }

    @FXML
    void switchToClientsScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("clientsScene.fxml")));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}