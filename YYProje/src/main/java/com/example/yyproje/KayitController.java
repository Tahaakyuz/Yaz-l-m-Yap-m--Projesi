package com.example.yyproje;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class KayitController {

    @FXML
    private Button button_Kayit;

    @FXML
    void kayit(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("girisEkrani.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage anaEkran = (Stage)((Node)event.getSource()).getScene().getWindow();
            anaEkran.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }


}
