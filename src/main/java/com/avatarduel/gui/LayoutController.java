package com.avatarduel.gui;

import com.avatarduel.AvatarDuel;
import com.avatarduel.component.Card;
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
    @FXML private SkillAreaController skillArea1Controller;
    @FXML private SkillAreaController skillArea2Controller;
    @FXML private CharAreaController charArea1Controller;
    @FXML private CharAreaController charArea2Controller;
    private String HIDDEN_CARD = "src/main/resources/img/back.png";
    public static Phase gamePhase;

    public void updateDeck(){
        panelP1Controller.setPanel(AvatarDuel.P1);
        panelP2Controller.setPanel(AvatarDuel.P2);
        updateOneHand(gamePhase.getCurrentPlayer());
    }

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
            updateAllHand();
        } catch (IOException e){System.out.println(e);}
    }

    public void draw(MouseEvent mouseEvent) {
        AvatarDuel.P1.draw();
        AvatarDuel.P2.draw();
        onHover();
        updateAllHand();
        panelP2Controller.setPanel(AvatarDuel.P2);
        panelP1Controller.setPanel(AvatarDuel.P1);
    }

    public void hideCard(HandCardController hand, int size){
        Card hiddenCard = new Card();
        hiddenCard.setImagepath(HIDDEN_CARD);
        for (int i = 0; i < size; i++){
            hand.loadCard(hiddenCard, i, 0);
        }
    }

    public void hideChangeTurn(){
        if (gamePhase.getCurrentPlayer().equals(AvatarDuel.P1)){
            hideCard(handCard2Controller, AvatarDuel.P2.getHand().size());
        }else{
            hideCard(handCard1Controller, AvatarDuel.P1.getHand().size());
        }
    }

    public void resetAll() {
        resetOne(AvatarDuel.P1);
        resetOne(AvatarDuel.P2);
    }

    public void resetOne(Player P){
        int fromIndex1 = AvatarDuel.P1.getHand().size();
        int fromIndex2 = AvatarDuel.P2.getHand().size();
        Card emptyCard = new Card();
        if (P.equals(AvatarDuel.P1)){
            for (int i = fromIndex1-1; i < 9; i++){
                handCard1Controller.loadCard(emptyCard, i, 0);
            }
        }
        else{
            for (int i = fromIndex2-1; i < 9; i++){
                handCard2Controller.loadCard(emptyCard, i, 0);
            }
        }
    }

    public void updateAllHand() {
        updateOneHand(AvatarDuel.P1);
        updateOneHand(AvatarDuel.P2);
    }

    public void updateCharArea(){
        Card emptyCard = new Card();
        for (int i = 0; i < 6; i++){
            charArea1Controller.loadCard(emptyCard, i, 0);
            charArea2Controller.loadCard(emptyCard, i, 0);
        }
    }

    public void updateSkillArea(){
        Card emptyCard = new Card();
        for (int i = 0; i < 6; i++){
            skillArea1Controller.loadCard(emptyCard, i, 0);
            skillArea2Controller.loadCard(emptyCard, i, 0);
        }
    }

    public void updateOneHand(Player P){
        if (P.equals(AvatarDuel.P1)){
            resetOne(AvatarDuel.P1);
            for (int i = 0; i < AvatarDuel.P1.getHand().size(); i++){
                handCard1Controller.loadCard(AvatarDuel.P1.getHand().get(i).getCardInstance(), i, 1);
            }
        }
        else{
            resetOne(AvatarDuel.P2);
            for (int i = 0; i < AvatarDuel.P2.getHand().size(); i++){
                handCard2Controller.loadCard(AvatarDuel.P2.getHand().get(i).getCardInstance(), i, 2);
            }
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
        gamePhase.initialize(); updateAllHand(); updateDeck();
        battlePhaseController.setColor(battlePhaseController.getDrawP(), gamePhase.getCurrentPlayer().getName());
        hideCard(handCard2Controller, AvatarDuel.P2.getHand().size());
        updateCharArea(); updateSkillArea();
    }

    public void nextPhase() throws IOException {
        gamePhase.nextPhase();
        switch (gamePhase.getCurrentPhase()){
            case ("draw"):
                updateDeck();
                updateAllHand();
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
                updateOneHand(gamePhase.getCurrentPlayer());
                changeColorPhase("end");
                break;
        }
    }

}
