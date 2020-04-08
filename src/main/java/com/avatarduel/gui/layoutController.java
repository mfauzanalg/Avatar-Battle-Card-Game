package com.avatarduel.gui;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class layoutController {
    @FXML private tCardController P1H1Controller;
    @FXML private tCardController P1H2Controller;
    @FXML private tCardController P1H3Controller;
    @FXML private tCardController P1H4Controller;


    public void drawCard(MouseEvent mouseEvent) {
        P1H1Controller.loadCard();
//        P1H2Controller.loadCard();
//        P1H3Controller.loadCard();
//        P1H4Controller.loadCard();
    }
}
