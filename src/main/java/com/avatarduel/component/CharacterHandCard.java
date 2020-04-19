package com.avatarduel.component;

/**
 * CharacterHandCard represents CharacterCards that is currently in a Player's Hand
 * @see CharacterCard
 * @see Player
 * @see IHandCard
 */
public class CharacterHandCard implements IHandCard {
    CharacterCard kar;
    Player target;
    boolean isOpen;

    /**
     * Creates a new CharacterHandCard with the CharacterCard that is added to the player's hand as card, and said player as the owner 
     * @param card The CharacterCard that will be added to the player's hand
     * @param _target The player in question
     */
    public CharacterHandCard(CharacterCard card, Player _target){
        kar = card;
        target = _target;
        isOpen = true;
    }

    /**
     * Returns the CharacterCard this card represents
     */
    public Card getCardInstance(){
        return kar;
    }

    /**
     * Returns this card's owner
     */
    public Player getOwner(){
        return target;
    }

    /**
     * Change this card from being revealed to closed and vice versa
     */
    public void flip(){
        isOpen = !isOpen;
    }

    /**
     * Returns true it this card is revealed, false if closed
     * @return true if revealed, false otherwise
     */
    public boolean getIsOpen(){
        return isOpen;
    }
}