package com.avatarduel.gui;

import com.avatarduel.AvatarDuel;
import com.avatarduel.component.Card;
import com.avatarduel.component.SummonedCharacter;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

/**
 * BattlePhaseController serves as a controller for BattlePhase.fxml scene builder
 * BattlePhase represents a column of phases in a battle
 * @see Card
 * @see SummonedCharacter
 */

public class BattlePhaseController {
    @FXML private AnchorPane drawP;
    @FXML private AnchorPane mainP;
    @FXML private AnchorPane battleP;
    @FXML private AnchorPane endP;

    /**
     * Function to get a draw phase
     * @return a highlight to an anchorPane that contains where is the current state of the game (draw phase)
     */
    public AnchorPane getDrawP(){
        return this.drawP;
    }

    /**
     * Function to get a main phase
     * @return a highlight to an anchorPane that contains where is the current state of the game (main phase)
     */
    public AnchorPane getMainP(){
        return this.mainP;
    }

    /**
     * Function to get a battle phase
     * @return a highlight to an anchorPane that contains where is the current state of the game (battle phase)
     */
    public AnchorPane getBattleP(){
        return this.battleP;
    }

    /**
     * Function to get a end phase
     * @return a highlight to an anchorPane that contains where is the current state of the game (end phase)
     */
    public AnchorPane getEndP(){
        return this.endP;
    }

    /**
     * Function to set the color of current phase's row and current player
     * @param P is an anchorpane that contain the game state
     * @param player contains the player who owns the turn
     */
    public void setColor(AnchorPane P, String player){
        String P1 = AvatarDuel.P1.getName();
        String P2 = AvatarDuel.P2.getName();
        if (player.equals(P1)) P.setStyle("-fx-background-color: #c2dbed; -fx-border-width: 1; -fx-border-color: black");
        else  P.setStyle("-fx-background-color: #ed8c8c; -fx-border-width: 1; -fx-border-color: black");
    }

    /**
     * Function to reset the color of current phase's row to default
     * @param P is an anchorpane that contain the game state
     */
    public void resetColor(AnchorPane P){
        P.setStyle("#c2dbed; -fx-border-width: 1; -fx-border-color: black");
    }
}
