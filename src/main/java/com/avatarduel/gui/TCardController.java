package com.avatarduel.gui;

import com.avatarduel.AvatarDuel;
import com.avatarduel.component.*;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;

/**
 * TargetThisController serves as a controller for TargetThis.fxml scene builder
 * TargetThis shows a window that is shown when a player wins the game
 * @see Card
 * @see CharacterCard
 * @see BoardCard
 * @see CharacterCard
 * @see DestroySkillCard
 * @see AuraBoardCard
 * @see AuraHandCard
 * @see AuraSkillCard
 */

public class TCardController {
    @FXML private Pane mainPane;
    @FXML private Text name;
    @FXML private Text attrib;
    @FXML private ImageView pict;
    @FXML private Text elmt;
    @FXML private ImageView elmtPict;
    @FXML private ImageView cardBackground;
    private Card card;
    private int indeks;
    private int owner;
    private String place;
    private Player cardOwn;
    private int atk;
    private int def;
    private boolean attackPos;
    private boolean canAttack;

    private String energyPath = "src/main/resources/img/Elements/Energy.png";
    private String airPath = "src/main/resources/img/Elements/Air.png";
    private String earthPath = "src/main/resources/img/Elements/Earth.png";
    private String firePath = "src/main/resources/img/Elements/Fire.png";
    private String waterPath = "src/main/resources/img/Elements/Water.png";
    private String blankPath = "src/main/resources/com/avatarduel/card/image/blank.png";
    private String hiddenPath = "src/main/resources/img/back.png";

    /**
     * Function to reset pane to black again
     */
    void resetPane(){
        mainPane.setStyle("-fx-border-color: black; -fx-border-width: 1");
    }

    /**
     * Function change color of selected pane
     */
    void selectedPane(){
        mainPane.setStyle("-fx-border-color: #c74646; -fx-border-width: 3");
    }

    /**
     * Function set element picture
     * @param elmt contains element of a card
     * @return path of the card image
     */

    public String setElmtPict(String elmt){
        if (elmt.equals("ENERGY")){ return energyPath; }
        else if(elmt.equals("AIR")){ return airPath; }
        else if(elmt.equals("EARTH")){ return earthPath; }
        else if(elmt.equals("FIRE")){ return firePath; }
        else { return waterPath; }
    }

    /**
     * Function to load scene
     * @param fxml fxml that will be loaded
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
     * Function to load card image
     * @param container contain image of the card
     * @param path contains the path of the card
     */
    public void loadPict (String path, ImageView container){
        File file = new File (path);
        Image image = new Image(file.toURI().toString());
        container.setImage(image);
    }

    /**
     * Function initialize load
     * @param card contains card
     * @param x contains index of the card
     * @param p contains owner of the card
     * @param place contains place of the card
     */
    public void initialLoad(Card card, int x, int p, String place){
        this.card = card;
        this.indeks = x;
        this.owner = p;
        this.place = place;
        if (p == 1) this.cardOwn = AvatarDuel.P1;
        else if (p == 2) this.cardOwn = AvatarDuel.P2;
        attrib.setText("");
        loadPict(blankPath, cardBackground);
    }

    /**
     * Function initialize load
     * @param card contains card
     * @param x contains index of the card
     * @param p contains owner of the card
     * @param place contains place of the card
     */
    public void loadBoard(BoardCard card, int x, int p, String place){
        initialLoad(card.getCardInstance(), x, p, place);
        this.atk = card.getAttackValue();
        this.def = card.getDefenseValue();
        this.attackPos = card.getAttackPos();
        this.canAttack = card.getCanAttack();

        name.setText("");
        loadPict(blankPath, elmtPict);
        loadPict(blankPath, pict);
        CharacterCard cardInstance =  (CharacterCard) card.getCardInstance();

        if (card.getCardInstance().getId() > 0){
            loadPict(cardInstance.getImagePath(), pict);
            loadPict(setElmtPict(card.getCardInstance().getElement()), elmtPict);
            name.setText(cardInstance.getName());
            attrib.setText("Atk/Def/Pow \n" + card.getAttackValue() + "/ " + card.getDefenseValue() + "/" + cardInstance.getPower());
        }
    }

    /**
     * Function initialize load
     * @param card contains card
     * @param x contains index of the card
     * @param p contains owner of the card
     * @param place contains place of the card
     */
    public void loadCard(Card card, int x, int p, String place){
        initialLoad(card, x, p, place);
        this.atk = 0;
        this.def = 0;

        if (card.getImagePath().equals(hiddenPath)){
            loadPict(card.getImagePath(), cardBackground);
        }
        else{
            loadPict(card.getImagePath(), pict);
        }

        name.setText(card.getName());
        loadPict(blankPath, elmtPict);

        String type = card.getType();
        if (type.equals("land")){
            this.loadLandCard(card);
        }
        else if (type.equals("character")){
            this.loadCharCard((CharacterCard) card);
        }
        else if (type.equals("skill")){
            this.loadSkillCard((SkillCard) card);
        }
    }

    /**
     * Function to load land card
     * @param card contain the card
     */
    public void loadLandCard(Card card){
        loadPict(setElmtPict(card.getElement()), elmtPict);
        attrib.setText("this is " + card.getElement() + " Land Card");
    }

