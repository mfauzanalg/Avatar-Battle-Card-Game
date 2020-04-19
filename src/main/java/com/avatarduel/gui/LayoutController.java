package com.avatarduel.gui;

import com.avatarduel.AvatarDuel;
import com.avatarduel.component.*;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.util.Duration;

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
    @FXML private Text messageBox;
    @FXML private Button nextPhaseButton;

    private String HIDDEN_CARD = "src/main/resources/img/back.png";
    public static Phase gamePhase;
    public static boolean wantAttack = false;
    public static boolean wantSkill = false;
    public static boolean directAtk = false;
    public static boolean finishGame = false;
    public static Player winner;

    /**
     * load new Scene in new Window
     * @param fxml target fxml
     */
    public void loadScene (String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(fxml));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    public void updateDeck() throws IOException {
        sendMessage();
        isDirectAttack();
        messageBox.setText("");
        panelP1Controller.setPanel(AvatarDuel.P1);
        panelP2Controller.setPanel(AvatarDuel.P2);
        updateOneHand(gamePhase.getCurrentPlayer());
        updateAllChar();
        updateAllCSkill();
        updateInfo();
        System.out.println("refresh");
        if(finishGame){
            System.out.println("mantap jiwa");
            loadScene("WinScreen.fxml");
            Stage stage = (Stage) nextPhaseButton.getScene().getWindow();
            stage.close();
        }
    }

    public void isDirectAttack(){
        if (directAtk && wantAttack){
            gamePhase.attackPlayer(Card.clickIdx);
            System.out.println("direct kok attack");
            resetBorder();
            directAtk = false;
        }
    }

    public void resetBorder(){
        charArea1Controller.resetBorder();
        charArea2Controller.resetBorder();
        skillArea1Controller.resetBorder();
        skillArea2Controller.resetBorder();
        handCard1Controller.resetBorder();
        handCard1Controller.resetBorder();
    }

    public void sendMessage(){
        if (wantAttack && !directAtk) messageBox.setText("Select Target to Attack");
        else if (wantSkill) messageBox.setText("Select Target to Use Skill Card");
        else if (!wantAttack || !wantSkill){
            resetBorder();
        }
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
        loadScene("DrawInfo.fxml");
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
        resetOneHand(AvatarDuel.P1);
        resetOneHand(AvatarDuel.P2);
    }

    public void resetOneHand(Player P){
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

    public void resetOneChar(Player P){
        int fromIndex1 = AvatarDuel.P1.getBoard().size();
        int fromIndex2 = AvatarDuel.P2.getBoard().size();
        Card emptyCard = new Card();
        if (P.equals(AvatarDuel.P1)){
            for (int i = fromIndex1-1; i < 6; i++){
                charArea1Controller.loadCard(emptyCard, i, 0);
            }
        }
        else{
            for (int i = fromIndex2-1; i < 6; i++){
                charArea2Controller.loadCard(emptyCard, i, 0);
            }
        }
    }

    public void resetOneSkill(Player P){
        int fromIndex1 = AvatarDuel.P1.getBoard().size();
        int fromIndex2 = AvatarDuel.P2.getBoard().size();
        Card emptyCard = new Card();
        if (P.equals(AvatarDuel.P1)){
            for (int i = fromIndex1-1; i < 6; i++){
                skillArea1Controller.loadCard(emptyCard, i, 0);
            }
        }
        else{
            for (int i = fromIndex2-1; i < 6; i++){
                skillArea2Controller.loadCard(emptyCard, i, 0);
            }
        }
    }

    public void updateAllHand() {
        updateOneHand(AvatarDuel.P1);
        updateOneHand(AvatarDuel.P2);
    }

    public void initialCharArea(){
        Card emptyCard = new Card();
        for (int i = 0; i < 6; i++){
            charArea1Controller.loadCard(emptyCard, i, 0);
            charArea2Controller.loadCard(emptyCard, i, 0);
        }
    }

    public void initialSkillArea(){
        Card emptyCard = new Card();
        for (int i = 0; i < 6; i++){
            skillArea1Controller.loadCard(emptyCard, i, 0);
            skillArea2Controller.loadCard(emptyCard, i, 0);
        }
    }

    public void updateAllChar(){
        updateOneChar(AvatarDuel.P1);
        updateOneChar(AvatarDuel.P2);
    }

    public void updateOneChar(Player P){
        if (P.equals(AvatarDuel.P1)){
//            resetOneChar(AvatarDuel.P1);
            for (int i = 0; i < AvatarDuel.P1.getBoard().size(); i++){
                charArea1Controller.loadBoard(AvatarDuel.P1.getBoard().get(i), i, 1);
                if (!AvatarDuel.P1.getBoard().get(i).getAttackPos()){
                    charArea1Controller.rotateCard(i, true);
                } else {
                    charArea1Controller.rotateCard(i, false);
                }
            }
        }
        else{
//            resetOneChar(AvatarDuel.P2);
            for (int i = 0; i < AvatarDuel.P2.getBoard().size(); i++){
                charArea2Controller.loadBoard(AvatarDuel.P2.getBoard().get(i), i, 2);
                if (!AvatarDuel.P2.getBoard().get(i).getAttackPos()){
                    charArea2Controller.rotateCard(i, true);
                }else{
                    charArea2Controller.rotateCard(i, false);
                }
            }
        }
    }

    public void updateAllCSkill(){
        updateOneSkill(AvatarDuel.P1);
        updateOneSkill(AvatarDuel.P2);
    }

    public void updateOneSkill(Player P){
        if (P.equals(AvatarDuel.P1)){
//            resetOneSkill(AvatarDuel.P1);
            for (int i = 0; i < AvatarDuel.P1.getBoard().size(); i++){
                skillArea1Controller.loadCard(AvatarDuel.P1.getSkillBoard().get(i), i, 1);
            }
        }
        else{
//            resetOneSkill(AvatarDuel.P2);
            for (int i = 0; i < AvatarDuel.P2.getBoard().size(); i++){
                skillArea2Controller.loadCard(AvatarDuel.P2.getSkillBoard().get(i) , i, 2);
            }
        }
    }

    public void updateOneHand(Player P){
        if (P.equals(AvatarDuel.P1)){
            resetOneHand(AvatarDuel.P1);
            for (int i = 0; i < AvatarDuel.P1.getHand().size(); i++){
                handCard1Controller.loadCard(AvatarDuel.P1.getHand().get(i).getCardInstance(), i, 1);
            }
        }
        else{
            resetOneHand(AvatarDuel.P2);
            for (int i = 0; i < AvatarDuel.P2.getHand().size(); i++){
                handCard2Controller.loadCard(AvatarDuel.P2.getHand().get(i).getCardInstance(), i, 2);
            }
        }
    }

    public void onHover(){
        detailInfoController.showCard(Card.cardHover, Card.atk, Card.def);
    }

    public void updateInfo(){
        playerInfo1Controller.setName(AvatarDuel.P1.getName());
        playerInfo2Controller.setName(AvatarDuel.P2.getName());
        playerInfo1Controller.setHealth(Integer.toString(AvatarDuel.P1.getHealth()));
        playerInfo2Controller.setHealth(Integer.toString(AvatarDuel.P2.getHealth()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateInfo();
        panelP1Controller.setPanel(AvatarDuel.P1);
        panelP2Controller.setPanel(AvatarDuel.P2);
        gamePhase = new Phase(AvatarDuel.P1, AvatarDuel.P2);
        try {
            gamePhase.initialize();
            updateDeck();
        } catch (IOException e) {
            e.printStackTrace();
        }
        battlePhaseController.setColor(battlePhaseController.getDrawP(), gamePhase.getCurrentPlayer().getName());
        hideCard(handCard2Controller, AvatarDuel.P2.getHand().size());
        initialCharArea(); initialSkillArea();
    }

    public void nextPhase() throws IOException {
        gamePhase.nextPhase();
        switch (gamePhase.getCurrentPhase()){
            case ("draw"):
                popDrawInfo();
                updateDeck();
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
