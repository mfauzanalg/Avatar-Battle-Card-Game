package com.avatarduel.component;

/**
 * HandCardFactory is the factory method that returns Factory according to the card inputted
 */
public class HandCardFactory {

    /**
     * Returns a CharacterHandCardFactory when the inputted card is a CharacterCard, SkillHandCardFactory when it's a SkillCard, and LandCardFactory when it's a LandCard
     * @param card card to be converted
     * @return Factory that can convert the specified input card
     */
    public static HandCard getFactory(Card card){
        HandCard retval = null;
        if (card.getType().equals(Card.CHARACTER_CARD)){
            retval = new CharacterHandCardFactory();
        }
        else if (card.getType().equals(Card.SKILL_CARD)){
            retval = SkillHandCardFactory.getSkillFactory((SkillCard) card);
        }
        else if (card.getType().equals(Card.LAND_CARD)){
            retval = new LandHandCardFactory();
        }

        return retval;
    }
}