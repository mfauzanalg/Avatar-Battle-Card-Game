package com.avatarduel.gui;

import com.avatarduel.component.Card;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * HandCardController serves as a controller for DrawInfo.fxml scene builder
 * DrawInfo represents pop up window box to notify the player that a card has been drawn into the hand
 * @see TCardController
 * @see Card
 */

public class HandCardController {
    @FXML private TCardController h1Controller;
    @FXML private TCardController h2Controller;
    @FXML private TCardController h3Controller;
    @FXML private TCardController h4Controller;
    @FXML private TCardController h5Controller;
    @FXML private TCardController h6Controller;
    @FXML private TCardController h7Controller;
    @FXML private TCardController h8Controller;
    @FXML private TCardController h9Controller;

    /**
     * Function to load the card that is needed
     * @param card contains the info of the card
     * @param p contains position of the card
     */

    public void loadCard(Card card, int x, int p){
//        card.setIdx(x);
        card.setPlace("hand");
        switch (x){
            case 0: h1Controller.loadCard(card,0,p, "hand"); break;
            case 1: h2Controller.loadCard(card,1,p,"hand"); break;
            case 2: h3Controller.loadCard(card,2,p,"hand"); break;
            case 3: h4Controller.loadCard(card,3,p,"hand"); break;
            case 4: h5Controller.loadCard(card,4,p,"hand"); break;
            case 5: h6Controller.loadCard(card,5,p,"hand"); break;
            case 6: h7Controller.loadCard(card,6,p,"hand"); break;
            case 7: h8Controller.loadCard(card,7,p,"hand"); break;
            case 8: h9Controller.loadCard(card,8,p,"hand"); break;
            default:
        }
    }

    /**
     * Function to reset the border
     */

    public void resetBorder() {
        h1Controller.resetPane();
        h2Controller.resetPane();
        h3Controller.resetPane();
        h4Controller.resetPane();
        h5Controller.resetPane();
        h6Controller.resetPane();
        h7Controller.resetPane();
        h8Controller.resetPane();
        h9Controller.resetPane();
    }
}
