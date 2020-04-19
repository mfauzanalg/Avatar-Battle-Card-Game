package com.avatarduel.gui;

import com.avatarduel.component.Card;
import com.avatarduel.component.SummonedCharacter;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * AttackBoxController serves as a controller for AtackBox.fxml scene builder
 * AttackBox represents a pop up button to make an attacking move from a particular player
 * @see Card
 * @see SummonedCharacter
 * @see LayoutController
 */

public class AttackBoxController {
    @FXML private Button confirmB;

    /**
     * Function to invoke responses when confirmB button is pressed
     * @param mouseEvent The player that played the AuraSkillCard
     */
    public void onClick(MouseEvent mouseEvent) {
        LayoutController.wantAttack = true;
        Card.src = Card.clickIdx;
        Stage stage = (Stage) confirmB.getScene().getWindow();
        stage.close();
    }
}
