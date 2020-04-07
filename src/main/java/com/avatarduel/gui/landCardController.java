package com.avatarduel.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.File;


public class landCardController {
    @FXML private Text name;
    @FXML private Text attrib;
    @FXML private ImageView pict;
    @FXML private Text elmt;

    public void loadCard(){
        File file = new File ("src/main/resources/com/avatarduel/card/image/land/Spirit Oasis.png");
        Image image = new Image(file.toURI().toString());
        name.setText("Siapa ya");
        attrib.setText("Aku keren");
        pict.setImage(image);
    }

    public void setMiaw(){
        System.out.println("ha");
        name.setText("miaw");
    }

    public void changeName(MouseEvent mouseEvent) {
        this.loadCard();
    }
}
