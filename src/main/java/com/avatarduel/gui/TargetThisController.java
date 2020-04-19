package com.avatarduel.gui;

import com.avatarduel.AvatarDuel;
import com.avatarduel.component.Card;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * TargetThisController serves as a controller for TargetThis.fxml scene builder
 * TargetThis shows a window that is shown when a player wins the game
 */

public class TargetThisController {
    @FXML private Button confirmButton;

    /**
     * Function handle the start game button
     * @param mouseEvent is function to invoke the methods that is needed when the button is clicked
     */

    public void onClick(MouseEvent mouseEvent) {
        if (LayoutController.wantAttack){
            Card.trg = Card.clickIdx;
            LayoutController.gamePhase.attackCharacter(Card.src, Card.trg);
            LayoutController.wantAttack = false;
        }
        else if (LayoutController.wantSkill){
            Card.trg = Card.clickIdx;
            int curPlayer;
            if (LayoutController.gamePhase.getCurrentPlayer().equals(AvatarDuel.P1)) curPlayer = 1;
            else curPlayer = 2;

            if (curPlayer == Card.cardOwner){
                LayoutController.gamePhase.playSkillCard(Card.src, Card.trg, false);
            } else {
                LayoutController.gamePhase.playSkillCard(Card.src, Card.trg, true);
            }

            LayoutController.wantSkill = false;
        }

        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }
}
