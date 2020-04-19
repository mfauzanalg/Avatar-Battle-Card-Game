package com.avatarduel.gui;
import com.avatarduel.component.Card;
import com.avatarduel.component.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * RotateCardController serves as a controller for RotateCard.fxml scene builder
 * RotateCard shows a window that is shown when a player wins the game
 */

public class RotateCardController {
    @FXML private Button confirmButton;

    /**
     * Function handle the start game button
     * @param mouseEvent is function to invoke the methods that is needed when the button is clicked
     */

    public void onClicked(MouseEvent mouseEvent) {
        LayoutController.gamePhase.changeCardPosition(Card.clickIdx);
        System.out.println(Card.clickIdx);
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }
}

