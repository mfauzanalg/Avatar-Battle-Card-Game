package com.avatarduel.component;
import java.util.*;

public class Player{
    private String name;
    private int health;
    private Deck deck;
    private List<IHandCard> hand; //Ini harus IHandCard karna method play adanya di IHandCard
    private List<BoardCard> board; // Ini juga harus BoardCard biar bisa pake dekorator
    private List<SkillCard> skillBoard; // Kalo perlu Cardnya, pake method getCardInstance() ya
    private int maxWater, currentWater, maxEarth, currentEarth, maxFire, currentFire, maxAir, currentAir, maxEnergy, currentEnergy;

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

    /**Setter Getter name*/
    public void setName(String name){this.name = name; }
    public String getName() {return this.name;}

    /**Setter Getter health*/
    public void setHealth(int health){ this.health = health; }
    public int getHealth(){ return this.health; }

    /**Setter Getter max element*/
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

    /**Setter Getter current element*/
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
    public int getCurrentElement(String element){
        switch(element){
            case ("FIRE"):
                return this.currentFire;
//                break;
            case ("WATER"):
                return this.currentWater;
//                break;
            case ("EARTH"):
                return this.currentEarth;
//                break;
            case ("AIR"):
                return this.currentAir;
//                break;
            case ("ENERGY"):
                return this.currentEnergy;
            default:
                System.out.println("No Match");
                return 0;
		}
	}

	/**Getter hand*/
    public List<IHandCard> getHand() {return this.hand;}
    public IHandCard getHandAt(int idx) {return hand.get(idx);}

    /**Board getter*/
    public List<BoardCard> getBoard(){ return board; }
    public BoardCard getBoardCardAt(int idx){ return board.get(idx); }

    /**Skill Board getter*/
    public List<SkillCard> getSkillBoard(){ return skillBoard; }
    public SkillCard getSkillBoardCardAt(int idx){return skillBoard.get(idx);}

    /**Getter Dexk*/
    public Deck getDeck(){
        return this.deck;
    }

//    /**Deck Manipulation*/
//    public Stack<Card> getDeck(){
//        return this.deck;
//    }
//    public <T extends Card> void addCardsToDeck(List<T> l){
//        this.deck.addAll(l);
//	}
//    public void shuffleDeck(){
//        Collections.shuffle(this.deck);
//	}
//    public <T extends Card> void addCard(T c){
//        this.deck.push(c);
//	}
//    public <T extends Card> void addSpecificCard(List<T> l, int id){
//        T c = l.stream()
//            .filter(i -> i.getId() == id)
//            .findAny()
//            .orElse(null);
//        if (c != null){
//            this.addCard(c);
//		}
//	}
//    public <T extends Card> void addRandomCards(List<T> l, int quantity){
//        List<T> l1 = l;
//        int count = 0;
//        while (count != quantity){
//            Collections.shuffle(l1);
//            Card c = l1.get(0);
//            this.addCard(c);
//            count++;
//		}
//    }

    /**Hand manipulation*/
    public void draw(){
        //pop card dari deck
        Card top = deck.getDeck().remove(0);
        HandCard factory = HandCardFactory.getFactory(top); // Gunakan factory method untuk menentukan factory yang akan digunakan
        // TODO, kasih exception kalo factory = null
        hand.add(factory.createHandCard(top, this)); // tambahkan IHandCard yang dibuat factory ke hand
    }
    public void flipHand(){
        for (IHandCard card : hand){
            card.flip();
        }
    }
    public void removeHandCard(int idx){
        // membuang kartu skill yang ada di tangan
        hand.remove(idx);
    }

    /**Board manipulation*/
    public void removeBoardSkill(int idx){
        //membuang kartu skill di board;
        SkillCard card = skillBoard.get(idx);
        skillBoard.set(idx, NullCardHandler.getNullSkillCard());
        for (BoardCard chara : board){
            if (chara.getSkills().contains(card)){
                chara.removeSkill(card);
            }
        }
    }
    public void rotate(int idx){
        board.get(idx).rotate();
    }

    /**Reset energy*/
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

    /**Action*/
    // Menerima indeks kartu tangan yang dipilih dan apakah character di summon pada posisi attack
    // Menambahkan CharacterBoardCard ke indeks null pertama di board
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
    // Menerima indeks kartu tangan yang dipilih dan BoardCard yang dipilih untuk diberi skill
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
    public void playLandCard(int idx){
        LandHandCard card = (LandHandCard) hand.remove(idx);
        HandCardPlayer.playCard(card);
        System.out.println(getName() + " summons " + card.getCardInstance().getName());
    }

    // Menerima index character yang ingin dipakai menyerang, Player musuh, dan index target serangan
    // Karna attack penyerang pasti lebih besar dari attack/defense musuh kartu musuh pasti hancur
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

    public void attack(int idx, Player enemy){
        int attackingVal = board.get(idx).getPositionValue();
        int enemyHealth = enemy.getHealth() - attackingVal;
        if (enemyHealth < 0){
            enemyHealth = 0;
        } 
        enemy.setHealth(enemyHealth);
    }
}
