// File : SkillHandCardFactory.java
// Menerima skill card dan menentukan Factory mana yang akan digunakan

package com.avatarduel.component;

public class SkillHandCardFactory {

    public static HandCard getSkillFactory(SkillCard card, Player owner){
        if (card.getEffect().equals("aura")){
            return new AuraHandCardFactory(card, owner);
        }
        else if (card.getEffect().equals("destroy")){
            return new DestroyHandCardFactory(card, owner);
        }
        else if (card.getEffect().equals("powerup")){
            return new PowerUpHandCardFactory(card, owner);
        }
    }
}