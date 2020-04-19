package com.avatarduel.gui;

import com.avatarduel.component.Card;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AttackBoxController {
    @FXML private Button confirmB;

    public void onClick(MouseEvent mouseEvent) {
//        LayoutController.gamePhase.attackCharacter(Card.clickIdx, 0);
        LayoutController.gamePhase.attackPlayer(Card.clickIdx);
        Stage stage = (Stage) confirmB.getScene().getWindow();
        stage.close();
    }
}
