package Presentation;

import Model.Clients;
import Model.Products;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static BusinessLogic.ClientsBLL.findClientById;
import static BusinessLogic.ProductsBLL.findProductById;

/**
 * This is the GUI class for viewing a product by the given ID.
 * We can either do this, or we can go back to the Products scene where we can do other actions with the Products table.
 */
public class ViewProductsByIdController {

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
    private TextField idFilter;

    @FXML
    private Button showTable;

    @FXML
    private TableView<Products> tableView;

    @FXML
    void handleClicks(ActionEvent event) {
        col1.setCellValueFactory(new PropertyValueFactory<>("productId"));
        col2.setCellValueFactory(new PropertyValueFactory<>("productName"));
        col3.setCellValueFactory(new PropertyValueFactory<>("description"));
        col4.setCellValueFactory(new PropertyValueFactory<>("price"));
        col5.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        int id = Integer.parseInt(idFilter.getText());
        Products product = findProductById(id);
        ObservableList<Products> productObservableList = FXCollections.observableArrayList(product);
        tableView.setItems(productObservableList);
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
