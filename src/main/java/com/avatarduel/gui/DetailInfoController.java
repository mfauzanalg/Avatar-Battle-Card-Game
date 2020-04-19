package com.avatarduel.gui;

import com.avatarduel.component.*;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.File;

/**
 * DetailInfoController serves as a controller for DetailInfo.fxml scene builder
 * DetailInfo represents 2 boxes that contain the information of the hovered card
 * @see TCardController
 */
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

    /**
     * Function to load the picture of the selected card
     * @param path is parameter for the path of the image of the card that selected
     * @param container is the imageview container of where the picture of the card will be displayed
     */
    public void loadPict (String path, ImageView container){
        File file = new File (path);
        Image image = new Image(file.toURI().toString());
        container.setImage(image);
    }

    /**
     * Function to set a picture of the element of the card that has  been chosen
     * @param elmt is parameter for the element of the card that has been chosen
     * @return return path of the element
     */
    public String setElmtPict(String elmt){
        if (elmt.equals("ENERGY")){ return energyPath; }
        else if(elmt.equals("AIR")){ return airPath; }
        else if(elmt.equals("EARTH")){ return earthPath; }
        else if(elmt.equals("FIRE")){ return firePath; }
        else { return waterPath; }
    }

    /**
     * Function to show the landcard if the card that has been chosen has the type of landcard
     * @param card is parameter for the card that has been chosen
     */
    public void showLandCard(Card card){
        loadPict(setElmtPict(card.getElement()), elmtPict);
        detailStat.setText("This is " + card.getElement() + " Land Card");
    }

    /**
     * Function to show the landcard if the card that has been chosen has the type of charcard
     * @param card is parameter for the card that has been chosen
     * @param atk is the card atk
     * @param def is the card def
     */
    public void showCharCard(CharacterCard card, int atk, int def){
        loadPict(setElmtPict(card.getElement()), elmtPict);
        detailStat.setText("Atk/Def/Pow " + space + atk + "/ " + def + "/" + card.getPower());
    }

    /**
     * Function to show the landcard if the card that has been chosen has the type of skillcard
     * @param card is parameter for the card that has been chosen
     */
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

    /**
     * Function to show the landcard if the card that has been chosen has the type of auracard
     * @param card is parameter for the card that has been chosen
     */
    public void showAuraCard(AuraSkillCard card){
        File file = new File (setElmtPict(card.getElement()));
        Image image = new Image(file.toURI().toString());
        elmtPict.setImage(image);
        detailStat.setText("Atk/Def/Pow " + space + card.getAttack() + "/ " + card.getDefense() + "/" + card.getPower());
    }

    /**
     * Function to show the landcard if the card that has been chosen has the type of destroycard
     * @param card is parameter for the card that has been chosen
     */
    public void showDestroyCard(DestroySkillCard card){
        File file = new File (setElmtPict(card.getElement()));
        Image image = new Image(file.toURI().toString());
        elmtPict.setImage(image);
        detailDesc.setText("This is Destroy Card");
        detailStat.setText("Pow : " + card.getPower());
    }

    /**
     * Function to show the landcard if the card that has been chosen has the type of powercard
     * @param card is parameter for the card that has been chosen
     */
    public void showPowerUpCard(PowerUpSkillCard card){
        File file = new File (setElmtPict(card.getElement()));
        Image image = new Image(file.toURI().toString());
        elmtPict.setImage(image);
        detailDesc.setText("This is PowerUp Card");
        detailStat.setText("Pow : " + card.getPower());
    }

    /**
     * Function to show the landcard if the card that has been chosen has the type of card
     * @param card is parameter for the card that has been chosen
     * @param atk this card attack value
     * @param def this card def value
     */
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
