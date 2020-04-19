
package com.avatarduel.component;

import com.avatarduel.gui.LayoutController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;
import java.util.List;

/**
 * Phase is the bridge between the front end and the back end for gameplay
 */

public class Phase {
    public static final String DRAW_PHASE = "draw";
    public static final String MAIN_PHASE = "main";
    public static final String BATTLE_PHASE = "battle";
    public static final String END_PHASE = "end";
    public static final String MATCH_END = "shadow realm";
    private Player player_one;
    private Player player_two;
    private Player currentPlayer;
    private String currentPhase;
    private boolean useLand; //udah pake land card ato belom

    /**
     * Sets whether current player has played a land card this turn or not
     * @param useLand true or false
     */
    public void setUseLand(boolean useLand){ this.useLand = useLand;}

    /**
     * Gets whether the current player has played a land card this turn or not
     * @return true if has played, false otherwise
     */
    public boolean getUseLand(){return this.useLand;}

    /**
     * Returns the player who is currently having their turn
     * @return player currently having their turn
     */
    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }

    /**
     * Returns the current phase
     * @return Phase.DRAW_PHASE, Phase.MAIN_PHASE, Phase.BATTLE_PHASE, Phase.END_PHASE, or Phase.MATCH_END
     */
    public String getCurrentPhase(){
        return this.currentPhase;
    }

    /**
     * Creates a new Phase with Player one and Player two as players
     * @param one Player #1
     * @param two Player #2
     */
    public Phase(Player one, Player two){
        player_one = one;
        player_two = two;
    }

    /**
     * Initializes the game.
     * Sets current phase to draw phase and each player draws 7 cards from the top of their deck
     */
    public void initialize() throws IOException {
        currentPhase = DRAW_PHASE;
        for (int i = 0; i < 7; i++){
            player_one.draw();
            player_two.draw();
        }
        currentPlayer = player_two;
        drawPhase();
    }

    /**
     * Returns the player who is currently awaiting their turn
     * @return Player waiting for turn
     */
    public Player getNextPlayer(){
        return (currentPlayer == player_one) ? player_two : player_one;
    }

    /**
     * Moves to the next phase.
     * The phase order is Draw Phase, Main Phase, Battle Phase, End Phase, Repeat
     */
    public void nextPhase() throws IOException {
        switch(currentPhase){
            case DRAW_PHASE :
                mainPhase();
                break;
            case MAIN_PHASE :
                battlePhase();
                break;
            case BATTLE_PHASE :
                endPhase();
                break;
            case END_PHASE :
                drawPhase();
                break;
        }
    }

    /**
     * load new Scene in new Window
     * @param fxml target fxml
     */
    public void loadScene (String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(fxml));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Resets useLand and sets the current player to the next player.
     * And then said player draws a card from their deck
     */
    public void drawPhase() throws IOException {
        setUseLand(false);
        currentPlayer = getNextPlayer();
        currentPhase = DRAW_PHASE;

        if (getCurrentPlayer().getDeck().getDeck().size() == 0){
            currentPhase = MATCH_END;
            System.out.println(getNextPlayer().getName() + "won");
            LayoutController.finishGame = true;
            LayoutController.winner = getNextPlayer();
            loadScene("DrawInfo.fxml");
        }else{
            System.out.println(currentPlayer.getName() + "'s Turn");
            System.out.println("Draw Phase");
            System.out.println(currentPlayer.getName() + " draws a card");
            currentPlayer.draw();
        }
    }

    /**
     * Sets current phase to main phase
     */
    public void mainPhase(){
        System.out.println("Main Phase");
        currentPhase = MAIN_PHASE;
    }

    /**
     * Sets current phase to battle phase
     */
    public void battlePhase(){
        LayoutController.directAtk = false;
        System.out.println("Battle Phase");
        if (enemyBoardIsEmpty()){
            LayoutController.directAtk = true;
            System.out.println("masuk trueeee");
        }
        currentPhase = BATTLE_PHASE;
    }

    /**
     * Checks whether the enemy board is empty or not
     * @return true if is empty, false otherwise
     */
    public boolean enemyBoardIsEmpty(){
        boolean retval = true;
        for (BoardCard card : getNextPlayer().getBoard()){
            if (card != NullCardHandler.getNullBoardCard()){
                retval = false;
                break;
            }
        }

        return retval;
    }

    /**
     * Set's current phase to end phase. Randomly discards card until player has 8 cards if player has 9 or more cards
     */
    public void endPhase(){
        System.out.println("End Phase");
        currentPhase = END_PHASE;
        if (currentPlayer.getHand().size() >= 9){
            while (currentPlayer.getHand().size() > 8){
                
                discardHand();
            }
        }
        currentPlayer.flipHand();
        currentPlayer.reset();
    }

    /**
     * Summons a character card who's in index idx in player's hand to the board
     * @param idx idx of card in hand
     * @param isAttackPosition true if summons in attack position, false otherwise
     */
    public void summonCharacter(int idx, boolean isAttackPosition){
        if (currentPhase != MAIN_PHASE){
            System.out.println("You can only play cards during the Main Phase");
            // Throw error here?
        }
        if (currentPlayer.getBoard().indexOf(NullCardHandler.getNullBoardCard()) == -1){ // Jika board penuh
            System.out.println("Your character board is full!");
            // ...Throw exception? 
        }
        else {
            currentPlayer.playCharacterCard(idx, isAttackPosition);
        }
    }

    /**
     * Takes the index of the skill card in hand, the index of the target in board, and boolean targetsEnemyCard and plays it
     * @param cidx index of skill card in hand
     * @param tidx index of target BoardCard in board
     * @param targetsEnemyCard true if the target is the enemy's card, false otherwise
     */
    public void playSkillCard(int cidx, int tidx, boolean targetsEnemyCard){
        if (currentPhase != MAIN_PHASE){
            System.out.println("You can only play cards during the Main Phase");
            // Throw error here?
        }
        if (currentPlayer.getSkillBoard().indexOf(NullCardHandler.getNullSkillCard()) == -1){ // Jika skillboard penuh
            System.out.println("Your skill board is full!");
            // ...
        }
        else {
            SkillCard card = (SkillCard) currentPlayer.getHandAt(cidx).getCardInstance();
            BoardCard target;
            if (card.getEffect().equals(SkillCard.SKILL_DESTROY) || targetsEnemyCard){
                target = getNextPlayer().getBoardCardAt(tidx);
            }
            else {
                target = currentPlayer.getBoardCardAt(tidx);
            }
            currentPlayer.playSkillCard(cidx, target);
        }
    }

    /**
     * Takes the index of the land card in hand and plays it
     * @param idx index of land card in hand
     */
    public void playLandCard(int idx){
        if (currentPhase != MAIN_PHASE){
            System.out.println("You can only play cards during the Main Phase");
            // Throw error here?
        }
        else {
            currentPlayer.playLandCard(idx);
            setUseLand(true);
        }
    }

    /**
     * Takes the index of the card in board and changes it's position from attack to defense and vice versa
     * @param idx idx of the card whose position is about to be changed
     */
    public void changeCardPosition(int idx){
        if (currentPhase != MAIN_PHASE){
            System.out.println("You can only change card position during the Main Phase");
            // Throw error here?
        }
        else {
            currentPlayer.rotate(idx);
        }
    }

    /**
     * Takes the index of the attacking card, and the index of the attacked card. And makes the attacking card attack the enemy card
     * @param cidx index of attacking card
     * @param tidx index of attacked card
     */
    public void attackCharacter(int cidx, int tidx){
        if (currentPhase != BATTLE_PHASE){
            System.out.println("You can only attack during the Battle Phase");
            // Throw error here?
        }
        else if (currentPlayer.getBoardCardAt(cidx).getPositionValue() <= getNextPlayer().getBoardCardAt(tidx).getPositionValue()){
            System.out.println("You can only attack enemies with lower stats than your character's");
        }
        else if (getNextPlayer().getBoardCardAt(tidx) == NullCardHandler.getNullBoardCard()){
            System.out.println("Please select a target");
        }
        else {
            currentPlayer.attack(cidx, getNextPlayer(), tidx);
            if (isWinner()){
                currentPhase = MATCH_END;
                System.out.println(currentPlayer.getName() + " won!");
                LayoutController.finishGame = true;
                LayoutController.winner = currentPlayer;
            }
        }
    }

    /**
     * Takes the index of the attacking card and use said card to attack enemy directly
     * @param cidx index of attacking card
     */
    public void attackPlayer(int cidx){
        if (currentPhase != BATTLE_PHASE){
            System.out.println("You can only attack during the Battle Phase");
            // Throw error here?
        }
        else {
            currentPlayer.attack(cidx, getNextPlayer());
            if (isWinner()){
                currentPhase = MATCH_END;
                System.out.println(currentPlayer.getName() + " won!");
                LayoutController.finishGame = true;
                LayoutController.winner = currentPlayer;
            }
        }       
    }

    /**
     * Randomly discards card from player's hand
     */
    public void discardHand(){
        Random rand = new Random();
        int idx = rand.nextInt(currentPlayer.getHand().size());
        currentPlayer.removeHandCard(idx);
    }

    /**
     * Takes the index of skill card in board and removes the skill card
     * @param idx skill card index
     */
    public void removeBoardSkill(int idx){
        currentPlayer.removeBoardSkill(idx);
    }

    /**
     * Checks whether a winner has been found
     * @return true if enemyplayer's deck is 0 or if enemy health is 0
     */
    public boolean isWinner(){
        return (getNextPlayer().getHealth() <= 0);
    }
}