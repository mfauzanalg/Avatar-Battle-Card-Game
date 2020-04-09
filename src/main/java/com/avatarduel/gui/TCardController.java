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


    public void loadLandCard(Card card){
        File file = new File (card.getImagePath());
        Image image = new Image(file.toURI().toString());
        pict.setImage(image);
        elmt.setText(card.getElement());
        name.setText(card.getName());
        attrib.setText("this is " + card.getElement() + " Land Card");
        System.out.println(card.getImagePath());
    }

    public void loadCharCard(CharacterCard card){
        File file = new File (card.getImagePath());
        Image image = new Image(file.toURI().toString());
        pict.setImage(image);
        elmt.setText(card.getElement());
        name.setText(card.getName());
        attrib.setText("Attack " + card.getAttack() + " Def : " + card.getDefense() + " Pow " + card.getPower());
        System.out.println(card.getImagePath());
    }

    public void loadSkillCard(SkillCard card){
        File file = new File (card.getImagePath());
        Image image = new Image(file.toURI().toString());
        pict.setImage(image);

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
        name.setText(card.getName());
        attrib.setText("Attack " + card.getAttack() + " Def : " + card.getDefense() + " Pow " + card.getPower());
        System.out.println(card.getImagePath());
    }

    public void loadDestroyCard(DestroySkillCard card){
        elmt.setText(card.getElement());
        name.setText(card.getName());
        attrib.setText("This is Destroy Card");
        System.out.println(card.getImagePath());
    }

    public void loadPowerUpCard(PowerUpSkillCard card){
        elmt.setText(card.getElement());
        name.setText(card.getName());
        attrib.setText("This is Destroy Card");
        System.out.println(card.getImagePath());
    }


    public void loadCard(Card card){
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

}
