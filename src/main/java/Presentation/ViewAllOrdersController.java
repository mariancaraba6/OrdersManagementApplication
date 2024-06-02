package Presentation;

import Model.Orders;
import Model.Products;
import Utils.TableViewUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static BusinessLogic.OrdersBLL.findAllOrders;
import static BusinessLogic.ProductsBLL.findAllProducts;

/**
 * This is the GUI class for viewing all the Orders in the table.
 * We can either do this or we can go back to the Orders scene where we can do other actions with the Orders table.
 */
public class ViewAllOrdersController {

    @FXML
    private TableColumn<?, ?> col1;

    @FXML
    private TableColumn<?, ?> col2;

    @FXML
    private TableColumn<?, ?> col3;

    @FXML
    private TableColumn<?, ?> col4;

    @FXML
    private Button goBack;

    @FXML
    private Button showTable;

    @FXML
    private TableView<Orders> tableView;

    @FXML
    void handleClicks(ActionEvent event) {
        List<Orders> productsList = findAllOrders();
        TableViewUtil.populateTable(tableView, productsList);
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
