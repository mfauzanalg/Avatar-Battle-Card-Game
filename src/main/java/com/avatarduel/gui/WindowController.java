package com.avatarduel.gui;
import com.avatarduel.AvatarDuel;
import com.avatarduel.component.Card;
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

/**
 * WinScreenController serves as a controller for WinScreen.fxml scene builder
 * WinScreen shows a window that is shown when a player wins the game
 * @see Player
 */

public class WindowController {

    @FXML private TextField player1;
    @FXML private TextField player2;

    @FXML

    /**
     * Function handle the start game button
     * @param actionEvent is function to invoke the methods that is needed when the button is clicked
     */

    public void startGameButton(javafx.event.ActionEvent actionEvent) throws IOException {
        AvatarDuel.P1 = new Player(player1.getText(), 80);
        AvatarDuel.P2 = new Player(player2.getText(), 80);

        AvatarDuel.P1.getDeck().initializeDeck(24, 6, 16, 2, 2);
        AvatarDuel.P2.getDeck().initializeDeck(24, 6, 16, 2, 2);

        Parent layoutParent = FXMLLoader.load(getClass().getClassLoader().getResource("Layout.fxml"));
        Scene layoutScene = new Scene(layoutParent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
//        window.setResizable(false);
        window.setScene(layoutScene);
        window.show();
    }

}
