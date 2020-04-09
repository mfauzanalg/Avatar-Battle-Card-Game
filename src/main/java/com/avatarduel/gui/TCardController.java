package com.avatarduel.gui;

import com.avatarduel.AvatarDuel;
import com.avatarduel.component.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.File;

public class TCardController {
    @FXML private Text name;
    @FXML private Text attrib;
    @FXML private ImageView pict;
    @FXML private Text elmt;
    private int id;




    public void loadLandCard(Card card){
        elmt.setText(card.getElement());
        attrib.setText("this is " + card.getElement() + " Land Card");
    }

    public void loadCharCard(CharacterCard card){
        elmt.setText(card.getElement());
        attrib.setText("Attack " + card.getAttack() + " Def : " + card.getDefense() + " Pow " + card.getPower());
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
        elmt.setText(card.getElement());
        attrib.setText("Attack " + card.getAttack() + " Def : " + card.getDefense() + " Pow " + card.getPower());
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
         Card.cardHover = AvatarDuel.dataBase.get(this.id);
    }
}
