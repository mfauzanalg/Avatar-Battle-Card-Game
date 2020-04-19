package com.avatarduel.component;

/**
 * IHandCard is an interface for cards that gets added to a player's hand
 * @see CharacterHandCard
 * @see AuraHandCard
 * @see PowerUpHandCard
 * @see DestroyHandCard
 * @see LandHandCard
 */
public interface IHandCard {

    /**
     * Returns the card this class represents
     * @return Card class that stores info about the card
     */
    Card getCardInstance();

    /**
     * Returns the owner of this card
     * @return Owner of this card
     */
    Player getOwner();

    /**
     * Change card status from being revealed to closed and vice versa
     */
    void flip();    

    /**
     * Checks whether the card is revealed or not
     * @return true if card is revealed, false otherwise
     */
    boolean getIsOpen();
}