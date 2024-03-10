module com.example.hayspain {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hayspain to javafx.fxml;
    exports com.example.hayspain;
}