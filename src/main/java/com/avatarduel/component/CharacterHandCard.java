// File : CharacterHandCard.java
// Handles how the character card is summoned

package com.avatarduel.component;

public class CharacterHandCard implements IHandCard {
    CharacterCard kar;
    Player target;
    boolean isOpen;

    public CharacterHandCard(CharacterCard card, Player _target){
        kar = card;
        target = _target;
        isOpen = true;
    }

    public Card getCardInstance(){
        return kar;
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