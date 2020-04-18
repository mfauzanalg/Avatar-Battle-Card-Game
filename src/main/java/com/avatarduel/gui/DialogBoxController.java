package com.avatarduel.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class DialogBoxController {
    @FXML private Button button1;
    @FXML private Button button2;
    @FXML private Text message;

    public void initial(){
        message.setText("");
        button1.setText("");
        button2.setText("");
        button1.setOpacity(0);
        button2.setOpacity(0);
//        layoutController.updateDeck();
    }
}
