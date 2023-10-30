module com.example.pentagram {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires opencv;


    opens com.example.pentagram to javafx.fxml;
    opens com.example.pentagram.backend to javafx.base;

    exports com.example.pentagram.frontend;
}