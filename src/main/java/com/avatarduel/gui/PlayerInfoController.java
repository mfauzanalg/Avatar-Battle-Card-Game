package com.avatarduel.gui;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class PlayerInfoController {
    @FXML private Text playerName;
    @FXML private Text playerHealth;

    public void setName(String name){
        playerName.setText(name);
    }

    public void setHealth(String health){
        playerHealth.setText("Health : " + health);
    }


}
