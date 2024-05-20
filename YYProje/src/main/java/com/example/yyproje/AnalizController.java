package com.example.yyproje;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class AnalizController {
    @FXML
    private Button button_Geri2;

    @FXML
    void Geri(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("anaEkran.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage ogrAnaliz = (Stage)((Node)event.getSource()).getScene().getWindow();
            ogrAnaliz.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
