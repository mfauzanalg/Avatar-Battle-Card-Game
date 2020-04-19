package com.avatarduel.gui;

import com.avatarduel.component.Card;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * HandCardActController serves as a controller for DrawInfo.fxml scene builder
 * HandCharAct shows a pop up window that get player to choose attack/defense position
 * @see com.avatarduel.component.Phase
 * @see Card
 */

public class HandCharActController {
    @FXML private Button atkButton;
    @FXML private Button defButton;

    /**
     * Function to handle the attack button
     * @param mouseEvent is  function to invoke the methods that is needed when the button is clicked
     */

    public void atkClick(MouseEvent mouseEvent) {
        LayoutController.gamePhase.summonCharacter(Card.clickIdx, true);
        Stage stage = (Stage) atkButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Function to handle the defense button
     * @param mouseEvent is  function to invoke the methods that is needed when the button is clicked
     */

    public void defClick(MouseEvent mouseEvent) {
        LayoutController.gamePhase.summonCharacter(Card.clickIdx, false);
        Stage stage = (Stage) defButton.getScene().getWindow();
        stage.close();
    }


}
