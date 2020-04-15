package com.avatarduel.gui;

import com.avatarduel.component.Card;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HandCardController {
    @FXML private TCardController h1Controller;
    @FXML private TCardController h2Controller;
    @FXML private TCardController h3Controller;
    @FXML private TCardController h4Controller;
    @FXML private TCardController h5Controller;
    @FXML private TCardController h6Controller;
    @FXML private TCardController h7Controller;
    @FXML private TCardController h8Controller;
    @FXML private TCardController h9Controller;

    public void loadCard(Card card, int x){
        switch (x){
            case 1: h1Controller.loadCard(card); break;
            case 2: h2Controller.loadCard(card); break;
            case 3: h3Controller.loadCard(card); break;
            case 4: h4Controller.loadCard(card); break;
            case 5: h5Controller.loadCard(card); break;
            case 6: h6Controller.loadCard(card); break;
            case 7: h7Controller.loadCard(card); break;
            case 8: h8Controller.loadCard(card); break;
            case 9: h9Controller.loadCard(card); break;
            default:
        }
    }

    public void handAction(){
        try{
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HandAction.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("ActionBox");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e){
            throw new IllegalStateException("Fauzan Keren" + e);
        }
    }

}
