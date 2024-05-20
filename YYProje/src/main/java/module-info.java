module com.example.yyproje {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.yyproje to javafx.fxml;
    exports com.example.yyproje;
}