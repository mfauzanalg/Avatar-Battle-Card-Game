package com.avatarduel.gui;

import com.avatarduel.AvatarDuel;
import com.avatarduel.component.Card;
import com.avatarduel.component.HandCard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LayoutController implements Initializable{
    @FXML private HandCardController HandCard1Controller;
    @FXML private HandCardController HandCard2Controller;

    public void buttonClick(MouseEvent mouseEvent) {
        HandCard1Controller.loadCard(AvatarDuel.landData.get(3),1);
        HandCard2Controller.loadCard(AvatarDuel.landData.get(9), 3);
    }


//    public void onHover(){
//        File file = new File (Card.cardHover.getImagePath());
//        Image image = new Image(file.toURI().toString());
//        detailPict.setImage(image);
//        detailText.setText(Card.cardHover.getDescription());
//    }
//
//    public void onClick() throws IOException {
//        Stage stage = new Stage();
//        Pane myPane = null;
//        myPane = FXMLLoader.load(getClass().getClassLoader().getResource("actionBox.fxml"));
//        Scene scene = new Scene(myPane);
//        stage.setScene(scene);
//        stage.show();
//    }
//
////    public void actionBox(MouseEvent mouseEvent) throws IOException {
////        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("actionBox.fxml"));
////        Parent root1 = (Parent) fxmlLoader.load();
////        Stage stage = new Stage();
////        stage.setScene(new Scene(root1));
////        stage.show();
////    }
//
//
    @FXML private ImageView detailPict;
    @FXML private Text detailText;
    @FXML private DeckController PanelP1Controller;
    @FXML private DeckController PanelP2Controller;
    @FXML private PlayerInfoController PlayerInfo1Controller;
    @FXML private PlayerInfoController PlayerInfo2Controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PlayerInfo1Controller.setName(AvatarDuel.P1.getName());
        PlayerInfo2Controller.setName(AvatarDuel.P2.getName());
        PlayerInfo1Controller.setHealth(Integer.toString(AvatarDuel.P1.getHealth()));
        PlayerInfo2Controller.setHealth(Integer.toString(AvatarDuel.P1.getHealth()));
        PanelP1Controller.initialSet();
        PanelP2Controller.initialSet();
    }
}
