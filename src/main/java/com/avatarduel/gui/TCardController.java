package com.avatarduel.gui;

import com.avatarduel.AvatarDuel;
import com.avatarduel.component.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class TCardController {
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

    private String energyPath = "src/main/resources/img/Elements/Energy.png";
    private String airPath = "src/main/resources/img/Elements/Air.png";
    private String earthPath = "src/main/resources/img/Elements/Earth.png";
    private String firePath = "src/main/resources/img/Elements/Fire.png";
    private String waterPath = "src/main/resources/img/Elements/Water.png";
    private String blankPath = "src/main/resources/com/avatarduel/card/image/blank.png";
    private String hiddenPath = "src/main/resources/img/back.png";

    public String setElmtPict(String elmt){
        if (elmt.equals("ENERGY")){ return energyPath; }
        else if(elmt.equals("AIR")){ return airPath; }
        else if(elmt.equals("EARTH")){ return earthPath; }
        else if(elmt.equals("FIRE")){ return firePath; }
        else { return waterPath; }
    }

    public void loadScene (String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(fxml));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    public void loadPict (String path, ImageView container){
        File file = new File (path);
        Image image = new Image(file.toURI().toString());
        container.setImage(image);
    }

    public void loadLandCard(Card card){
        loadPict(setElmtPict(card.getElement()), elmtPict);
        attrib.setText("this is " + card.getElement() + " Land Card");
    }

    public void loadCharCard(CharacterCard card){
        loadPict(setElmtPict(card.getElement()), elmtPict);
        attrib.setText("Atk/Def/Pow \n" + card.getAttack() + "/ " + card.getDefense() + "/" + card.getPower());
    }

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

    public void loadAuraCard(AuraSkillCard card){
        loadPict(setElmtPict(card.getElement()), elmtPict);
        attrib.setText("Atk/Def/Pow \n" + card.getAttack() + "/ " + card.getDefense() + "/" + card.getPower());
    }

    public void loadDestroyCard(DestroySkillCard card){
        loadPict(setElmtPict(card.getElement()), elmtPict);
        elmt.setText(card.getElement());
        attrib.setText("This is Destroy Card Pow : " + card.getPower());
    }

    public void loadPowerUpCard(PowerUpSkillCard card){
        loadPict(setElmtPict(card.getElement()), elmtPict);
        elmt.setText(card.getElement());
        attrib.setText("This is Destroy Card Pow : " + card.getPower());
    }

    public void loadCard(Card card, int x, int p, String place){
        this.card = card;
        this.indeks = x;
        this.owner = p;
        this.place = place;
        if (p == 1) this.cardOwn = AvatarDuel.P1;
        else if (p == 2) this.cardOwn = AvatarDuel.P2;
        attrib.setText("");
        loadPict(blankPath, cardBackground);

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

    public void hover(MouseEvent mouseEvent) {
        Card newCard = this.card;
        if (newCard.getId() != 0){
            Card.cardHover = newCard;
        }
    }

    public void click(MouseEvent mouseEvent) {
        Card.cardClick1 = this.card;
        showAction();
    }

    public void showAction(){
        try{
            String actionBox = null;
            String place = this.place;
            String type = Card.cardClick1.getType();
            Player curPlayer = LayoutController.gamePhase.getCurrentPlayer();
            String curPhase = LayoutController.gamePhase.getCurrentPhase();
            Card.clickIdx = this.indeks;

            if (place.equals("hand") && this.cardOwn.equals(curPlayer) && "main".equals(curPhase)){
                if (type.equals("land")) {actionBox = "HandLandAct.fxml"; }
                else if (type.equals("character")) {actionBox = "HandCharAct.fxml";}
                else if (type.equals("skill")) {actionBox = "HandSkillAct.fxml";}

                loadScene(actionBox);
                }
            } catch (IOException e){
                throw new IllegalStateException("Fauzan Keren" + e);
        }
    }
}
