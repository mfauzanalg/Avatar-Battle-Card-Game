package com.avatarduel.gui;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class PlayerInfoController {
    @FXML private Text PlayerName;
    @FXML private Text PlayerHealth;

    public void setName(String name){
        PlayerName.setText(name);
    }

    public void setHealth(String health){
        PlayerHealth.setText("Health : " + health);
    }


}
