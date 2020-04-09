package com.avatarduel.component;
import java.util.*;

public class Player{
    private String name;
    private int health;
    private Stack<Card> deck;
    private List<IHandCard> hand; //Ini harus IHandCard karna method play adanya di IHandCard
    private List<BoardCard> board; // Ini juga harus BoardCard biar bisa pake dekorator
    private List<SkillCard> skillBoard; // Kalo perlu Cardnya, pake method getCardInstance() ya
    private int maxWater, currentWater,
                maxEarth, currentEarth,
                maxFire, currentFire,
                maxAir, currentAir;

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
    }

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
            default:
                System.out.println("No Match");
                return 0;
		}
	}

    public <T> void addCardsToDeck(List<T> l){
        this.deck.addAll((Collection<? extends Card>) l);
	}

    public Stack<Card> getDeck(){
        return this.deck;
	}

    public void shuffleDeck(){
        Collections.shuffle(this.deck);
	}

    public void draw(){
        //pop card dari deck
        Card top = deck.pop();
        HandCard factory = HandCardFactory.getFactory(top); // Gunakan factory method untuk menentukan factory yang akan digunakan
        // TODO, kasih exception kalo factory = null
        hand.add(factory.createHandCard(top, this)); // tambahkan IHandCard yang dibuat factory ke hand
	}

    public void play(int idx){
        System.out.println("belum diimplementasi");
        IHandCard card = hand.remove(idx);
        //card.play(); // Play jadinya pake HandCardPlayer.playCard(...) aja
        //TODO, ubah IHandCard jadi BoardCard/skillBoardCard lalu put ke boar/skillBoard
        // 
	}

    public void rotate(int idx){
        board.get(idx).rotate();
	}

    public void attack(int idx){
        //menyerang player/character musuh menggunakan character di board
        System.out.println("belum diimplementasi");
        //yang ngehandle attack board atau player?
        //buat interface targetable buat attack??
        // kayaknya board aja, player buat nentuin yang mana yang diserang
	}

    public void destroy(int idx){
        //membuang kartu skill di board;
        System.out.println("belum diimplementasi");
        //yang bisa didestroy kan skill sm character, cara tahunya gimana?
	}
}
