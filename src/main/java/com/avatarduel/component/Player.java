package com.avatarduel.component;
import java.util.*;

/**
 * Player represents the Player of the game
 * @see Deck
 * @see IHandCard
 * @see BoardCard
 * @see SkillCard
 */
public class Player{
    private String name;
    private int health;
    private Deck deck;
    private List<IHandCard> hand; 
    private List<BoardCard> board;
    private List<SkillCard> skillBoard;
    private int maxWater, currentWater, maxEarth, currentEarth, maxFire, currentFire, maxAir, currentAir, maxEnergy, currentEnergy;

    /**
     * Creates a new Player and initializes their hand, board, skillboard, and element powers
     * @param name Name of the player
     * @param health Health of the player
     */
    public Player(String name, int health)
    {
        this.name = name;
        this.health = health;
        this.deck = new Deck();
        this.hand = new ArrayList<IHandCard>();
        this.board = new ArrayList<BoardCard>();
        this.skillBoard = new ArrayList<SkillCard>();
        this.maxWater = 0; this.currentWater = 0;
        this.maxEarth = 0; this.currentEarth = 0;
        this.maxFire = 0; this.currentFire = 0;
        this.maxAir = 0; this.currentAir = 0;
        this.maxEnergy = 0; this.currentEnergy = 0;
        for (int i = 0; i < 6; i++){  // Inisialisasi board dengan null
            board.add(NullCardHandler.getNullBoardCard());
            skillBoard.add(NullCardHandler.getNullSkillCard());
        }
    }

    /**
     * Sets the name of the player
     * @param name new player name
     */
    public void setName(String name){this.name = name; }
    /**
     * Gets the name of the player
     * @return player name
     */
    public String getName() {return this.name;}

    /**
     * Sets the health of the player
     * @param health new player health
     */
    public void setHealth(int health){ this.health = health; }
    /**
     * Gets the current health of the player
     * @return current health
     */
    public int getHealth(){ return this.health; }

    /**
     * Sets the max element of the player
     * @param element element to be set
     * @param val new max value
     */
    public void setMaxElement(String element, int val ){
        switch(element){
            case ("FIRE"):
                this.maxFire = val;
                break;
            case ("WATER"):
                this.maxWater = val;
                break;
            case ("EARTH"):
                this.maxEarth = val;
                break;
            case ("AIR"):
                this.maxAir = val;
                break;
            case ("ENERGY"):
                this.maxEnergy = val;
                break;
            default:
                System.out.println("No Match");
		}
    }
    /**
     * Gets the max element of the designated element
     * @param element element to get
     * @return corresponding element's max value
     */
    public int getMaxElement(String element){
        switch(element){
            case ("FIRE"):
                return this.maxFire;
//                break;
            case ("WATER"):
                return this.maxWater;
//                break;
            case ("EARTH"):
                return this.maxEarth;
//                break;
            case ("AIR"):
                return this.maxAir;
//                break;
            case ("ENERGY"):
                return this.maxEnergy;
            default:
                System.out.println("No Match");
                return 0;
		}
	}

    /**
     * Sets current element power value
     * @param element element to set
     * @param val new current power value
     */
    public void setCurrentElement(String element, int val ){
        switch(element){
            case ("FIRE"):
                this.currentFire = val;
                break;
            case ("WATER"):
                this.currentWater = val;
                break;
            case ("EARTH"):
                this.currentEarth = val;
                break;
            case ("AIR"):
                this.currentAir = val;
                break;
            case ("ENERGY"):
                this.currentEnergy = val;
                break;
            default:
                System.out.println("No Match");
		}
    }
    /**
     * Gets current element power value
     * @param element element to get
     * @return corresponding current element power value
     */
    public int getCurrentElement(String element){
        switch(element){
            case ("FIRE"):
                return this.currentFire;
            case ("WATER"):
                return this.currentWater;
            case ("EARTH"):
                return this.currentEarth;
            case ("AIR"):
                return this.currentAir;
            case ("ENERGY"):
                return this.currentEnergy;
            default:
                System.out.println("No Match");
                return 0;
		}
	}

	/**
     * Returns the player's hand
     * @return List of IHandCard
     */
    public List<IHandCard> getHand() {return this.hand;}
    /**
     * Returns the player's hand card at a specific index
     * @param idx designated index
     * @return Card at index idx in hand
     */
    public IHandCard getHandAt(int idx) {return hand.get(idx);}

    /**
     * Returns the player's board
     * @return List of BoardCard
     */
    public List<BoardCard> getBoard(){ return board; }
    /**
     * Returns the player's card in board at a specific index
     * @param idx designated index
     * @return BoardCard in board index idx
     */
    public BoardCard getBoardCardAt(int idx){ return board.get(idx); }

    /**
     * Returns the player's skill board
     * @return List of SkillCard
     */
    public List<SkillCard> getSkillBoard(){ return skillBoard; }
    /**
     * Returns the player's card at a specific index in their skill board
     * @param idx targeted index
     * @return SkillCard in board index idx
     */
    public SkillCard getSkillBoardCardAt(int idx){return skillBoard.get(idx);}

    /**
     * Getter Deck
     * @return player's deck
     */
    public Deck getDeck(){
        return this.deck;
    }

    /**
     * Draws a card from the deck and adds it to the hand
     */
    public void draw(){
        //pop card dari deck
        if (deck.getDeck().size() == 0){
            return;
        }
        Card top = deck.getDeck().remove(0);
        HandCard factory = HandCardFactory.getFactory(top); // Gunakan factory method untuk menentukan factory yang akan digunakan
        // TODO, kasih exception kalo factory = null
        hand.add(factory.createHandCard(top, this)); // tambahkan IHandCard yang dibuat factory ke hand
    }
    /**
     * Changes all cards in hand from revealed to closed and vice versa
     */
    public void flipHand(){
        for (IHandCard card : hand){
            card.flip();
        }
    }

