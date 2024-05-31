module com.example.pt2024_30229_caraba_marian_assignment_3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires java.desktop;

    opens Model to javafx.base;

    opens Presentation to javafx.fxml;
    exports Presentation;
}