package com.avatarduel.gui;

import com.avatarduel.AvatarDuel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.File;


public class tCardController {
    @FXML private Text name;
    @FXML private Text attrib;
    @FXML private ImageView pict;
    @FXML private Text elmt;

    public void dummyLoad(){
        File file = new File ("src/main/resources/com/avatarduel/card/image/land/Spirit Oasis.png");
        Image image = new Image(file.toURI().toString());
        name.setText("Siapa ya");
        attrib.setText("Aku keren");
        pict.setImage(image);
    }

    public void loadCard(){
        AvatarDuel.a += 1;
//        System.out.println(AvatarDuel.a);
//        System.out.println(AvatarDuel.landData.size());
        File file = new File (AvatarDuel.landData.get(AvatarDuel.a).getImagePath());
        Image image = new Image(file.toURI().toString());
        pict.setImage(image);
        elmt.setText(AvatarDuel.landData.get(AvatarDuel.a).getElement());
        name.setText(AvatarDuel.landData.get(AvatarDuel.a).getName());
        attrib.setText("Males masukin nanti aja ya");
        System.out.println(AvatarDuel.landData.get(AvatarDuel.a).getImagePath());
    }

}
