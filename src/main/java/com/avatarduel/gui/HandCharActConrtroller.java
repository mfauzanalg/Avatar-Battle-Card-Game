package com.avatarduel.gui;

import com.avatarduel.component.Card;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HandCharActConrtroller {
    @FXML private Button atkButton;
    @FXML private Button defButton;


    public void atkClick(MouseEvent mouseEvent) {
        LayoutController.gamePhase.summonCharacter(Card.clickIdx, true);
        Stage stage = (Stage) atkButton.getScene().getWindow();
        stage.close();
    }

    public void defClick(MouseEvent mouseEvent) {
        LayoutController.gamePhase.summonCharacter(Card.clickIdx, false);
        Stage stage = (Stage) defButton.getScene().getWindow();
        stage.close();
    }


}
