module com.example.beroepsproduct {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens com.example.beroepsproduct.classes to javafx.base;
    opens com.example.beroepsproduct to javafx.fxml;
    exports com.example.beroepsproduct;
}