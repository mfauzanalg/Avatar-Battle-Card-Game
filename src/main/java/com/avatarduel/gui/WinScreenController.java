package com.avatarduel.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class WinScreenController implements Initializable {
    @FXML private Text text;
    @FXML private Button yeayButton;
    @FXML private Text winner;

    public void onClick(MouseEvent mouseEvent) {
        LayoutController.finishGame = true;
        Stage stage = (Stage) yeayButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        text.setText("GAME OVER");
        winner.setText(LayoutController.winner.getName() + " WIN");
    }
}
