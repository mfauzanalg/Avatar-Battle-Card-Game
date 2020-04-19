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

/**
 * LayoutController serves as a controller for Layout.fxml scene builder
 * Layout shows everythin on the arena
 * @see com.avatarduel.component.Phase
 * @see Card
 * @see LayoutController
 * @see DrawInfoController
 */

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
     * @throws IOException to load new window
     */
    public void loadScene (String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(fxml));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }


    /**
     * Function to Update PLayer Deck and Most of the window
     * @throws IOException to load new window
     */
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
        if(finishGame){
            System.out.println("mantap jiwa");
            loadScene("WinScreen.fxml");
            Stage stage = (Stage) nextPhaseButton.getScene().getWindow();
            stage.close();
        }
    }

    /**
     * Function to validate if a card is playing a direct attack against the enemy player
     */
    public void isDirectAttack(){
        if (directAtk && wantAttack){
            gamePhase.attackPlayer(Card.clickIdx);
            System.out.println("direct kok attack");
            resetBorder();
        }
    }

    /**
     * Function to reset the border of the player
     */
    public void resetBorder(){
        charArea1Controller.resetBorder();
        charArea2Controller.resetBorder();
        skillArea1Controller.resetBorder();
        skillArea2Controller.resetBorder();
        handCard1Controller.resetBorder();
        handCard1Controller.resetBorder();
    }

    /**
     * Function to send message to player when a target is needed when the player cast a skill card
     */
    public void sendMessage(){
        if (wantAttack && !directAtk) messageBox.setText("Select Target to Attack");
        else if (wantSkill) messageBox.setText("Select Target to Use Skill Card");
        else if (!wantAttack || !wantSkill){
            resetBorder();
        }
    }

    /**
     * Function to change the color of the current phase
     * @param phase current player phase
     */
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

    /**
     * Function to show info of the card drawn
     * @throws IOException to load new window
     */
    public void popDrawInfo() throws IOException {
        loadScene("DrawInfo.fxml");
    }

    /**
     * Function to hide opponent card
     * @param hand is parameter that contain a set of card that a player holds in his hand
     * @param size size of number of the card that contained in the hand
     */
    public void hideCard(HandCardController hand, int size){
        Card hiddenCard = new Card();
        hiddenCard.setImagepath(HIDDEN_CARD);
        for (int i = 0; i < size; i++){
            hand.loadCard(hiddenCard, i, 0);
        }
    }

    /**
     * Function to hide the card based on player's turn
     */
    public void hideChangeTurn(){
        if (gamePhase.getCurrentPlayer().equals(AvatarDuel.P1)){
            hideCard(handCard2Controller, AvatarDuel.P2.getHand().size());
        }else{
            hideCard(handCard1Controller, AvatarDuel.P1.getHand().size());
        }
    }


    /**
     * Function to reset the hand of the player
     * @param P player whom the hand card will be reset
     */
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


    /**
     * Function to initialize char area
     */
    public void initialCharArea(){
        Card emptyCard = new Card();
        for (int i = 0; i < 6; i++){
            charArea1Controller.loadCard(emptyCard, i, 0);
            charArea2Controller.loadCard(emptyCard, i, 0);
        }
    }

    /**
     * Function to initialize skill area
     */
    public void initialSkillArea(){
        Card emptyCard = new Card();
        for (int i = 0; i < 6; i++){
            skillArea1Controller.loadCard(emptyCard, i, 0);
            skillArea2Controller.loadCard(emptyCard, i, 0);
        }
    }

    /**
     * Function to update all char in area
     */
    public void updateAllChar(){
        updateOneChar(AvatarDuel.P1);
        updateOneChar(AvatarDuel.P2);
    }

    /**
     * Function to update char
     * @param P update charater card of a player
     */
    public void updateOneChar(Player P){
        if (P.equals(AvatarDuel.P1)){
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

    /**
     * Function to update all character skill
     */
    public void updateAllCSkill(){
        updateOneSkill(AvatarDuel.P1);
        updateOneSkill(AvatarDuel.P2);
    }

    /**
     * Function to update skill card
     * @param P update skill card of a player
     */
    public void updateOneSkill(Player P){
        if (P.equals(AvatarDuel.P1)){
            for (int i = 0; i < AvatarDuel.P1.getBoard().size(); i++){
                skillArea1Controller.loadCard(AvatarDuel.P1.getSkillBoard().get(i), i, 1);
            }
        }
        else{
            for (int i = 0; i < AvatarDuel.P2.getBoard().size(); i++){
                skillArea2Controller.loadCard(AvatarDuel.P2.getSkillBoard().get(i) , i, 2);
            }
        }
    }

    /**
     * Function to update one hand card
     * @param P update hand card of a player
     */
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

    /**
     * Function to know when a card is hovered over
     */
    public void onHover(){
        detailInfoController.showCard(Card.cardHover, Card.atk, Card.def);
    }

    /**
     * Function to update info of a card
     */
    public void updateInfo(){
        playerInfo1Controller.setName(AvatarDuel.P1.getName());
        playerInfo2Controller.setName(AvatarDuel.P2.getName());
        playerInfo1Controller.setHealth(Integer.toString(AvatarDuel.P1.getHealth()));
        playerInfo2Controller.setHealth(Integer.toString(AvatarDuel.P2.getHealth()));
    }

    /**
     * Function to update skill card
     * @param location contains path of the image of thhe card
     * @param resources contains resources needed
     */
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

    /**
     * Function switch to next phase
     * @throws IOException to load new window
     */
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
