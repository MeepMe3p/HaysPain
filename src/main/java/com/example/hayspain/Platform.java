package com.example.hayspain;

import com.example.hayspain.controls.KeyInput;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Platform extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainView.fxml"));
        Scene scene = new Scene(root);

        KeyInput.getInstance().inputScene(scene);

        stage.setScene(scene);
        stage.setTitle("Jump Yay");
        

        stage.setScene(scene);
        stage.show();
    }
}
