package com.avatarduel.gui;

import com.avatarduel.component.Card;
import javafx.fxml.FXML;

public class CharAreaController {
    @FXML private TCardController c1Controller;
    @FXML private TCardController c2Controller;
    @FXML private TCardController c3Controller;
    @FXML private TCardController c4Controller;
    @FXML private TCardController c5Controller;
    @FXML private TCardController c6Controller;

    public void loadCard(Card card, int x){
        card.setIdx(x);
        card.setPlace("character");
        switch (x){
            case 0: c1Controller.loadCard(card); break;
            case 1: c2Controller.loadCard(card); break;
            case 2: c3Controller.loadCard(card); break;
            case 3: c4Controller.loadCard(card); break;
            case 4: c5Controller.loadCard(card); break;
            case 5: c6Controller.loadCard(card); break;
        }
    }

}
