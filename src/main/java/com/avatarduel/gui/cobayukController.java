package com.avatarduel.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


public class cobayukController {

    @FXML private Button btn;
    @FXML private Text teks;
    @FXML private TCardController secondController;
    @FXML private TCardController firstController;


    public void buttonClikced(MouseEvent mouseEvent) {
        System.out.println("Ya Allah bantu Hamba");
        btn.setText("Nangis");
//        secondController.loadCard();
//        firstController.loadCard();
    }

    public void textClicked(MouseEvent mouseEvent) {
        System.out.println("Ya Allah bantu Hamba");
        teks.setText("cape bgt");
    }
}
