module org.example.ahorcadofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafaker;


    opens controllers to javafx.fxml;
    exports ui;
    opens ui to javafx.fxml;
    exports controllers;
}