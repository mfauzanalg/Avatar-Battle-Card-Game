package com.avatarduel.customcontrol;

import com.avatarduel.gui.tCardController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class landCardCC extends AnchorPane {
    tCardController controller;

    public landCardCC() throws IOException {
        super();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TCard.fxml"));
            controller = new tCardController();
            loader.setController(controller);
            Node n = loader.load();

            this.getChildren().add(n);
        }
        catch (IOException e){}



    }
}
