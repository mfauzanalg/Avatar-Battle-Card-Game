package com.avatarduel.gui;

import com.avatarduel.component.*;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.File;

public class DetailInfoController {
    @FXML private Text detailDesc;
    @FXML private Text detailStat;
    @FXML private ImageView detailImage;
    @FXML private Text detailName;
    @FXML private Text detailElmt;

    public String space = "                    ";

    public void showLandCard(Card card){
        detailElmt.setText(card.getElement());
        detailStat.setText("This is " + card.getElement() + " Land Card");
    }

    public void showCharCard(CharacterCard card){
        detailElmt.setText(card.getElement());
        detailStat.setText("Atk/Def/Pow " + space + card.getAttack() + "/ " + card.getDefense() + "/" + card.getPower());
    }

    public void showSkillCard(SkillCard card){
        String eff = card.getEffect();
        if (eff.equals("aura")){
            this.showAuraCard((AuraSkillCard) card);
        }
        else if (eff.equals("destroy")){
            this.showDestroyCard((DestroySkillCard) card);
        }
        else{
            this.showPowerUpCard((PowerUpSkillCard) card);
        }
    }

    public void showAuraCard(AuraSkillCard card){
        detailElmt.setText(card.getElement());
        detailStat.setText("Atk/Def/Pow " + space + card.getAttack() + "/ " + card.getDefense() + "/" + card.getPower());
    }

    public void showDestroyCard(DestroySkillCard card){
        detailDesc.setText("This is Destroy Card");
    }

    public void showPowerUpCard(PowerUpSkillCard card){
        detailDesc.setText("This is PowerUp Card");
    }


    public void showCard(Card card){
        File file = new File (card.getImagePath());
        Image image = new Image(file.toURI().toString());
        detailImage.setImage(image);
        detailDesc.setText(card.getDescription());
        detailName.setText(card.getName());

        String type = card.getType();
        if (type.equals("land")){
            this.showLandCard(card);
        }
        else if (type.equals("character")){
            this.showCharCard((CharacterCard) card);
        }
        else if (type.equals("skill")){
            this.showSkillCard((SkillCard) card);
        }
        else{
            detailElmt.setText("");
            detailStat.setText("");
        }
    }
}
