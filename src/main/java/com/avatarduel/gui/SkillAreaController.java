package com.avatarduel.gui;

import com.avatarduel.component.Card;
import javafx.fxml.FXML;

/**
 * RotateCardController serves as a controller for RotateCard.fxml scene builder
 * RotateCard shows a window that is shown when a player wins the game
 */
public class SkillAreaController {
    @FXML private TCardController s1Controller;
    @FXML private TCardController s2Controller;
    @FXML private TCardController s3Controller;
    @FXML private TCardController s4Controller;
    @FXML private TCardController s5Controller;
    @FXML private TCardController s6Controller;

    /**
     * Function handle the start game button
     * @param card contains card that will be rotated
     * @param p contains owner of the card
     * @param x is index of the card
     */
    public void loadCard(Card card, int x, int p){
//        card.setIdx(x);
        card.setPlace("skill");
        switch (x){
            case 0: s1Controller.loadCard(card,0, p, "skill"); break;
            case 1: s2Controller.loadCard(card,1, p, "skill"); break;
            case 2: s3Controller.loadCard(card,2, p, "skill"); break;
            case 3: s4Controller.loadCard(card,3, p, "skill"); break;
            case 4: s5Controller.loadCard(card,4, p, "skill");break;
            case 5: s6Controller.loadCard(card,5, p, "skill"); break;
        }
    }

    /**
     * Function to reset the bordercard
     */
    public void resetBorder() {
        s1Controller.resetPane();
        s2Controller.resetPane();
        s3Controller.resetPane();
        s4Controller.resetPane();
        s5Controller.resetPane();
        s6Controller.resetPane();
    }
}
