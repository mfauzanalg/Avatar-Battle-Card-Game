package com.avatarduel.component;

/**
 * AuraHandCardFactory is a Factory that converts an AuraSkillCard to an AuraHandCard
 * @see HandCard
 * @see AuraSkillCard
 * @see AuraHandCard
 * @see Player
 */
public class AuraHandCardFactory extends HandCard {

    /**
     * Converts an AuraSkillCard to an AuraHandCard with the Player who adds said card to their hand as the owner
     * @param card AuraSkillCard to be converted into AuraHandCard
     * @param owner The Player who owns the AuraSkillCard in question
     * @return AuraHandCard of the specified AuraSkillCard
     */
    public IHandCard createHandCard(Card card, Player owner){
        return new AuraHandCard((AuraSkillCard) card, owner);
    }
}