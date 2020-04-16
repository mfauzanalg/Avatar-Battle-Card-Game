package com.avatarduel.component;
import java.util.*;

public class Player{
    private String name;
    private int health;
    private Stack<Card> deck;
    private List<IHandCard> hand; //Ini harus IHandCard karna method play adanya di IHandCard
    private List<BoardCard> board; // Ini juga harus BoardCard biar bisa pake dekorator
    private List<SkillCard> skillBoard; // Kalo perlu Cardnya, pake method getCardInstance() ya
    private int maxWater, currentWater, maxEarth, currentEarth, maxFire, currentFire, maxAir, currentAir, maxEnergy, currentEnergy;

    public Player(String name, int health)
    {
        this.name = name;
        this.health = health;
        this.deck = new Stack<Card>();
        this.hand = new ArrayList<IHandCard>();
        this.board = new ArrayList<BoardCard>();
        this.skillBoard = new ArrayList<SkillCard>();
        this.maxWater = 0; this.currentWater = 0;
        this.maxEarth = 0; this.currentEarth = 0;
        this.maxFire = 0; this.currentFire = 0;
        this.maxAir = 0; this.currentAir = 0;
        this.maxEnergy = 0; this.currentEnergy = 0;
        for (int i = 0; i < 8; i++){  // Inisialisasi board dengan null
            board.add(null);
            skillBoard.add(null);
        }
    }

    public List<IHandCard> getHand() {return this.hand;}

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setHealth(int health){
        this.health = health;
	}

    public int getHealth(){
        return this.health;
	}

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

    public <T extends Card> void addCardsToDeck(List<T> l){
        this.deck.addAll(l);
	}

    public Stack<Card> getDeck(){
        return this.deck;
	}

    public void shuffleDeck(){
        Collections.shuffle(this.deck);
	}

    public <T extends Card> void addCard(T c){
        this.deck.push(c);
	}

    public <T extends Card> void addSpecificCard(List<T> l, int id){
        T c = l.stream()
            .filter(i -> i.getId() == id)
            .findAny()
            .orElse(null);
        if (c != null){
            this.addCard(c);  
		}
	}

    public <T extends Card> void addRandomCards(List<T> l, int quantity){
        List<T> l1 = l;
        int count = 0;
        while (count != quantity){
            Collections.shuffle(l1);
            Card c = l1.get(0);
            this.addCard(c);
            count++;
		}
    }
    
    public List<BoardCard> getBoard(){
        return board;
    }

    public List<SkillCard> getSkillBoard(){
        return skillBoard;
    }

    public void draw(){
        //pop card dari deck
        Card top = deck.pop();
        System.out.println(deck.capacity());
        HandCard factory = HandCardFactory.getFactory(top); // Gunakan factory method untuk menentukan factory yang akan digunakan
        // TODO, kasih exception kalo factory = null
        hand.add(factory.createHandCard(top, this)); // tambahkan IHandCard yang dibuat factory ke hand
	}

    // Menerima indeks kartu tangan yang dipilih dan apakah character di summon pada posisi attack
    // Menambahkan CharacterBoardCard ke indeks null pertama di board
    public void playCharacterCard(int idx, boolean attack){
        if (board.indexOf(null) == -1){ // Jika board penuh
            // ...Throw exception? 
        }
        else{

            CharacterHandCard card = (CharacterHandCard) hand.remove(idx);
            HandCardPlayer.playCard(card, attack);
        }
    }

    // Menerima indeks kartu tangan yang dipilih dan BoardCard yang dipilih untuk diberi skill
    public void playSkillCard(int idx, BoardCard target){
        if (skillBoard.indexOf(null) == -1){ // Jika skillboard penuh
            // ...
        }
        else{

            SkillCard card = (SkillCard) hand.get(idx).getCardInstance();
            if (card.getEffect().equals(SkillCard.SKILL_AURA)){
                HandCardPlayer.playCard((AuraHandCard) hand.remove(idx), target);
            }
            else if (card.getEffect().equals(SkillCard.SKILL_POWERUP)){
                HandCardPlayer.playCard((PowerUpHandCard) hand.remove(idx), target);    
            }
            else if (card.getEffect().equals(SkillCard.SKILL_DESTROY)){
                HandCardPlayer.playCard(target);
            }
        }
    }

    public void playLandCard(int idx){
        LandHandCard card = (LandHandCard) hand.remove(idx);
        HandCardPlayer.playCard(card);
    }

    public void rotate(int idx){
        board.get(idx).rotate();
	}

    // Menerima index character yang ingin dipakai menyerang, Player musuh, dan index target serangan
    // Karna attack penyerang pasti lebih besar dari attack/defense musuh kartu musuh pasti hancur
    public void attack(int idx, Player enemy, int enemyidx){
        boolean isAttackPos = enemy.getBoard().get(enemyidx).getAttackPos();
        int attackingVal = board.get(idx).getPositionValue();
        int attackedVal = enemy.getBoard().get(enemyidx).getPositionValue();
        enemy.getBoard().get(enemyidx).destroy();
        if (isAttackPos) {
            enemy.setHealth(enemy.getHealth() - attackingVal + attackedVal);
        }
	}

    public void remove(int idx){
        //membuang kartu skill di board;
        SkillCard card = skillBoard.remove(idx);
        for (BoardCard chara : board){
            if (chara.getSkills().contains(card)){
                chara.removeSkill(card);
            }
        }
	}
}
