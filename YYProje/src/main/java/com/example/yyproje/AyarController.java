package com.example.yyproje;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;


public class AyarController {
    int i =0;
    int sayac;
    int kelimeSayacı=3;
    String selectedFile;
    public String ek_resim;
    public String[] KelimeTur = new String[200];
    public String[] KelimeIng = new String[200];

    @FXML
    private Button button_Arttir;

    @FXML
    private Button button_Azalt;

    @FXML
    private Button button_Geri;

    @FXML
    private Button button_Kaydet;

    @FXML
    private ImageView eklenenResim;

    @FXML
    private Label label_Ksayisi;

    @FXML
    private Hyperlink link_Ekle;


    @FXML
    private TextField text_Ing;

    @FXML
    private TextField text_Tur;

    @FXML
    void Arttir(ActionEvent event) {
        sayac++;
        label_Ksayisi.setText(String.valueOf(sayac));
    }

    @FXML
    void Azalt(ActionEvent event) {
        if(sayac>0 )
        {
            sayac--;
            label_Ksayisi.setText(String.valueOf(sayac));
        }


    }

    @FXML
    void Ekle(ActionEvent event)  throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open a file");
        fileChooser.setInitialDirectory(new File("C:\\")); // Opsiyonel: Başlangıç dizinini ayarlayabilirsiniz.
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG Images", "*.jpg"));

        Stage stage = (Stage) link_Ekle.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {

            kelimeSayacı++;
            ek_resim= String.valueOf(kelimeSayacı);
            ek_resim = ek_resim+".jpg";
            String imagePath = selectedFile.toURI().toString();
            Image image = new Image(imagePath);

            eklenenResim.setImage(image);
            eklenenResim.setFitHeight(200);
            eklenenResim.setFitWidth(300);
            copyFileToResources(selectedFile, String.valueOf(ek_resim));
            link_Ekle.setVisible(false);
        } else {
            System.out.println("No file has been selected");
        }

    }

    private void copyFileToResources(File sourceFile , String newFileName) throws IOException {

        String resourcesPath = "src/main/resources/Img";
        File destDir = new File(resourcesPath);
        if (!destDir.exists()) {
            destDir.mkdirs();
        }
        kelimeSayacı++;
        File destFile = new File(destDir, newFileName);


        Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File copied");
    }


    @FXML
    void Kaydet(ActionEvent event)   {

        KelimeTur[i] = text_Tur.getText();
        KelimeIng[i] = text_Ing.getText();
        i++;
    }
    @FXML
    void Geri(ActionEvent event)  throws IOException{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("anaEkran.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage anaEkran = (Stage)((Node)event.getSource()).getScene().getWindow();
            anaEkran.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}