package com.avatarduel.component;

/**
 * CharacterHandCardFactory is a Factory that converts CharacterCards to CharacterHandCard
 * @see HandCard
 * @see CharacterCard
 * @see CharacterHandCard
 * @see Player
 */
public class CharacterHandCardFactory extends HandCard {
      
    /**
     * Converts an CharacterCard to an CharacterHandCard with the Player who adds said card to their hand as the owner
     * @param card CharacterCard to be converted into AuraHandCard
     * @param owner The Player who owns the CharacterCard in question
     * @return CharacterHandCard of specified CharacterCard
     */
    public IHandCard createHandCard(Card card, Player owner){
        return new CharacterHandCard((CharacterCard) card, owner);
    } 
}