    /**
     * Function to load character card
     * @param card contain the character card
     */
    public void loadCharCard(CharacterCard card){
        loadPict(setElmtPict(card.getElement()), elmtPict);
        attrib.setText("Atk/Def/Pow \n" + card.getAttack() + "/ " + card.getDefense() + "/" + card.getPower());
        this.atk = card.getAttack();
        this.def = card.getDefense();
    }

    /**
     * Function to load skill card
     * @param card contain the skill card
     */
    public void loadSkillCard(SkillCard card){
        String eff = card.getEffect();
        if (eff.equals("aura")){
            this.loadAuraCard((AuraSkillCard) card);
        }
        else if (eff.equals("destroy")){
            this.loadDestroyCard((DestroySkillCard) card);
        }
        else{
            this.loadPowerUpCard((PowerUpSkillCard) card);
        }
    }

    /**
     * Function to load aura card
     * @param card contain the aura card
     */
    public void loadAuraCard(AuraSkillCard card){
        loadPict(setElmtPict(card.getElement()), elmtPict);
        attrib.setText("Atk/Def/Pow \n" + card.getAttack() + "/ " + card.getDefense() + "/" + card.getPower());
        this.atk = card.getAttack();
        this.def = card.getDefense();
    }

     /**
     * Function to load destroy card
     * @param card contain the destroy card
     */
    public void loadDestroyCard(DestroySkillCard card){
        loadPict(setElmtPict(card.getElement()), elmtPict);
        attrib.setText("This is Destroy Card Pow : " + card.getPower());
    }

     /**
     * Function to load power up card
     * @param card contain the power up card
     */
    public void loadPowerUpCard(PowerUpSkillCard card){
        loadPict(setElmtPict(card.getElement()), elmtPict);
        attrib.setText("This is Destroy Card Pow : " + card.getPower());
    }

    /**
     * Function handle the hover
     * @param mouseEvent is function to invoke the methods that is needed when the button is clicked
     */
    public void hover(MouseEvent mouseEvent) {
        Card newCard = this.card;
        int newAtk = this.atk;
        int newDef = this.def;
        if (newCard.getId() != 0){
            Card.cardHover = newCard;
            Card.atk = newAtk;
            Card.def = newDef;
        }
    }

     /**
     * Function handle button
     * @param mouseEvent is function to invoke the methods that is needed when the button is clicked
     */
    public void click(MouseEvent mouseEvent) {
        Card.cardClick1 = this.card;
        showAction();
    }

    /**
     * Function to rotate card
     * @param toDefPost cahnge to this position
     */
    public void rotateCard(boolean toDefPost){
        if (toDefPost){
            RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1), mainPane);
            rotateTransition.setToAngle(90);
            rotateTransition.play();
        }
        else{
            RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1), mainPane);
            rotateTransition.setToAngle(0);
            rotateTransition.play();
        }
    }

    /**
     * Function to show actions
     */
    public void showAction(){
        try{
            if(this.card.getId()<= 0){
                return;
            }
            resetPane();
            String actionBox = null;
            String place = this.place;
            String type = Card.cardClick1.getType();
            Player curPlayer = LayoutController.gamePhase.getCurrentPlayer();
            String curPhase = LayoutController.gamePhase.getCurrentPhase();
            boolean useLand = LayoutController.gamePhase.getUseLand();
            Card.clickIdx = this.indeks;
            Card.cardOwner = this.owner;

            if (LayoutController.wantAttack && LayoutController.directAtk){
                loadScene("DirectAttack.fxml");
            }
            else if (LayoutController.wantAttack || LayoutController.wantSkill){
                loadScene("TargetThis.fxml");
            }
            else if ("main".equals(curPhase)) {
                if (place.equals("hand") && this.cardOwn.equals(curPlayer)) {
                    if (type.equals("land") && (!useLand)) {
                        actionBox = "HandLandAct.fxml";
                    } else if (type.equals("character")) {
                        actionBox = "HandCharAct.fxml";
                    } else if (type.equals("skill")) {
                        actionBox = "HandSkillAct.fxml";
                        selectedPane();
                    }
                    loadScene(actionBox);
                } else if ("main".equals(curPhase)) {
                    if (place.equals("hand") && this.cardOwn.equals(curPlayer)) {
                        if (type.equals("land") && (!useLand)) {
                            actionBox = "HandLandAct.fxml";
                        } else if (type.equals("character")) {
                            actionBox = "HandCharAct.fxml";
                        } else if (type.equals("skill")) {
                            actionBox = "HandSkillAct.fxml";
                            selectedPane();
                        }
                        loadScene(actionBox);
                    } else if (place.equals("character") && this.cardOwn.equals(curPlayer)) {
                        loadScene("RotateCard.fxml");
                    } else if (place.equals("skill") && this.cardOwn.equals(curPlayer)) {
                        loadScene("DestroySkill.fxml");
                    }
                }
            }
            else if (place.equals("character") && this.cardOwn.equals(curPlayer) && "battle".equals(curPhase) && this.attackPos && this.canAttack){
                selectedPane();
                loadScene("AttackBox.fxml");
            }

        } catch (IOException e){
            throw new IllegalStateException("Fauzan Keren" + e);
        }
    }
}
