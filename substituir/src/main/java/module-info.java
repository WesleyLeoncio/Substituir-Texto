module com.projeto.substituir {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.projeto.substituir to javafx.fxml;
    exports com.projeto.substituir;
    exports com.projeto.substituir.controller;
    opens com.projeto.substituir.controller to javafx.fxml;
}