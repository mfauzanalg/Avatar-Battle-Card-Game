// File : LandHandCard.java
// Handles the behaviour of LandCard in Hand
package com.avatarduel.component;

public class LandHandCard implements IHandCard {
    private LandCard land;
    private Player target;

    public LandHandCard(LandCard card, Player _target){
        land = card;
        target = _target;
    }

    public Card getCardInstance(){
        return land;
    }

    public Player getOwner(){
        return target;
    }
    public void play(){
        // Tambah power player sesuai elemen kartu land
        // Tunggu implementasi player
        System.out.println("blm diimplemen");
    }
}