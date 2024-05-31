package Utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Field;
import java.util.List;

public class TableViewUtil {

    public static <T> void populateTable(TableView<T> tableView, List<T> dataList) {
        if (dataList == null || dataList.isEmpty()) {
            return;
        }

        T sampleObject = dataList.get(0);
        Field[] fields = sampleObject.getClass().getDeclaredFields();

        tableView.getColumns().clear();

        for (Field field : fields) {
            TableColumn<T, Object> column = new TableColumn<>(field.getName());
            field.setAccessible(true);
            column.setCellValueFactory(cellData -> {
                try {
                    return new javafx.beans.property.SimpleObjectProperty<>(field.get(cellData.getValue()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return null;
                }
            });
            tableView.getColumns().add(column);
        }

        ObservableList<T> observableList = FXCollections.observableArrayList(dataList);
        tableView.setItems(observableList);
    }
}
