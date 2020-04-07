package com.avatarduel.gui;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;

public class windowController {
    public void startGameButton(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent layoutParent = FXMLLoader.load(getClass().getClassLoader().getResource("Layout.fxml"));
        Scene layoutScene = new Scene(layoutParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(layoutScene);
        window.show();
    }
}
