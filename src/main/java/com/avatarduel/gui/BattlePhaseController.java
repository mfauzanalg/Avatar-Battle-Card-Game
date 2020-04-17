package com.avatarduel.gui;

import com.avatarduel.AvatarDuel;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class BattlePhaseController {
    @FXML private AnchorPane drawP;
    @FXML private AnchorPane mainP;
    @FXML private AnchorPane battleP;
    @FXML private AnchorPane endP;

    public AnchorPane getDrawP(){
        return this.drawP;
    }
    public AnchorPane getMainP(){
        return this.mainP;
    }
    public AnchorPane getBattleP(){
        return this.battleP;
    }
    public AnchorPane getEndP(){
        return this.endP;
    }

    public void setColor(AnchorPane P, String player){
        String P1 = AvatarDuel.P1.getName();
        String P2 = AvatarDuel.P2.getName();
        if (player.equals(P1)) P.setStyle("-fx-background-color: #c2dbed; -fx-border-width: 1; -fx-border-color: black");
        else  P.setStyle("-fx-background-color: #ed8c8c; -fx-border-width: 1; -fx-border-color: black");
    }

    public void resetColor(AnchorPane P){
        P.setStyle("#c2dbed; -fx-border-width: 1; -fx-border-color: black");
    }
}
