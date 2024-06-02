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

import static BusinessLogic.ClientsBLL.insertClient;

/**
 * This is the GUI class for adding a client.
 * We can either add a client or we can go back to the Clients scene where we can do other actions with the Clients table.
 */
public class NewClientController {

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
    private TextField newClientAddress;

    @FXML
    private TextField newClientAge;

    @FXML
    private TextField newClientEmail;

    @FXML
    private TextField newClientId;

    @FXML
    private TextField newClientName;

    @FXML
    void handleClicks(ActionEvent event) {
        int id = Integer.parseInt(newClientId.getText());
        String name = newClientName.getText();
        String address = newClientAddress.getText();
        String email = newClientEmail.getText();
        int age = Integer.parseInt(newClientAge.getText());
        Clients client = new Clients(id, name, address, email, age);
        insertClient(client);
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
