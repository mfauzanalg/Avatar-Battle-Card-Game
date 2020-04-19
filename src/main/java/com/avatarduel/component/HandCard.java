package com.avatarduel.component;

/**
 * HandCard is an abstract factory that converts Cards to their IHandCard implementations
 * @see Card
 * @see IHandCard
 */
abstract public class HandCard {

    /**
     * Converts card to their IHandCard implementations
     * @param card The card to be converted 
     * @param owner Said card's owner
     * @return The IHandCard implementation of the inputted card
     */
    abstract public IHandCard createHandCard(Card card, Player owner);
}