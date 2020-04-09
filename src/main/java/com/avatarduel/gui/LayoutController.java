package com.avatarduel.gui;

import com.avatarduel.AvatarDuel;
import com.avatarduel.component.Card;
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

    public void button(MouseEvent mouseEvent) {
//        P1H1Controller.loadCard(AvatarDuel.charData.get(1));
//        Card.onP1H1 = AvatarDuel.charData.get(1);
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
//    @FXML private ImageView detailPict;
//    @FXML private Text detailText;
//    @FXML private Text p1name;
//    @FXML private Text p2name;
//    @FXML private Text p1health;
//    @FXML private Text p2health;
//    @FXML private DeckController PanelP1Controller;
//    @FXML private DeckController PanelP2Controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        p1name.setText(AvatarDuel.P1.getName());
//        p2name.setText(AvatarDuel.P2.getName());
//        p1health.setText("Health : " + Integer.toString(AvatarDuel.P1.getHealth()));
//        p2health.setText("Health : " + Integer.toString(AvatarDuel.P2.getHealth()));
//        PanelP1Controller.initialSet();
//        PanelP2Controller.initialSet();
    }
}
