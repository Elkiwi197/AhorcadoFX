module org.example.ahorcadofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafaker;


    opens org.example.ahorcadofx to javafx.fxml;
    exports ui;
    opens ui to javafx.fxml;
    exports controllers;
    opens controllers to javafx.fxml;
}