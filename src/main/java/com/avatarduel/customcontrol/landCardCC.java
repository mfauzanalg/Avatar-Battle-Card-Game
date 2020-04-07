package com.avatarduel.customcontrol;

import com.avatarduel.gui.landCardController;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;

import java.io.IOException;


public class landCardCC extends AnchorPane {
    landCardController controller;

    public landCardCC() throws IOException {
        super();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LandCard.fxml"));
            controller = new landCardController();
            loader.setController(controller);
            Node n = loader.load();

            this.getChildren().add(n);
        }
        catch (IOException e){}



    }
}
