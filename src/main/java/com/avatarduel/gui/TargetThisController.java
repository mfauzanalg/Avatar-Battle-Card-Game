package com.avatarduel.gui;

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

        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }
}
