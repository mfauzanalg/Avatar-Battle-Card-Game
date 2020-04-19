package com.avatarduel.gui;

import com.avatarduel.component.BoardCard;
import com.avatarduel.component.Card;
import com.avatarduel.component.SummonedCharacter;
import javafx.fxml.FXML;

/**
 * CharAreaController serves as a controller for CharArea.fxml scene builder
 * CharArea represents a row and 6 colunns of char card the arena
 * @see TCardController
 */

public class CharAreaController {
    @FXML private TCardController c1Controller;
    @FXML private TCardController c2Controller;
    @FXML private TCardController c3Controller;
    @FXML private TCardController c4Controller;
    @FXML private TCardController c5Controller;
    @FXML private TCardController c6Controller;

    /**
     * Function to switch between case of the input parameter x (index of the card in the arena)
     * @param card is parameter for which card is the input
     * @param x is the index of the card in the arena
     * @param p is the player that own the card
     */

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

    /**
     * Function to switch between case of the input parameter x (index of the card in the arena)
     * @param card is parameter for which card is the input
     * @param x is the index of the card in the arena
     * @param p is the player that own the card
     */

    public void loadBoard(BoardCard card, int x, int p){
        switch (x){
            case 0: c1Controller.loadBoard(card,0, p, "character"); break;
            case 1: c2Controller.loadBoard(card,1, p, "character"); break;
            case 2: c3Controller.loadBoard(card,2, p, "character"); break;
            case 3: c4Controller.loadBoard(card,3, p, "character"); break;
            case 4: c5Controller.loadBoard(card,4, p, "character"); break;
            case 5: c6Controller.loadBoard(card,5, p, "character"); break;
        }
    }

    /**
     * Function to switch between case of the input parameter x (index of the card in the arena that will be rotated)
     * @param x is the condition of the card
     * @param pos is the index of the card in the arena
     */

    public void rotateCard(int x, boolean pos){
        switch (x){
            case 0: c1Controller.rotateCard(pos); break;
            case 1: c2Controller.rotateCard(pos); break;
            case 2: c3Controller.rotateCard(pos); break;
            case 3: c4Controller.rotateCard(pos); break;
            case 4: c5Controller.rotateCard(pos); break;
            case 5: c6Controller.rotateCard(pos); break;
        }
    }

    /**
     * Function to switch between case of the input parameter x (index of the card in the arena that will be resetted)
     */

    public void resetBorder() {
        c1Controller.resetPane();
        c2Controller.resetPane();
        c3Controller.resetPane();
        c4Controller.resetPane();
        c5Controller.resetPane();
        c6Controller.resetPane();
    }
}
