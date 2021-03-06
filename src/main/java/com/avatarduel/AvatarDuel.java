package com.avatarduel;

import com.avatarduel.component.AuraSkillCard;
import com.avatarduel.component.CharacterCard;
import com.avatarduel.component.LandCard;
import com.avatarduel.component.Player;

import com.avatarduel.component.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import com.avatarduel.util.CSVReader;

public class AvatarDuel extends Application {
  private static final String LAND_CSV_FILE_PATH = "card/data/land.csv";
  private static final String AURA_CSV_FILE_PATH = "card/data/skill_aura.csv";
  private static final String CHAR_CSV_FILE_PATH = "card/data/character.csv";
  public static HashMap<Integer, Card> dataBase;
  public static List<LandCard> landData;
  public static List<CharacterCard> charData;
  public static List<AuraSkillCard> auraData;
  public static DestroySkillCard destroyCard;
  public static PowerUpSkillCard powerUpCard;
  public static Player P1;
  public static Player P2;


  public <T extends Card> void addDataBase(HashMap<Integer, Card> dataBase, List<T> cardList){
    for (T card: cardList) {
      dataBase.put(card.getId(), card);
    }
  }

  public void initializeDataBase(){
    dataBase = new HashMap<Integer, Card>();
    addDataBase(dataBase, landData);
    addDataBase(dataBase, auraData);
    addDataBase(dataBase, charData);
    dataBase.put(destroyCard.getId(), destroyCard);
    dataBase.put(powerUpCard.getId(), powerUpCard);
    dataBase.put(0, new Card("", 0, "", "", "", "src/main/resources/com/avatarduel/card/image/blank.png"));
  }

  public void loadDestroyCard(){
    destroyCard = new DestroySkillCard(99, "Destroy Card", "WATER", "This is Destroy skill card", "src/main/resources/com/avatarduel/card/image/skill/Destroy.png", 2);
  }

  public void loadPowerUpCard(){
    powerUpCard = new PowerUpSkillCard(100, "Power Up Card", "EARTH", "This is Power Up Skill card", "src/main/resources/com/avatarduel/card/image/skill/PowerUp.png", 2);
  }

  public void loadLandCards() throws IOException, URISyntaxException {
    File landCSVFile = new File(getClass().getResource(LAND_CSV_FILE_PATH).toURI());
    CSVReader landReader = new CSVReader(landCSVFile, "\t");
    landReader.setSkipHeader(true);
    List<String[]> landRows = landReader.read();
    landData = new ArrayList<LandCard>();
    for (String[] row : landRows) {
      //landCard constructor
      LandCard lc = new LandCard(Integer.parseInt(row[0]), row[1], row[2], row[3], row[4]);
      landData.add(lc);
    }
  }

  public void loadCharCards() throws  IOException, URISyntaxException{
    File charCSVFile = new File(getClass().getResource(CHAR_CSV_FILE_PATH).toURI());
    CSVReader charReader = new CSVReader(charCSVFile, "\t");
    charReader.setSkipHeader(true);
    List<String[]> charRows = charReader.read();
    charData = new ArrayList<CharacterCard>();
    for (String[] row : charRows) {
      //charCard constructor
      CharacterCard cc = new CharacterCard(Integer.parseInt(row[0]), row[1], row[2], row[3], row[4], Integer.parseInt(row[5]), Integer.parseInt(row[6]), Integer.parseInt(row[7]));
      charData.add(cc);
    }
  }

  public void loadAuraCards() throws IOException, URISyntaxException{
    File auraCSVFile = new File(getClass().getResource(AURA_CSV_FILE_PATH).toURI());
    CSVReader auraReader = new CSVReader(auraCSVFile, "\t");
    auraReader.setSkipHeader(true);
    List<String[]> auraRows = auraReader.read();
    auraData = new ArrayList<AuraSkillCard>();
    for (String[] row : auraRows) {
      //auraCard constructor
      AuraSkillCard ac = new AuraSkillCard(Integer.parseInt(row[0]), row[1], row[2], row[3], row[4], Integer.parseInt(row[6]), Integer.parseInt(row[7]), Integer.parseInt(row[5]));
      auraData.add(ac);
    }
  }

  @Override
  public void start(Stage stage) throws IOException {

    try{
      this.loadLandCards();
      this.loadAuraCards();
      this.loadCharCards();
      this.loadDestroyCard();
      this.loadPowerUpCard();
      this.initializeDataBase();

      Image image = new Image("/img/icon.png");

      Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Window.fxml"));
      Scene scene = new Scene(root);
      stage.setTitle("Avatar Duel Kelompok 9");
      stage.getIcons().add(image);
      stage.setScene(scene);
      stage.show();
    } catch (IOException | URISyntaxException e){
      throw new IllegalStateException("Fauzan Keren" + e);
    }

  }


  public static void main(String[] args) {
    launch();
  }
}