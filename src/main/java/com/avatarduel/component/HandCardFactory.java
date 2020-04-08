// File : HandCardFactory.java
// Factory method untuk mengubah Card menjadi HandCard

package com.avatarduel.component;

public class HandCardFactory {

    public static HandCard getFactory(Card card, Player owner){
        if (card.getType().equals("character")){
            return new CharacterHandCardFactory(card, owner);
        }
        else if (card.getType().equals("skill")){
            return SkillHandCardFactory.getSkillFactory(card, owner);
        }
        else if (card.getType().equals("land")){
            return new LandHandCardFactory(card, owner);
        }
    }
}