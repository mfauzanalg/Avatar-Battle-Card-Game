// File : HandCardFactory.java
// Factory method untuk mengubah Card menjadi HandCard

package com.avatarduel.component;

public class HandCardFactory {

    public static HandCard getFactory(Card card){
        if (card.getType().equals("character")){
            return new CharacterHandCardFactory();
        }
        else if (card.getType().equals("skill")){
            return SkillHandCardFactory.getSkillFactory(card);
        }
        else if (card.getType().equals("land")){
            return new LandHandCardFactory();
        }
    }
}