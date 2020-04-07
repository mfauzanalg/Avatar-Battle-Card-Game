package com.avatarduel;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

import com.avatarduel.component.AuraSkillCard;
import com.avatarduel.component.CharacterCard;
import com.avatarduel.component.LandCard;
import com.avatarduel.component.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.avatarduel.model.Element;
import com.avatarduel.model.Land;
import com.avatarduel.util.CSVReader;

public class AvatarDuel extends Application {
  private static final String LAND_CSV_FILE_PATH = "card/data/land.csv";
  private static final String AURA_CSV_FILE_PATH = "card/data/skill_aura.csv";
  private static final String CHAR_CSV_FILE_PATH = "card/data/character.csv";

  public void loadLandCards() throws IOException, URISyntaxException {
    File landCSVFile = new File(getClass().getResource(LAND_CSV_FILE_PATH).toURI());
    CSVReader landReader = new CSVReader(landCSVFile, "\t");
    landReader.setSkipHeader(true);
    List<String[]> landRows = landReader.read();
    for (String[] row : landRows) {
      //landCard constructor
      //Land l = new Land(row[1], row[3], Element.valueOf(row[2]));
      LandCard lc = new LandCard(Integer.parseInt(row[0]), row[1], row[2], row[3], row[4]);
    }
  }

  public void loadCharCards() throws  IOException, URISyntaxException{
    File charCSVFile = new File(getClass().getResource(CHAR_CSV_FILE_PATH).toURI());
    CSVReader charReader = new CSVReader(charCSVFile, "\t");
    charReader.setSkipHeader(true);
    List<String[]> charRows = charReader.read();
    for (String[] row : charRows) {
      //charCard constructor
      CharacterCard cc = new CharacterCard(Integer.parseInt(row[0]), row[1], row[2], row[3], row[4], Integer.parseInt(row[5]), Integer.parseInt(row[6]), Integer.parseInt(row[7]));
    }
  }

  public void loadAuraCards() throws IOException, URISyntaxException{
    File auraCSVFile = new File(getClass().getResource(AURA_CSV_FILE_PATH).toURI());
    CSVReader auraReader = new CSVReader(auraCSVFile, "\t");
    auraReader.setSkipHeader(true);
    List<String[]> auraRows = auraReader.read();
    for (String[] row : auraRows) {
      //auraCard constructor
      AuraSkillCard ac = new AuraSkillCard(Integer.parseInt(row[0]), row[1], row[2], row[3], row[4], Integer.parseInt(row[6]), Integer.parseInt(row[7]), Integer.parseInt(row[5]));
    }
  }


  @Override
  public void start(Stage stage) throws IOException {

    try{
      this.loadLandCards();
      this.loadAuraCards();
      this.loadCharCards();
      Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("window.fxml"));
      Scene scene = new Scene(root);
      stage.setTitle("Avatar Duel Kelompok 9");
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