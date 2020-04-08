package com.avatarduel.gui;
import com.avatarduel.AvatarDuel;
import com.avatarduel.component.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;

public class windowController {

    @FXML
    TextField player1;
    @FXML
    TextField player2;

    @FXML
    public void startGameButton(javafx.event.ActionEvent actionEvent) throws IOException {
        AvatarDuel.P1 = new Player(player1.getText(), 80);
        AvatarDuel.P2 = new Player(player2.getText(), 80);

        Parent layoutParent = FXMLLoader.load(getClass().getClassLoader().getResource("Layout.fxml"));
        Scene layoutScene = new Scene(layoutParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(layoutScene);
        window.show();
    }
}
