// File : HandCardFactory.java
// Factory method untuk mengubah Card menjadi HandCard

package com.avatarduel.component;

public class HandCardFactory {

    public static HandCard getFactory(Card card){
        HandCard retval = null;
        if (card.getType().equals("character")){
            retval = new CharacterHandCardFactory();
        }
        else if (card.getType().equals("skill")){
            retval = SkillHandCardFactory.getSkillFactory((SkillCard) card);
        }
        else if (card.getType().equals("land")){
            retval = new LandHandCardFactory();
        }

        return retval;
    }
}