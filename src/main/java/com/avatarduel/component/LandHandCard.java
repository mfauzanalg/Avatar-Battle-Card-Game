package com.avatarduel.component;

/**
 * LandHandCard represents LandCard that is currently in a player's hand
 * @see LandCard
 * @see Player
 * @see IHandCard
 */
public class LandHandCard implements IHandCard {
    private LandCard land;
    private Player target;
    private boolean isOpen;

    /**
     * Creates a new LandHandCard with the LandCard that is added to the player's hand as card, and said player as the owner 
     * @param card The LandCard that will be added to the player's hand
     * @param _target The player in question
     */
    public LandHandCard(LandCard card, Player _target){
        land = card;
        target = _target;
        isOpen = true;
    }

    /**
     * Returns the LandCard this card represents
     */
    public Card getCardInstance(){
        return land;
    }

    /**
     * Returns the owner of this card
     * @return Card's owner
     */
    public Player getOwner(){
        return target;
    }

    /**
     * Change card's state form is being revealed to is closed and vice versa
     */
    public void flip(){
        isOpen = !isOpen;
    }

    /**
     * Returns whether the card is currently being revealed or not
     * @return true if revealed, false otherwise
     */
    public boolean getIsOpen(){
        return isOpen;
    }
}