package com.avatarduel.gui;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Window;


public class cobayukController {

    @FXML private Button btn;
    @FXML private Text teks;
    @FXML private landCardController secondController;


    public void buttonClikced(MouseEvent mouseEvent) {
        System.out.println("Ya Allah bantu Hamba");
        btn.setText("Nangis");
        secondController.setMiaw();
    }

    public void textClicked(MouseEvent mouseEvent) {
        System.out.println("Ya Allah bantu Hamba");
        teks.setText("cape bgt");
    }
}
