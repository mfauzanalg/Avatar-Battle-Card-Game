package com.avatarduel.gui;

import com.avatarduel.AvatarDuel;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class layoutController {
    @FXML private landCardController P1H1Controller;
    @FXML private landCardController P1H2Controller;
    @FXML private landCardController P1H3Controller;
    @FXML private landCardController P1H4Controller;


    public void drawCard(MouseEvent mouseEvent) {
        P1H1Controller.loadCard();
//        P1H2Controller.loadCard();
//        P1H3Controller.loadCard();
//        P1H4Controller.loadCard();
    }
}
