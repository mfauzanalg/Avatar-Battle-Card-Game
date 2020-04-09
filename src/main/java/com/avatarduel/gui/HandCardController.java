package com.avatarduel.gui;

import com.avatarduel.component.Card;
import javafx.fxml.FXML;

public class HandCardController {
    @FXML private TCardController H1Controller;
    @FXML private TCardController H2Controller;
    @FXML private TCardController H3Controller;
    @FXML private TCardController H4Controller;
    @FXML private TCardController H5Controller;
    @FXML private TCardController H6Controller;
    @FXML private TCardController H7Controller;
    @FXML private TCardController H8Controller;
    @FXML private TCardController H9Controller;

    public void loadCard(Card card, int x){
        switch (x){
            case 1: H1Controller.loadCard(card); break;
            case 2: H2Controller.loadCard(card); break;
            case 3: H3Controller.loadCard(card); break;
            case 4: H4Controller.loadCard(card); break;
            case 5: H5Controller.loadCard(card); break;
            case 6: H6Controller.loadCard(card); break;
            case 7: H7Controller.loadCard(card); break;
            case 8: H8Controller.loadCard(card); break;
            case 9: H9Controller.loadCard(card); break;
            default:
        }
    }

}
