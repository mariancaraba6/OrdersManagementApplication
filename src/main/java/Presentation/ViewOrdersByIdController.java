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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static BusinessLogic.OrdersBLL.findOrderById;
import static BusinessLogic.ProductsBLL.findAllProducts;
import static BusinessLogic.ProductsBLL.findProductById;

/**
 * This is the GUI class for viewing an order by the given ID.
 * We can either do this or we can go back to the Orders scene where we can do other actions with the Orders table.
 */
public class ViewOrdersByIdController {

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
    private TextField idFilter;

    @FXML
    private Button showTable;

    @FXML
    private TableView<Orders> tableView;

    @FXML
    void handleClicks(ActionEvent event) {
        int id = Integer.parseInt(idFilter.getText());
        Orders order = findOrderById(id);
        TableViewUtil.populateTable(tableView, List.of(order));
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
