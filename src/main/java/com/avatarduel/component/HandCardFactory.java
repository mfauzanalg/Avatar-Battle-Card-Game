// File : HandCardFactory.java
// Factory method untuk mengubah Card menjadi HandCard

package com.avatarduel.component;

public class HandCardFactory {

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