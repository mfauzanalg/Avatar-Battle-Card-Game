// File : Phase.java
// Mengatur jalannya permainan

package com.avatarduel.component;

public class Phase {
    public static final String DRAW_PHASE = "draw";
    public static final String MAIN_PHASE = "main";
    public static final String BATTLE_PHASE = "battle";
    public static final String END_PHASE = "end";
    private Player player_one;
    private Player player_two;
    private Player currentPlayer;
    private String currentPhase;

    public Phase(Player one, Player two){
        player_one = one;
        player_two = two;
    }

    public void initialize(){
        for (int i = 0; i < 7; i++){
            player_one.draw();
            player_two.draw();
        }
        currentPlayer = player_one;
        drawPhase();
    }

    public Player getNextPlayer(){
        return (currentPlayer == player_one) ? player_two : player_one;
    }

    public void nextPhase(){
        switch(currentPhase){
            case DRAW_PHASE :
                System.out.println("Main Phase");
                currentPhase = MAIN_PHASE;
                break;
            
            case MAIN_PHASE :
                System.out.println("Battle Phase");
                currentPhase = BATTLE_PHASE;
                break;
            
            case BATTLE_PHASE :
                currentPhase = END_PHASE;
                endPhase();
                break;
            
            case END_PHASE :
                currentPhase = DRAW_PHASE;
                drawPhase();
                break;
            
            default :
        }
    }

    public void drawPhase(){
        System.out.println(currentPlayer.getName() + "'s Turn");
        System.out.println("Draw Phase");
        System.out.println(currentPlayer.getName() + " draws a card");
        currentPlayer.draw();
        nextPhase();
    }

    public void endPhase(){
        currentPlayer.flipHand();
        currentPlayer.reset();
        currentPlayer = getNextPlayer();
        nextPhase();
    }

    public void summonCharacter(int idx, boolean isAttackPosition){
        
        if (currentPhase != MAIN_PHASE){
            System.out.println("You can only play cards during the Main Phase");
            // Throw error here?
        }
        else if (currentPlayer.getBoard().size() == 6){
            System.out.println("Your character board is full!");
            // Throw error here?
        }
        else {
            currentPlayer.playCharacterCard(idx, isAttackPosition);
        }
    }

    // Menerima index skill card di tangan dan index target skill
    public void playSkillCard(int cidx, int tidx){
        if (currentPhase != MAIN_PHASE){
            System.out.println("You can only play cards during the Main Phase");
            // Throw error here?
        }
        else if (currentPlayer.getSkillBoard().size() == 6){
            System.out.println("Your skill board is full!");
            // Throw error here?
        }
        else {

            SkillCard card = (SkillCard) currentPlayer.getHandAt(cidx).getCardInstance();
            BoardCard target;
            if (card.getEffect().equals(SkillCard.SKILL_DESTROY)){
                target = getNextPlayer().getBoardCardAt(tidx);
            }
            else {
                target = currentPlayer.getBoardCardAt(tidx);
            }

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

    public void attackCharacter(int cidx, int tidx){
        if (currentPhase != BATTLE_PHASE){
            System.out.println("You can only attack during the Battle Phase");
            // Throw error here?
        }
        else {

            currentPlayer.attack(cidx, getNextPlayer(), tidx);
        }
    }
}