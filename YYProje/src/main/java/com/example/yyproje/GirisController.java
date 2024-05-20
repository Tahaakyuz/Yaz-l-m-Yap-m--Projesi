package com.example.yyproje;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;

public class GirisController {

    @FXML
    private Button button_Giris;

    @FXML
    private Button button_Kayit;

    @FXML
    private Hyperlink link_unuttum;

    @FXML
    void unuttum(ActionEvent event) throws IOException {
        loadScene(event, "/com/example/yyproje/unuttum.fxml");
    }

    @FXML
    void giris(ActionEvent event) throws IOException {
        loadScene(event, "/com/example/yyproje/anaEkran.fxml");
    }

    @FXML
    void kayit(ActionEvent event) throws IOException {
        loadScene(event, "/com/example/yyproje/kayitol.fxml");
    }

    void loadScene(ActionEvent event, String fxmlFile) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
