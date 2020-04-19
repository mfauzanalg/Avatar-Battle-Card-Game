package com.avatarduel.gui;
import com.avatarduel.component.Card;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RotateCardController {
    @FXML private Button confirmButton;

    public void onClicked(MouseEvent mouseEvent) {
        LayoutController.gamePhase.changeCardPosition(Card.clickIdx);
        System.out.println(Card.clickIdx);
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }
}

