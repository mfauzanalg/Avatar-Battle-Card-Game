package com.avatarduel.gui;

import com.avatarduel.component.Card;
import com.avatarduel.component.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * HandSkillActController serves as a controller for HandSkillAct.fxml scene builder
 * HandLandAct shows a pop up window that get player to confirm an usage of land card
 * @see com.avatarduel.component.Phase
 * @see Card
 * @see LayoutController
 */
public class HandSkillActController {
    @FXML private Button confirmButton;

    /**
     * Function to handle the confirm button
     * @param mouseEvent is  function to invoke the methods that is needed when the button is clicked
     */
    public void onClick(MouseEvent mouseEvent) {
        LayoutController.wantSkill = true;
        Card.src = Card.clickIdx;
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }
}
