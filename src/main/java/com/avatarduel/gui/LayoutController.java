package com.avatarduel.gui;

import com.avatarduel.AvatarDuel;
import com.avatarduel.component.Card;
import com.avatarduel.component.IHandCard;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class LayoutController implements Initializable{
    @FXML private Text detailText;
    @FXML private Text detailName;
    @FXML private ImageView detailPict;
    @FXML private DeckController panelP1Controller;
    @FXML private DeckController panelP2Controller;
    @FXML private HandCardController handCard1Controller;
    @FXML private HandCardController handCard2Controller;
    @FXML private DetailInfoController detailInfoController;
    @FXML private PlayerInfoController playerInfo1Controller;
    @FXML private PlayerInfoController playerInfo2Controller;

    public void draw(MouseEvent mouseEvent) {
        AvatarDuel.P1.draw();
        onHover();
    }

    public void updateHand() {
        int index = 1;
        for (IHandCard card : AvatarDuel.P1.getHand()) {
            handCard1Controller.loadCard(card.getCardInstance(),index++);
        }
    }

    public void onHover(){
        detailInfoController.showCard(Card.cardHover);
        updateHand();
    }

//    public void onClick() throws IOException {
//        Stage stage = new Stage();
//        Pane myPane = null;
//        myPane = FXMLLoader.load(getClass().getClassLoader().getResource("actionBox.fxml"));
//        Scene scene = new Scene(myPane);
//        stage.setScene(scene);
//        stage.show();
//    }

//    public void actionBox(MouseEvent mouseEvent) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("actionBox.fxml"));
//        Parent root1 = (Parent) fxmlLoader.load();
//        Stage stage = new Stage();
//        stage.setScene(new Scene(root1));
//        stage.show();
//    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playerInfo1Controller.setName(AvatarDuel.P1.getName());
        playerInfo2Controller.setName(AvatarDuel.P2.getName());
        playerInfo1Controller.setHealth(Integer.toString(AvatarDuel.P1.getHealth()));
        playerInfo2Controller.setHealth(Integer.toString(AvatarDuel.P1.getHealth()));
        panelP1Controller.initialSet();
        panelP2Controller.initialSet();
    }


}
