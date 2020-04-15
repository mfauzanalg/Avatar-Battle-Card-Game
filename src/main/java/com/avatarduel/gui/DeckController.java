package com.avatarduel.gui;

import com.avatarduel.component.Player;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class DeckController {
    @FXML private Text airPow;
    @FXML private Text earthPow;
    @FXML private Text firePow;
    @FXML private Text waterPow;
    @FXML private Text deck;
    @FXML private Text energyPow;

    public void setPanel(Player P){
        energyPow.setText(P.getCurrentElement("ENERGY") + "/" + P.getMaxElement("ENERGY"));
        airPow.setText(P.getCurrentElement("AIR") + "/" + P.getMaxElement("AIR"));
        earthPow.setText(P.getCurrentElement("EARTH") + "/" + P.getMaxElement("EARTH"));
        firePow.setText(P.getCurrentElement("FIRE") + "/" + P.getMaxElement("FIRE"));
        waterPow.setText(P.getCurrentElement("WATER") + "/" + P.getMaxElement("WATER"));
        deck.setText(P.getDeck().size() + "/60");
    }
}
