module com.example.project4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.project4 to javafx.fxml;
    exports com.example.project4;
    exports src;
    opens src to javafx.fxml;
}