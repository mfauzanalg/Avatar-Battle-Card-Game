package com.avatarduel.gui;

import com.avatarduel.component.Card;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HandSkillActController {
    @FXML private Button confirmButton;

    public void onClick(MouseEvent mouseEvent) {
        LayoutController.gamePhase.playSkillCard(Card.clickIdx, 0);
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }
}