    /**
     * Removes a card in hand at index idx
     * @param idx index of card in hand to discard
     */
    public void removeHandCard(int idx){
        // membuang kartu skill yang ada di tangan
        hand.remove(idx);
    }

    /**
     * Removes a skill card in board at index idx and then removes it from list of skills
     * If no card in the player's board has said skill, search enemy's board instead
     * @param idx index of skill card in board to remove
     * @param enemy Enemy of currentPlayer
     */
    public void removeBoardSkill(int idx, Player enemy){
        //membuang kartu skill di board;
        SkillCard card = skillBoard.get(idx);
        boolean found = false;
        skillBoard.set(idx, NullCardHandler.getNullSkillCard());
        for (BoardCard chara : board){
            if (chara.getSkills().contains(card)){
                found = true;
                chara.removeSkill(card);
                break;
            }
        }
        if (!found){
            for (BoardCard echara : enemy.getBoard()){
                if (echara.getSkills().contains(card)){
                    echara.removeSkill(card);
                    break;
                }
            }   
        }
    }

    /**
     * Changes a card in board in index to idx to attack position from defense position and vice versa
     * @param idx index of card to rotate
     */
    public void rotate(int idx){
        board.get(idx).rotate();
    }

    /**
     * Resets user current power to their max value
     */
    public void reset(){
        this.currentWater = this.maxWater;
        this.currentEarth = this.maxEarth;
        this.currentFire = this.maxFire;
        this.currentAir = this.maxAir;
        this.currentEnergy = this.maxEnergy;
        for (BoardCard card: board) {
            card.setCanAttack(true);
        }
    }

    /**
     * Takes index of character card in hand to play and whether it is summoned in attack position or defense position.
     * Adds the card to the first empty slot in board
     * @param idx index of card in hand to summon
     * @param attack true if summon in attack position false otherwise
     */
    public void playCharacterCard(int idx, boolean attack){
    
        CharacterHandCard card = (CharacterHandCard) hand.get(idx);
        if (!HandCardPlayer.validatePlay(card)){
            System.out.println("You don't have enough power to summon " + card.getCardInstance().getName());
        }
        else{
            hand.remove(idx);
            HandCardPlayer.playCard(card, attack);
            System.out.println(getName() + " summons " + card.getCardInstance().getName());
        }
    }
    
    /**
     * Takes the index of skill card in hand and the target of the effect.
     * Puts the card into the skill board and apply effect to target
     * @param idx target of skill card in hand
     * @param target target of skill
     */
    public void playSkillCard(int idx, BoardCard target){

        SkillCard card = (SkillCard) hand.get(idx).getCardInstance();
        if (!HandCardPlayer.validatePlay(hand.get(idx))){
            System.out.println("You don't have enough power to play " + card.getName());
        }
        else {
            if (card.getEffect().equals(SkillCard.SKILL_AURA)){
                HandCardPlayer.playCard((AuraHandCard) hand.remove(idx), target);
            }
            else if (card.getEffect().equals(SkillCard.SKILL_POWERUP)){
                HandCardPlayer.playCard((PowerUpHandCard) hand.remove(idx), target);
            }
            else if (card.getEffect().equals(SkillCard.SKILL_DESTROY)){
                HandCardPlayer.playCard((DestroyHandCard) hand.remove(idx), target);
            }
            System.out.println(getName() + " plays " + card.getName());
        }
    }

    /**
     * Takes the index of land card in hand and plays it
     * @param idx index of land card in hand
     */
    public void playLandCard(int idx){
        LandHandCard card = (LandHandCard) hand.remove(idx);
        HandCardPlayer.playCard(card);
        System.out.println(getName() + " summons " + card.getCardInstance().getName());
    }

    /**
     * Takes the index of the attacking card in board, the enemy player, and the attacked card's index in board
     * Destroys the enemy card and deals damage to enemy if enemy card is in attack position or attacker has power up
     * @param idx index of attacking card in board
     * @param enemy enemy player
     * @param enemyidx index of attacked card in board
     */
    public void attack(int idx, Player enemy, int enemyidx){
        boolean isAttackPos = enemy.getBoardCardAt(enemyidx).getAttackPos();
        int attackingVal = getBoardCardAt(idx).getPositionValue();
        int attackedVal = enemy.getBoardCardAt(enemyidx).getPositionValue();
        if (isAttackPos || getBoardCardAt(idx).getPowerUp()) {
            int enemyHealth = enemy.getHealth() - attackingVal + attackedVal;
            if (enemyHealth < 0){
                enemyHealth = 0;
            }
            enemy.setHealth(enemyHealth);
        }
        getBoardCardAt(idx).setCanAttack(false);
        enemy.getBoardCardAt(enemyidx).destroy();
	}

    /**
     * Takes the index of attacking card in board and deals damage to enemy player directly
     * @param idx index of attacking card
     * @param enemy enemy player
     */
    public void attack(int idx, Player enemy){
        int attackingVal = board.get(idx).getPositionValue();
        int enemyHealth = enemy.getHealth() - attackingVal;
        if (enemyHealth < 0){
            enemyHealth = 0;
        } 
        enemy.setHealth(enemyHealth);
        getBoardCardAt(idx).setCanAttack(false);
    }
}
