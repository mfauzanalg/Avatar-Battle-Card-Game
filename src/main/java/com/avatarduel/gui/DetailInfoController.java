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
    @FXML private Text detailType;
    @FXML private ImageView elmtPict;

    public String space = "                 ";

    private String energyPath = "src/main/resources/img/Elements/Energy.png";
    private String airPath = "src/main/resources/img/Elements/Air.png";
    private String earthPath = "src/main/resources/img/Elements/Earth.png";
    private String firePath = "src/main/resources/img/Elements/Fire.png";
    private String waterPath = "src/main/resources/img/Elements/Water.png";
    private String blankPath = "src/main/resources/com/avatarduel/card/image/blank.png";

    public void loadPict (String path, ImageView container){
        File file = new File (path);
        Image image = new Image(file.toURI().toString());
        container.setImage(image);
    }

    public String setElmtPict(String elmt){
        if (elmt.equals("ENERGY")){ return energyPath; }
        else if(elmt.equals("AIR")){ return airPath; }
        else if(elmt.equals("EARTH")){ return earthPath; }
        else if(elmt.equals("FIRE")){ return firePath; }
        else { return waterPath; }
    }

    public void showLandCard(Card card){
        loadPict(setElmtPict(card.getElement()), elmtPict);
        detailStat.setText("This is " + card.getElement() + " Land Card");
    }

    public void showCharCard(CharacterCard card, int atk, int def){
        loadPict(setElmtPict(card.getElement()), elmtPict);
        detailStat.setText("Atk/Def/Pow " + space + atk + "/ " + def + "/" + card.getPower());
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
        File file = new File (setElmtPict(card.getElement()));
        Image image = new Image(file.toURI().toString());
        elmtPict.setImage(image);
        detailStat.setText("Atk/Def/Pow " + space + card.getAttack() + "/ " + card.getDefense() + "/" + card.getPower());
    }

    public void showDestroyCard(DestroySkillCard card){
        File file = new File (setElmtPict(card.getElement()));
        Image image = new Image(file.toURI().toString());
        elmtPict.setImage(image);
        detailDesc.setText("This is Destroy Card");
        detailStat.setText("Pow : " + card.getPower());
    }

    public void showPowerUpCard(PowerUpSkillCard card){
        File file = new File (setElmtPict(card.getElement()));
        Image image = new Image(file.toURI().toString());
        elmtPict.setImage(image);
        detailDesc.setText("This is PowerUp Card");
        detailStat.setText("Pow : " + card.getPower());
    }


    public void showCard(Card card, int atk, int def){
        if (card.getId() != 0) {
            loadPict(card.getImagePath(), detailImage);
            detailDesc.setText(card.getDescription());
            detailName.setText(card.getName());
            loadPict(blankPath, elmtPict);

            String type = card.getType();
            if (type.equals("land")) {
                this.showLandCard(card);
                detailType.setText("LAND\nCARD");
            } else if (type.equals("character")) {
                this.showCharCard((CharacterCard) card, atk, def);
                detailType.setText("CHARACTER\nCARD");
            } else if (type.equals("skill")) {
                this.showSkillCard((SkillCard) card);
                detailType.setText("SKILL\nCARD");
            } else {
                detailType.setText("");
                detailStat.setText("");
            }
        }
    }
}
