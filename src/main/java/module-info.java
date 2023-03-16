module com.example.examenmongo {
    requires javafx.controls;
    requires javafx.fxml;
    requires mongo.java.driver;


    opens com.example.examenmongo to javafx.fxml;
    exports com.example.examenmongo;
}