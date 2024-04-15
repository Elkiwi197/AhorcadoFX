module org.example.ahorcadofx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ahorcadofx to javafx.fxml;
    exports org.example.ahorcadofx;
}