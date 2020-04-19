package com.avatarduel.gui;

import com.avatarduel.component.BoardCard;
import com.avatarduel.component.Card;
import javafx.fxml.FXML;

public class CharAreaController {
    @FXML private TCardController c1Controller;
    @FXML private TCardController c2Controller;
    @FXML private TCardController c3Controller;
    @FXML private TCardController c4Controller;
    @FXML private TCardController c5Controller;
    @FXML private TCardController c6Controller;

    public void loadCard(Card card, int x, int p){
        card.setPlace("character");
        switch (x){
            case 0: c1Controller.loadCard(card,0, p, "character"); break;
            case 1: c2Controller.loadCard(card,1, p, "character"); break;
            case 2: c3Controller.loadCard(card,2, p, "character"); break;
            case 3: c4Controller.loadCard(card,3, p, "character"); break;
            case 4: c5Controller.loadCard(card,4, p, "character"); break;
            case 5: c6Controller.loadCard(card,5, p, "character"); break;
        }
    }

    public void loadCard(BoardCard card, int x, int p){
        switch (x){
            case 0: c1Controller.loadCard(card,0, p, "character"); break;
            case 1: c2Controller.loadCard(card,1, p, "character"); break;
            case 2: c3Controller.loadCard(card,2, p, "character"); break;
            case 3: c4Controller.loadCard(card,3, p, "character"); break;
            case 4: c5Controller.loadCard(card,4, p, "character"); break;
            case 5: c6Controller.loadCard(card,5, p, "character"); break;
        }
    }

    public void rotateCard(int x){
        switch (x){
            case 0: c1Controller.rotateCard(); break;
            case 1: c2Controller.rotateCard(); break;
            case 2: c3Controller.rotateCard(); break;
            case 3: c4Controller.rotateCard(); break;
            case 4: c5Controller.rotateCard(); break;
            case 5: c6Controller.rotateCard(); break;
        }
    }

}
