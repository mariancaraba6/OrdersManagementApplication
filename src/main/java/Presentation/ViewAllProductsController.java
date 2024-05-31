package Presentation;

import Model.Clients;
import Model.Products;
import Utils.TableViewUtil;
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
import static BusinessLogic.ProductsBLL.findAllProducts;

public class ViewAllProductsController {

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
    private TableView<Products> tableView;

    @FXML
    void handleClicks(ActionEvent event) {
        List<Products> productsList = findAllProducts();
        TableViewUtil.populateTable(tableView, productsList);
//        col1.setCellValueFactory(new PropertyValueFactory<>("productId"));
//        col2.setCellValueFactory(new PropertyValueFactory<>("productName"));
//        col3.setCellValueFactory(new PropertyValueFactory<>("description"));
//        col4.setCellValueFactory(new PropertyValueFactory<>("price"));
//        col5.setCellValueFactory(new PropertyValueFactory<>("quantity"));
//        productsList = findAllProducts();
//        ObservableList<Products> productsObservableList = FXCollections.observableArrayList(productsList);
//        tableView.setItems(productsObservableList);
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
