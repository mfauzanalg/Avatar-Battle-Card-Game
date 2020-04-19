package com.avatarduel.gui;

import com.avatarduel.component.Card;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * WinScreenController serves as a controller for WinScreen.fxml scene builder
 * WinScreen shows a window that is shown when a player wins the game
 * @see Card
 * @see javafx.fxml.Initializable
 */

public class WinScreenController implements Initializable {
    @FXML private Text text;
    @FXML private Button yeayButton;
    @FXML private Text winner;

    /**
     * Function to handle the confirm button
     * @param mouseEvent is  function to invoke the methods that is needed when the button is clicked
     */

    public void onClick(MouseEvent mouseEvent) {
        LayoutController.finishGame = true;
        Stage stage = (Stage) yeayButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Function to handle the confirm button
     * @param location contains the path where the image path of the card is stored
     * @param resources contains resources needed
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        text.setText("GAME OVER");
        winner.setText(LayoutController.winner.getName() + " WIN");
    }
}
