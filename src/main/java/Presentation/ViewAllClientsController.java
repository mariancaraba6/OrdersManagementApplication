package Presentation;

import BusinessLogic.ClientsBLL;
import DataAccess.ClientsDAO;
import Model.Clients;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static BusinessLogic.ClientsBLL.findAllClients;

public class ViewAllClientsController {

    @FXML
    private TableColumn<?, ?> col1;

    @FXML
    private TableColumn<?, ?> col2;

    @FXML
    private TableColumn<?, ?> col3;

    @FXML
    private TableColumn<?, ?> col4;

    @FXML
    private TableColumn<?, ?> col5;

    @FXML
    private Button goBack;

    @FXML
    private Button showTable;

    @FXML
    private TableView<Clients> tableView;

    @FXML
    void handleClicks(ActionEvent event) {
        col1.setCellValueFactory(new PropertyValueFactory<>("clientId"));
        col2.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        col3.setCellValueFactory(new PropertyValueFactory<>("address"));
        col4.setCellValueFactory(new PropertyValueFactory<>("email"));
        col5.setCellValueFactory(new PropertyValueFactory<>("age"));
        List<Clients> clientsList = findAllClients();
        ObservableList<Clients> clientsObservableList = FXCollections.observableArrayList(clientsList);
        tableView.setItems(clientsObservableList);
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
