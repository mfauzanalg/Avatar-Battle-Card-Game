package com.avatarduel.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class cardController {
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Card.fxml"));

        primaryStage.setTitle("Card");
        primaryStage.setScene(new Scene(root, 100, 100));
        primaryStage.show();
    }
}
