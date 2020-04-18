package com.avatarduel.gui;

import com.avatarduel.AvatarDuel;
import com.avatarduel.component.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
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
    private int id;

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
        elmt.setText(card.getElement());
        attrib.setText("This is Destroy Card");
    }

    public void loadPowerUpCard(PowerUpSkillCard card){
        elmt.setText(card.getElement());
        attrib.setText("This is Destroy Card");
    }

    public void loadCard(Card card){
        this.card = card;
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
            String place = Card.cardClick1.getPlace();
            String type = Card.cardClick1.getType();
            int idx = Card.cardClick1.getIdx();
            int owner = Card.cardClick1.getOwner();
            if (place.equals("hand")){
                if (type.equals("land")) {actionBox = "HandLandAct.fxml"; }
                else if (type.equals("character")) {actionBox = "HandCharAct.fxml";}
                else if (type.equals("skill")) {actionBox = "HandSkillAct.fxml";}
                System.out.println("indeks : " + idx);
                System.out.println("Punya siapa :" + owner);

                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(actionBox));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("");
                stage.setScene(scene);
                stage.show();
            }
        } catch (IOException e){
            throw new IllegalStateException("Fauzan Keren" + e);
        }
    }
}
