package com.avatarduel.gui;

import com.avatarduel.AvatarDuel;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class layoutController implements Initializable{
    @FXML private tCardController P1H1Controller;
    @FXML private tCardController P1H2Controller;
    @FXML private tCardController P1H3Controller;
    @FXML private tCardController P1H4Controller;
    @FXML private Text p1name;
    @FXML private Text p2name;
    @FXML private Text p1health;
    @FXML private Text p2health;

    public void drawCard(MouseEvent mouseEvent) {
        P1H1Controller.loadCard();

//        P1H2Controller.loadCard();
//        P1H3Controller.loadCard();
//        P1H4Controller.loadCard();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        p1name.setText(AvatarDuel.P1.getName());
        p2name.setText(AvatarDuel.P2.getName());
        p1health.setText("Health : " + Integer.toString(AvatarDuel.P1.getHealth()));
        p2health.setText("Health : " + Integer.toString(AvatarDuel.P2.getHealth()));
    }
}
