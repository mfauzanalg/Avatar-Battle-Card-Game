package com.avatarduel.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * DrawInfoController serves as a controller for DrawInfo.fxml scene builder
 * DrawInfo represents pop up window box to notify the player that a card has been drawn into the hand
 * @see TCardController
 * @see Initializable
 */
public class  DrawInfoController implements Initializable {
    @FXML private Text phaseInfo;
    @FXML private Button drawButton;

    /**
     * Function to initialize the info that will be updated, an implementation of Initializable interface
     * @param location contains the location of the image
     * @param resources contains resources needed
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        phaseInfo.setText("Draw Phase");
    }

    /**
     * Function to close the window
     * @param mouseEvent event of the button clicked
     */
    public void close(MouseEvent mouseEvent) {
        Stage stage = (Stage) drawButton.getScene().getWindow();
        stage.close();
    }
}
