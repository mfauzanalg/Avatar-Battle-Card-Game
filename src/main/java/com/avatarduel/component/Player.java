package com.avatarduel.component;
import java.util.*;

public class Player{
    private String name;
    private int health;
    private Stack<Card> deck;
    private List<IHandCard> hand;
    private List<ISummoned> board;

    public Player(String name, int health)
    {
        this.name = name;
        this.health = health;
        this.deck = new Stack<Card>();
        this.hand = new List<IHandCard>();
        this.board = new List<ISummoned>();
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
        //pop card dari deck, add card ke hand;
        System.out.println("belum diimplementasi");
	}

    public void play(){
        //play kartu di tangan yang dipilih Player
        //cara tahu kartu yang dipilih player gimana???
        System.out.println("belum diimplementasi");
        //play card from hand
        //remove card from hand
        //add card to board
	}

    public void rotate(){
        //rotate kartu di board yang dipilih Player
        //cara tahu kartu yang dipilih player gimana???
        System.out.println("belum diimplementasi");
	}

    public void attack(){
        //menyerang player/character musuh menggunakan character di board
        //cara tahu kartu yang dipilih player gimana???
        System.out.println("belum diimplementasi");
	}

    public void destroy(){
        //membuang kartu skill di board;
        //cara tahu kartu yang dipilih player gimana???
        System.out.println("belum diimplementasi");
	}
}
