// File : LandHandCard.java
// Handles the behaviour of LandCard in Hand
package com.avatarduel.component;

public class LandHandCard implements IHandCard {
    private LandCard land;
    private Player target;
    private boolean isOpen;

    public LandHandCard(LandCard card, Player _target){
        land = card;
        target = _target;
        isOpen = true;
    }

    public Card getCardInstance(){
        return land;
    }

    public Player getOwner(){
        return target;
    }

    public void flip(){
        isOpen = !isOpen;
    }

    public boolean getIsOpen(){
        return isOpen;
    }
}