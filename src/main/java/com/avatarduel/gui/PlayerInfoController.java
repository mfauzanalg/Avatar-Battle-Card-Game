package com.avatarduel.gui;

import com.avatarduel.component.Card;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 * PlayerInfoController serves as a controller for PlayerInfo.fxml scene builder
 * PlayerInfo contains a player photo and name
 */
public class PlayerInfoController {
    @FXML private Text playerName;
    @FXML private Text playerHealth;

    /**
     * Function set name
     * @param name contains name
     */
    public void setName(String name){
        playerName.setText(name);
    }

    /**
     * Function to set health
     * @param health is parameter that contains the player's health
     */
    public void setHealth(String health){
        playerHealth.setText("Health : " + health);
    }

}
