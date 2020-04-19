package com.avatarduel.gui;

import com.avatarduel.AvatarDuel;
import com.avatarduel.component.Card;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TargetThisController {
    @FXML private Button confirmButton;

    public void onClick(MouseEvent mouseEvent) {
        if (LayoutController.wantAttack){
            Card.trg = Card.clickIdx;
            LayoutController.gamePhase.attackCharacter(Card.src, Card.trg);
            LayoutController.wantAttack = false;
        }
        else if (LayoutController.wantSkill){
            Card.trg = Card.clickIdx;
            System.out.println("punya siapa hayoo: " + Card.cardOwner);
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
