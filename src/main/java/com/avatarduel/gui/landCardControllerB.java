package com.avatarduel.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;


public class landCardControllerB {
    @FXML
    private Button card;
    @FXML
    private Text desc;
    @FXML
    private Text name;
    @FXML
    private Text attrib;
    @FXML
    private Text element;
    @FXML
    private ImageView img;

    public void setDesc(Text desc){this.desc = desc;}
    public void setName(Text name){this.name = name;}
    public void setAttrib(Text attrib){this.attrib = attrib;}
    public void setElement(Text element){this.element = element;}
    public void setImg(ImageView img){this.img = img;}

    public Button getCard(){return this.card;}
    public Text getDesc(){return this.desc;}
    public Text getName(){return this.name;}
    public Text getAttrib(){return this.attrib;}
    public Text getElement(){return this.element;}
    public ImageView getImage(){return this.img;}
}
