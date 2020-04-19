// File : Phase.java
// Mengatur jalannya permainan

package com.avatarduel.component;

import java.util.Random;
import java.util.List;

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

    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }

    public String getCurrentPhase(){
        return this.currentPhase;
    }

    public Phase(Player one, Player two){
        player_one = one;
        player_two = two;
    }

    public void initialize(){
        currentPhase = DRAW_PHASE;
        for (int i = 0; i < 7; i++){
            player_one.draw();
            player_two.draw();
        }
        currentPlayer = player_two;
        drawPhase();
    }

    public Player getNextPlayer(){
        return (currentPlayer == player_one) ? player_two : player_one;
    }

    public void nextPhase(){
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

    public void drawPhase(){
        currentPlayer = getNextPlayer();
        currentPhase = DRAW_PHASE;
        System.out.println(currentPlayer.getName() + "'s Turn");
        System.out.println("Draw Phase");
        System.out.println(currentPlayer.getName() + " draws a card");
        currentPlayer.draw();
    }

    public void mainPhase(){
        System.out.println("Main Phase");
        currentPhase = MAIN_PHASE;
    }

    public void battlePhase(){
        System.out.println("Battle Phase");
        currentPhase = BATTLE_PHASE;
    }

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

    public void endPhase(){
        System.out.println("End Phase");
        currentPhase = END_PHASE;
        if (currentPlayer.getHand().size() >= 9){
            discardHand();
        }
        currentPlayer.flipHand();
        currentPlayer.reset();
        currentPlayer = getNextPlayer();
    }

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

    // Menerima index skill card di tangan dan index target skill
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

            System.out.println(target);

            currentPlayer.playSkillCard(cidx, target);
        }
    }

    public void playLandCard(int idx){
        if (currentPhase != MAIN_PHASE){
            System.out.println("You can only play cards during the Main Phase");
            // Throw error here?
        }
        else {
            currentPlayer.playLandCard(idx);
        }
    }

    public void changeCardPosition(int idx){
        if (currentPhase != MAIN_PHASE){
            System.out.println("You can only change card position during the Main Phase");
            // Throw error here?
        }
        else {
            currentPlayer.rotate(idx);
        }
    }

    public void attackCharacter(int cidx, int tidx){
        if (currentPhase != BATTLE_PHASE){
            System.out.println("You can only attack during the Battle Phase");
            // Throw error here?
        }
        else {
            currentPlayer.attack(cidx, getNextPlayer(), tidx);
            if (isWinner()){
                currentPhase = MATCH_END;
                System.out.println(currentPlayer.getName() + " won!");
            }
        }
    }

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
            }
        }       
    }

    public void discardHand(){
        Random rand = new Random();
        int idx = rand.nextInt(9);
        currentPlayer.removeHandCard(idx);
    }

    // Ketika player ingin membuang skill yang ada di board
    // Menerima index letak kartu tersebut lalu di remove
    public void removeBoardSkill(int idx){
        currentPlayer.removeBoardSkill(idx);
    }

    public boolean isWinner(){
        return getNextPlayer().getHealth() <= 0;
    }
}