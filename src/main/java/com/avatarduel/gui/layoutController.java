package com.avatarduel.gui;

import com.avatarduel.AvatarDuel;
import com.avatarduel.component.Card;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.fxml.Initializable;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class layoutController implements Initializable{
    @FXML private tCardController P1H1Controller;
    @FXML private tCardController P1H2Controller;
    @FXML private tCardController P1H3Controller;
    @FXML private tCardController P1H4Controller;
    @FXML private ImageView detailPict;
    @FXML private Text detailText;
    @FXML private Text p1name;
    @FXML private Text p2name;
    @FXML private Text p1health;
    @FXML private Text p2health;

    public void drawCard(MouseEvent mouseEvent) {
        AvatarDuel.a += 1;
        P1H1Controller.loadCard(AvatarDuel.landData.get(1));
        AvatarDuel.onP1H1 = AvatarDuel.landData.get(1);
        P1H2Controller.loadCard(AvatarDuel.landData.get(2));
        AvatarDuel.onP1H2 = AvatarDuel.landData.get(2);
    }

    public void hoverP1H1(MouseEvent mouseEvent){
        AvatarDuel.cardHover = AvatarDuel.onP1H1;
        File file = new File (AvatarDuel.cardHover.getImagePath());
        Image image = new Image(file.toURI().toString());
        detailPict.setImage(image);
        detailText.setText(AvatarDuel.cardHover.getDescription());
    }

    public void hoverP1H2(MouseEvent mouseEvent){
        AvatarDuel.cardHover = AvatarDuel.onP1H2;
        File file = new File (AvatarDuel.cardHover.getImagePath());
        Image image = new Image(file.toURI().toString());
        detailPict.setImage(image);
        detailText.setText(AvatarDuel.cardHover.getDescription());
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        p1name.setText(AvatarDuel.P1.getName());
        p2name.setText(AvatarDuel.P2.getName());
        p1health.setText("Health : " + Integer.toString(AvatarDuel.P1.getHealth()));
        p2health.setText("Health : " + Integer.toString(AvatarDuel.P2.getHealth()));
    }

}
