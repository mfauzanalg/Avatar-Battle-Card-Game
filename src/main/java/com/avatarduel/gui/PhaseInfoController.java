package com.avatarduel.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class PhaseInfoController implements Initializable {
    @FXML private Text phaseInfo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        phaseInfo.setText("Draw Phase");
    }
}
