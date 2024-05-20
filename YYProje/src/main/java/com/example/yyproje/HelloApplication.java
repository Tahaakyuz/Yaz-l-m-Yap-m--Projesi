package com.example.yyproje;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("girisEkrani.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
        LocalDate today = LocalDate.now();

        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate nextweek = today.plus(1,ChronoUnit.WEEKS);

        System.out.println(today);
        System.out.println(tomorrow);
        System.out.println(nextweek);



    }

    public static void main(String[] args) {
        launch();
    }
}