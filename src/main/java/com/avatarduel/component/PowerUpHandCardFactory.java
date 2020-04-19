package com.avatarduel.component;

/**
 * PowerUpHandCardFactory is a Factory that converts PowerUpSkillCard to PowerUpHandCard
 * @see HandCard
 * @see PowerUpSkillCard
 * @see PowerUpHandCard
 */
public class PowerUpHandCardFactory extends HandCard {

    /**
     * Converts an PowerUpSkillCard to an PowerUpHandCard with the Player who adds said card to their hand as the owner
     * @param card PowerUpSkillCard to be converted into PowerUpHandCard
     * @param owner The Player who owns the PowerUpSkillCard in question
     * @return PowerUpHandCard of the specified PowerUpSkillCard
     */
    public IHandCard createHandCard(Card card, Player owner){
        return new PowerUpHandCard((PowerUpSkillCard) card, owner);
    }
}