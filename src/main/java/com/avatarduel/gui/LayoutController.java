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
    @FXML private TCardController P1H1Controller;
    @FXML private TCardController P1H2Controller;
    @FXML private TCardController P1H3Controller;
    @FXML private TCardController P1H4Controller;
    @FXML private TCardController P1H5Controller;
    @FXML private TCardController P1H6Controller;
    @FXML private TCardController P1H7Controller;
    @FXML private TCardController P1H8Controller;
    @FXML private TCardController P1H9Controller;

    @FXML private TCardController P1A1Controller;
    @FXML private TCardController P1A2Controller;
    @FXML private TCardController P1A3Controller;
    @FXML private TCardController P1A4Controller;
    @FXML private TCardController P1A5Controller;
    @FXML private TCardController P1A6Controller;
    @FXML private TCardController P1A7Controller;
    @FXML private TCardController P1A8Controller;

    @FXML private TCardController P1S1Controller;
    @FXML private TCardController P1S2Controller;
    @FXML private TCardController P1S3Controller;
    @FXML private TCardController P1S4Controller;
    @FXML private TCardController P1S5Controller;
    @FXML private TCardController P1S6Controller;
    @FXML private TCardController P1S7Controller;
    @FXML private TCardController P1S8Controller;

    @FXML private TCardController P2H1Controller;
    @FXML private TCardController P2H2Controller;
    @FXML private TCardController P2H3Controller;
    @FXML private TCardController P2H4Controller;
    @FXML private TCardController P2H5Controller;
    @FXML private TCardController P2H6Controller;
    @FXML private TCardController P2H7Controller;
    @FXML private TCardController P2H8Controller;
    @FXML private TCardController P2H9Controller;

    @FXML private TCardController P2A1Controller;
    @FXML private TCardController P2A2Controller;
    @FXML private TCardController P2A3Controller;
    @FXML private TCardController P2A4Controller;
    @FXML private TCardController P2A5Controller;
    @FXML private TCardController P2A6Controller;
    @FXML private TCardController P2A7Controller;
    @FXML private TCardController P2A8Controller;

    @FXML private TCardController P2S1Controller;
    @FXML private TCardController P2S2Controller;
    @FXML private TCardController P2S3Controller;
    @FXML private TCardController P2S4Controller;
    @FXML private TCardController P2S5Controller;
    @FXML private TCardController P2S6Controller;
    @FXML private TCardController P2S7Controller;
    @FXML private TCardController P2S8Controller;

    public LayoutController() {
    }

    public void button(MouseEvent mouseEvent) {
        P1H1Controller.loadCard(AvatarDuel.charData.get(1));
        Card.onP1H1 = AvatarDuel.charData.get(1);
        P1H2Controller.loadCard(AvatarDuel.charData.get(2));
        Card.onP1H2 = AvatarDuel.charData.get(2);
        P1H3Controller.loadCard(AvatarDuel.charData.get(3));
        Card.onP1H3 = AvatarDuel.charData.get(3);
        P1H4Controller.loadCard(AvatarDuel.charData.get(4));
        Card.onP1H4 = AvatarDuel.charData.get(4);
        P1H5Controller.loadCard(AvatarDuel.landData.get(5));
        Card.onP1H5 = AvatarDuel.landData.get(5);
        P1H6Controller.loadCard(AvatarDuel.landData.get(6));
        Card.onP1H6 = AvatarDuel.landData.get(6);
        P1H7Controller.loadCard(AvatarDuel.landData.get(7));
        Card.onP1H7 = AvatarDuel.landData.get(7);
        P1H8Controller.loadCard(AvatarDuel.charData.get(8));
        Card.onP1H8 = AvatarDuel.charData.get(8);
        P1H9Controller.loadCard(AvatarDuel.charData.get(9));
        Card.onP1H9 = AvatarDuel.charData.get(9);
        P2H1Controller.loadCard(AvatarDuel.charData.get(10));
        Card.onP2H1 = AvatarDuel.charData.get(10);
        P2H2Controller.loadCard(AvatarDuel.landData.get(11));
        Card.onP2H2 = AvatarDuel.landData.get(11);
    }

    //PLayer card
    public void hoverP1H1(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1H1;
        onHover();
    }
    public void hoverP1H2(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1H2;
        onHover();
    }
    public void hoverP1H3(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1H3;
        onHover();
    }
    public void hoverP1H4(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1H4;
        onHover();
    }
    public void hoverP1H5(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1H5;
        onHover();
    }
    public void hoverP1H6(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1H6;
        onHover();
    }
    public void hoverP1H7(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1H7;
        onHover();
    }
    public void hoverP1H8(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1H8;
        onHover();
    }
    public void hoverP1H9(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1H9;
        onHover();
    }
    //Arena card
    public void hoverP1A1(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1A1;
        onHover();
    }
    public void hoverP1A2(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1A2;
        onHover();
    }
    public void hoverP1A3(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1A3;
        onHover();
    }
    public void hoverP1A4(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1A4;
        onHover();
    }
    public void hoverP1A5(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1A5;
        onHover();
    }
    public void hoverP1A6(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1A6;
        onHover();
    }
    public void hoverP1A7(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1A7;
        onHover();
    }
    public void hoverP1A8(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1A8;
        onHover();
    }
    //Skill card
    public void hoverP1S1(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1S1;
        onHover();
    }
    public void hoverP1S2(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1S2;
        onHover();
    }
    public void hoverP1S3(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1S3;
        onHover();
    }
    public void hoverP1S4(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1S4;
        onHover();
    }
    public void hoverP1S5(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1S5;
        onHover();
    }
    public void hoverP1S6(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1S6;
        onHover();
    }

    public void hoverP1S7(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1S7;
        onHover();
    }
    public void hoverP1S8(MouseEvent mouseEvent){
        Card.cardHover = Card.onP1S8;
        onHover();
    }

    //Player 2
    //PLayer card
    public void hoverP2H1(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2H1;
        onHover();
    }
    public void hoverP2H2(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2H2;
        onHover();
    }
    public void hoverP2H3(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2H3;
        onHover();
    }
    public void hoverP2H4(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2H4;
        onHover();
    }
    public void hoverP2H5(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2H5;
        onHover();
    }
    public void hoverP2H6(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2H6;
        onHover();
    }
    public void hoverP2H7(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2H7;
        onHover();
    }
    public void hoverP2H8(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2H8;
        onHover();
    }
    public void hoverP2H9(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2H9;
        onHover();
    }
    //Arena card
    public void hoverP2A1(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2A1;
        onHover();
    }
    public void hoverP2A2(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2A2;
        onHover();
    }
    public void hoverP2A3(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2A3;
        onHover();
    }
    public void hoverP2A4(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2A4;
        onHover();
    }
    public void hoverP2A5(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2A5;
        onHover();
    }
    public void hoverP2A6(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2A6;
        onHover();
    }
    public void hoverP2A7(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2A7;
        onHover();
    }
    public void hoverP2A8(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2A8;
        onHover();
    }
    //Skill card
    public void hoverP2S1(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2S1;
        onHover();
    }
    public void hoverP2S2(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2S2;
        onHover();
    }
    public void hoverP2S3(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2S3;
        onHover();
    }
    public void hoverP2S4(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2S4;
        onHover();
    }
    public void hoverP2S5(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2S5;
        onHover();
    }
    public void hoverP2S6(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2S6;
        onHover();
    }
    public void hoverP2S7(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2S7;
        onHover();
    }
    public void hoverP2S8(MouseEvent mouseEvent){
        Card.cardHover = Card.onP2S8;
        onHover();
    }
    public void clickAction(MouseEvent mouseEvent) throws  IOException{
        onClick();
    }


    public void onHover(){
        File file = new File (Card.cardHover.getImagePath());
        Image image = new Image(file.toURI().toString());
        detailPict.setImage(image);
        detailText.setText(Card.cardHover.getDescription());
    }

    public void onClick() throws IOException {
        Stage stage = new Stage();
        Pane myPane = null;
        myPane = FXMLLoader.load(getClass().getClassLoader().getResource("actionBox.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }

//    public void actionBox(MouseEvent mouseEvent) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("actionBox.fxml"));
//        Parent root1 = (Parent) fxmlLoader.load();
//        Stage stage = new Stage();
//        stage.setScene(new Scene(root1));
//        stage.show();
//    }


    @FXML private ImageView detailPict;
    @FXML private Text detailText;
    @FXML private Text p1name;
    @FXML private Text p2name;
    @FXML private Text p1health;
    @FXML private Text p2health;
    @FXML private DeckController PanelP1Controller;
    @FXML private DeckController PanelP2Controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        p1name.setText(AvatarDuel.P1.getName());
        p2name.setText(AvatarDuel.P2.getName());
        p1health.setText("Health : " + Integer.toString(AvatarDuel.P1.getHealth()));
        p2health.setText("Health : " + Integer.toString(AvatarDuel.P2.getHealth()));
        PanelP1Controller.initialSet();
        PanelP2Controller.initialSet();
    }
}
