package com.avatarduel.gui;

import com.avatarduel.component.Card;
import javafx.fxml.FXML;

public class SkillAreaController {
    @FXML private TCardController s1Controller;
    @FXML private TCardController s2Controller;
    @FXML private TCardController s3Controller;
    @FXML private TCardController s4Controller;
    @FXML private TCardController s5Controller;
    @FXML private TCardController s6Controller;

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
}
