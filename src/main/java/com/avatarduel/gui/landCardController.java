package com.avatarduel.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


public class landCardController {
    @FXML private Text name;

    public void setMiaw(){
        System.out.println("ha");
//        name.setText("miaw");
    }

    public void changeName(MouseEvent mouseEvent) {
        this.setMiaw();
    }
}
