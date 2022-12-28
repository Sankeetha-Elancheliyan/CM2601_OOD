module com.example.submission8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.submission8 to javafx.fxml;
    exports com.example.submission8;
}