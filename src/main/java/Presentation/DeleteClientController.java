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

import static BusinessLogic.ClientsBLL.deleteClient;
import static BusinessLogic.ClientsBLL.editClient;

/**
 * This is the GUI class for deleting a client with a given id.
 * We can either delete a client or we can go back to the Clients scene where we can do other actions with the Clients table.
 */
public class DeleteClientController {

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
    void switchToClientsScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("clientsScene.fxml")));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
