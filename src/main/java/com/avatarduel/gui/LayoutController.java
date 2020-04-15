package com.avatarduel.gui;

import com.avatarduel.AvatarDuel;
import com.avatarduel.component.Card;
import com.avatarduel.component.IHandCard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LayoutController implements Initializable{
    @FXML private Text detailText;
    @FXML private Text detailName;
    @FXML private ImageView detailPict;
    @FXML private DeckController panelP1Controller;
    @FXML private DeckController panelP2Controller;
    @FXML private HandCardController handCard1Controller;
    @FXML private HandCardController handCard2Controller;
    @FXML private DetailInfoController detailInfoController;
    @FXML private PlayerInfoController playerInfo1Controller;
    @FXML private PlayerInfoController playerInfo2Controller;

    public void draw(MouseEvent mouseEvent) {
        AvatarDuel.P1.draw();
        AvatarDuel.P2.draw();
        onHover();
    }

    public void updateHand() {
        int index = 1;
        int indes = 1;
        for (IHandCard card : AvatarDuel.P1.getHand()) {
            handCard1Controller.loadCard(card.getCardInstance(),index++);
        }
        for (IHandCard card : AvatarDuel.P2.getHand()) {
            handCard2Controller.loadCard(card.getCardInstance(),indes++);
        }
    }

    public void onHover(){
        detailInfoController.showCard(Card.cardHover);
        updateHand();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playerInfo1Controller.setName(AvatarDuel.P1.getName());
        playerInfo2Controller.setName(AvatarDuel.P2.getName());
        playerInfo1Controller.setHealth(Integer.toString(AvatarDuel.P1.getHealth()));
        playerInfo2Controller.setHealth(Integer.toString(AvatarDuel.P1.getHealth()));
        panelP1Controller.initialSet();
        panelP2Controller.initialSet();
    }
    
}
