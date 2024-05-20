package com.example.yyproje;

import java.io.File;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javafx.scene.image.ImageView;
import java.io.IOException;


public class OyunController {
    @FXML
    private Button button_Cevap;

    @FXML
    private ImageView image_WordImg;

    @FXML
    private Button button_Geri;

    @FXML
    private Label label_Soru;

    @FXML
    private TextField tfield_Tahmin;


    String dogruCevap = "deniz";
    @FXML
    void cevap(ActionEvent event){
        String Tahmin = tfield_Tahmin.getText();
        if (Tahmin.equals(dogruCevap))
        {
            label_Soru.setText("Dogru");
            int randomImageNumber = Sistem();
            String imagePath = "/Img/" + randomImageNumber + ".jpg";
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            if(image != null)
            {
                image_WordImg.setImage(image);
            }
            else
            {
                System.out.println("Resim Bulunamadı");
            }

        }
        else{
            label_Soru.setText("Yanlış");
        }

    }

    public int Sistem()
    {
        Random rand = new Random();

        int rand_int1 = rand.nextInt(3);
        System.out.println(rand_int1);
        return rand_int1;
    }


    @FXML
    void geri(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("anaEkran.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage oyunuOyna = (Stage)((Node)event.getSource()).getScene().getWindow();
            oyunuOyna.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
