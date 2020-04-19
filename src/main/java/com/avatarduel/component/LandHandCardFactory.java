package com.avatarduel.component;

/**
 * LandHandCardFactory is a Factory that converts LandCard to LandHandCard
 * @see HandCard
 * @see LandCard
 * @see LandHandCard
 * @see Player
 */
public class LandHandCardFactory extends HandCard {
    
    /**
     * Converts an LandCard to an LandHandCard with the Player who adds said card to their hand as the owner
     * @param card LandCard to be converted into AuraHandCard
     * @param owner The Player who owns the LandCard in question
     * @return LandHandCard of specified LandCard
     */
    public IHandCard createHandCard(Card card, Player owner){
        return new LandHandCard((LandCard) card, owner);
    } 
}