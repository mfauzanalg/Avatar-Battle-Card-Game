package com.avatarduel.gui;

import com.avatarduel.component.Card;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DestroySkillController {
    @FXML private Button confirmButton;

    public void onCLick(MouseEvent mouseEvent) {
        LayoutController.gamePhase.removeBoardSkill(Card.clickIdx);
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }
}
