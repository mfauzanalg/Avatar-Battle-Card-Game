package com.avatarduel.gui;

import com.avatarduel.AvatarDuel;
import com.avatarduel.component.Card;
import com.avatarduel.component.IHandCard;
import com.avatarduel.component.Phase;
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
    @FXML private BattlePhaseController battlePhaseController;
    Phase gamePhase;

    public void popDrawInfo() throws IOException {
        try{
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("DrawInfo.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("PhaseInfo");
            stage.setScene(scene);
            stage.show();
            updateHand();
        } catch (IOException e){System.out.println(e);}
    }

    public void draw(MouseEvent mouseEvent) {
        AvatarDuel.P1.draw();
        AvatarDuel.P2.draw();
        onHover();
        updateHand();
        panelP2Controller.setPanel(AvatarDuel.P2);
        panelP1Controller.setPanel(AvatarDuel.P1);
    }

    public void updateHand() {
        int index = 1;
        int indeks = 1;
        for (IHandCard card : AvatarDuel.P1.getHand()) {
            handCard1Controller.loadCard(card.getCardInstance(),index++);
        }
        for (IHandCard card : AvatarDuel.P2.getHand()) {
            handCard2Controller.loadCard(card.getCardInstance(),indeks++);
        }
    }

    public void onHover(){
        detailInfoController.showCard(Card.cardHover);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playerInfo1Controller.setName(AvatarDuel.P1.getName());
        playerInfo2Controller.setName(AvatarDuel.P2.getName());
        playerInfo1Controller.setHealth(Integer.toString(AvatarDuel.P1.getHealth()));
        playerInfo2Controller.setHealth(Integer.toString(AvatarDuel.P2.getHealth()));
        panelP1Controller.setPanel(AvatarDuel.P1);
        panelP2Controller.setPanel(AvatarDuel.P2);
        gamePhase = new Phase(AvatarDuel.P1, AvatarDuel.P2);
        gamePhase.initialize(); updateHand(); battlePhaseController.setColor(battlePhaseController.getDrawP(), gamePhase.getCurrentPlayer().getName());
    }

    public void nextPhase() throws IOException {
        gamePhase.nextPhase();
        updateHand();
        switch (gamePhase.getCurrentPhase()){
            case ("draw"):
                popDrawInfo();
                battlePhaseController.resetColor(battlePhaseController.getEndP());
                battlePhaseController.setColor(battlePhaseController.getDrawP(), gamePhase.getCurrentPlayer().getName());
                break;
            case("main"):
                battlePhaseController.resetColor(battlePhaseController.getDrawP());
                battlePhaseController.setColor(battlePhaseController.getMainP(), gamePhase.getCurrentPlayer().getName());
                break;
            case("battle"):
                battlePhaseController.resetColor(battlePhaseController.getMainP());
                battlePhaseController.setColor(battlePhaseController.getBattleP(), gamePhase.getCurrentPlayer().getName());
                break;
            case("end"):
                battlePhaseController.resetColor(battlePhaseController.getBattleP());
                battlePhaseController.setColor(battlePhaseController.getEndP(), gamePhase.getCurrentPlayer().getName());
                break;
        }
    }

}
