package com.avatarduel.gui;

import com.avatarduel.component.Card;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * DestroySkillController serves as a controller for DestroySkill.fxml scene builder
 * CharArea represents a pop up window for the player's confirmation of destroying a particular card
 * @see Text
 */

public class DestroySkillController {
    @FXML private Button confirmButton;

    /**
     * Function to invoke some methods when the player clicked the button
     * @param mouseEvent is parameter for which player is owning this deck
     */

    public void onCLick(MouseEvent mouseEvent) {
        LayoutController.gamePhase.removeBoardSkill(Card.clickIdx);
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }
}
