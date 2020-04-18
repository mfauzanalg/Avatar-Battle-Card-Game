package com.avatarduel.gui;

import com.avatarduel.AvatarDuel;
import com.avatarduel.component.Card;
import com.avatarduel.component.IHandCard;
import com.avatarduel.component.Phase;
import com.avatarduel.component.Player;
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
import java.util.List;
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
    private String HIDDEN_CARD = "src/main/resources/img/back.png";
    public static Phase gamePhase;

    public void changeColorPhase(String phase){
        switch (phase){
            case("draw"):
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

    public void hideCard(HandCardController hand, int size){
        Card hiddenCard = new Card();
        hiddenCard.setImagepath(HIDDEN_CARD);
        for (int i = 0; i < size; i++){
            hand.loadCard(hiddenCard, i);
            System.out.println(hiddenCard.getImagePath());
        }
    }

    public void hideChangeTurn(){
        if (gamePhase.getCurrentPlayer().equals(AvatarDuel.P1)){
            hideCard(handCard2Controller, AvatarDuel.P2.getHand().size());
        }else{
            hideCard(handCard1Controller, AvatarDuel.P1.getHand().size());
        }
    }

    public void reset() {
        int fromIndex1 = AvatarDuel.P1.getHand().size();
        int fromIndex2 = AvatarDuel.P2.getHand().size();

        Card emptyCard = new Card();
        for (int i = fromIndex1-1; i < 9; i++){
            handCard1Controller.loadCard(emptyCard, i);
        }
        for (int i = fromIndex2-1; i < 9; i++){
            handCard2Controller.loadCard(emptyCard, i);
        }
    }

    public void updateHand() {
        reset();
        for (int i = 0; i < AvatarDuel.P1.getHand().size(); i++){
            handCard1Controller.loadCard(AvatarDuel.P1.getHand().get(i).getCardInstance(), i);
        }
        for (int i = 0; i < AvatarDuel.P2.getHand().size(); i++){
            handCard2Controller.loadCard(AvatarDuel.P2.getHand().get(i).getCardInstance(), i);
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
        gamePhase.initialize(); updateHand();
        battlePhaseController.setColor(battlePhaseController.getDrawP(), gamePhase.getCurrentPlayer().getName());
        hideCard(handCard2Controller, AvatarDuel.P2.getHand().size());
    }

    public void nextPhase() throws IOException {
        gamePhase.nextPhase();
        switch (gamePhase.getCurrentPhase()){
            case ("draw"):
                updateHand();
                popDrawInfo();
                changeColorPhase("draw");
                hideChangeTurn();
                break;
            case("main"):
                changeColorPhase("main");
                break;
            case("battle"):
                changeColorPhase("battle");
                break;
            case("end"):
                changeColorPhase("end");
                break;
        }
    }

}
