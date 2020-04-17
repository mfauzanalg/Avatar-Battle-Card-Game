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
    private int id;

    private String energyPath = "src/main/resources/img/Elements/Energy.png";
    private String airPath = "src/main/resources/img/Elements/Air.png";
    private String earthPath = "src/main/resources/img/Elements/Earth.png";
    private String firePath = "src/main/resources/img/Elements/Fire.png";
    private String waterPath = "src/main/resources/img/Elements/Water.png";

    public String setElmtPict(String elmt){
        if (elmt.equals("ENERGY")){ return energyPath; }
        else if(elmt.equals("AIR")){ return airPath; }
        else if(elmt.equals("EARTH")){ return earthPath; }
        else if(elmt.equals("FIRE")){ return firePath; }
        else { return waterPath; }
    }

    public void loadLandCard(Card card){
//        elmt.setText(card.getElement());
        File file = new File (setElmtPict(card.getElement()));
        Image image = new Image(file.toURI().toString());
        elmtPict.setImage(image);
        attrib.setText("this is " + card.getElement() + " Land Card");
    }

    public void loadCharCard(CharacterCard card){
//        elmt.setText(card.getElement());
        File file = new File (setElmtPict(card.getElement()));
        Image image = new Image(file.toURI().toString());
        elmtPict.setImage(image);
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
//        elmt.setText(card.getElement());
        File file = new File (setElmtPict(card.getElement()));
        Image image = new Image(file.toURI().toString());
        elmtPict.setImage(image);
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
        this.id = card.getId();
        File file = new File (card.getImagePath());
        Image image = new Image(file.toURI().toString());
        pict.setImage(image);
        name.setText(card.getName());


        String type = card.getType();
        if (type.equals("land")){
            this.loadLandCard(card);
        }
        else if (type.equals("character")){
            this.loadCharCard((CharacterCard) card);
        }
        else{
            this.loadSkillCard((SkillCard) card);
        }
    }

    public void hover(MouseEvent mouseEvent) {
        Card newCard = AvatarDuel.dataBase.get(this.id);
        if (newCard.getId() != 0 ){
            Card.cardHover = newCard;
        }
    }

    public void click(MouseEvent mouseEvent) {
        Card.cardClick1 = AvatarDuel.dataBase.get(this.id);
        showAction();
    }

    public void showAction(){
        try{
            String actionBox;
            String type = Card.cardClick1.getType();
            if (!type.equals("")){
                if (type.equals("land")) {actionBox = "HandLandAct.fxml"; }
                else if (type.equals("character")) {actionBox = "HandCharAct.fxml";}
                else {actionBox = "HandSkillAct.fxml";}

                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(actionBox));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("Select");
                stage.setScene(scene);
                stage.show();
            }
        } catch (IOException e){
            throw new IllegalStateException("Fauzan Keren" + e);
        }
    }
}
