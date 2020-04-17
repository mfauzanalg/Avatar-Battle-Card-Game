package com.avatarduel.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DrawInfoController implements Initializable {
    @FXML private Text phaseInfo;
    @FXML private Button drawButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        phaseInfo.setText("Draw Phase");
    }

    public void close(MouseEvent mouseEvent) {

        Stage stage = (Stage) drawButton.getScene().getWindow();
        stage.close();
    }
}
