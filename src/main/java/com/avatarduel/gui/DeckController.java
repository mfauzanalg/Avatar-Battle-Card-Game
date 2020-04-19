package com.avatarduel.gui;

import com.avatarduel.component.Player;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 * DeckController serves as a controller for Deck.fxml scene builder
 * CharArea represents a row and 6 colunns of char card the arena
 * @see Text
 */

public class DeckController {
    @FXML private Text airPow;
    @FXML private Text earthPow;
    @FXML private Text firePow;
    @FXML private Text waterPow;
    @FXML private Text deck;
    @FXML private Text energyPow;

    /**
     * Function to set the panel of the deck of the player who owns this deck
     * @param P is parameter for which player is owning this deck
     */

    public void setPanel(Player P){
        energyPow.setText(P.getCurrentElement("ENERGY") + "/" + P.getMaxElement("ENERGY"));
        airPow.setText(P.getCurrentElement("AIR") + "/" + P.getMaxElement("AIR"));
        earthPow.setText(P.getCurrentElement("EARTH") + "/" + P.getMaxElement("EARTH"));
        firePow.setText(P.getCurrentElement("FIRE") + "/" + P.getMaxElement("FIRE"));
        waterPow.setText(P.getCurrentElement("WATER") + "/" + P.getMaxElement("WATER"));
        deck.setText(P.getDeck().getDeck().size() + "/50");
    }
}
