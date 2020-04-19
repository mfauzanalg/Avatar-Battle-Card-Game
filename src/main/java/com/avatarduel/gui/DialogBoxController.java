package com.avatarduel.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * DialogBoxController serves as a controller for DialogBox.fxml scene builder
 * DialogBox represents a pop up windows box that contains a message for the player
 * @see Button
 */

public class DialogBoxController {
    @FXML private Button button1;
    @FXML private Button button2;
    @FXML private Text message;

    /**
     * Function to set the button and message on the DialogBox scene builder
     */

    public void initial(){
        message.setText("");
        button1.setText("");
        button2.setText("");
        button1.setOpacity(0);
        button2.setOpacity(0);
//        layoutController.updateDeck();
    }
}
