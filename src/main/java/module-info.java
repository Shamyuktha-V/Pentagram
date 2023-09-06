module com.example.pentagram {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.pentagram to javafx.fxml;
    exports com.example.pentagram;
}