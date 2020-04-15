package com.avatarduel.gui;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class DeckController {
    @FXML private Text airPow;
    @FXML private Text earthPow;
    @FXML private Text firePow;
    @FXML private Text waterPow;
    @FXML private Text energyPow;
    @FXML private Text deck;

    public void initialSet(){
        energyPow.setText("0/0");
        airPow.setText("0/0");
        earthPow.setText("0/0");
        firePow.setText("0/0");
        waterPow.setText("0/0");
        deck.setText("60/60");
    }
}
