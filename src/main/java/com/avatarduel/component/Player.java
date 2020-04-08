package com.avatarduel.component;
import java.util.*;

public class Player{
    private String name;
    private int health;
    private Stack<Card> deck;
    private List<IHandCard> hand; //Ini harus IHandCard karna method play adanya di IHandCard
    private List<BoardCard> board; // Ini juga harus BoardCard biar bisa pake dekorator
    private List<SkillCard> skillBoard; // Kalo perlu Cardnya, pake method getCardInstance() ya

    public Player(String name, int health)
    {
        this.name = name;
        this.health = health;
        this.deck = new Stack<Card>();
        this.hand = new ArrayList<IHandCard>();
        this.board = new ArrayList<BoardCard>();
        this.skillBoard = new ArrayList<SkillCard>();
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

    public void draw(){
        //pop card dari deck
        Card top = deck.pop();
        HandCard factory = HandCardFactory.getFactory(top); // Gunakan factory method untuk menentukan factory yang akan digunakan
        // TODO, kasih exception kalo factory = null
        hand.add(factory.createHandCard(top, this)); // tambahkan IHandCard yang dibuat factory ke hand
	}

    public void play(){
        //play kartu di tangan yang dipilih Player
        //cara tahu kartu yang dipilih player gimana???
        // Hand kan list, kalo bisa play ini nerima index yang didaoet dari GUI,
        // Trus jalanin play punya IHandCard yang ada di index tsb
        System.out.println("belum diimplementasi");
        //play card from hand
        //remove card from hand
        //add card to board
	}

    public void rotate(){
        //rotate kartu di board yang dipilih Player
        //cara tahu kartu yang dipilih player gimana???
        // Kayaknya sama dengan play bedanya yang di klik board doang
        System.out.println("belum diimplementasi");
	}

    public void attack(){
        //menyerang player/character musuh menggunakan character di board
        //cara tahu kartu yang dipilih player gimana???
        // Mirip dengan rotate
        System.out.println("belum diimplementasi");
	}

    public void destroy(){
        //membuang kartu skill di board;
        //cara tahu kartu yang dipilih player gimana???
        System.out.println("belum diimplementasi");
	}
}
