// File : SkillHandCardFactory.java
// Menerima skill card dan menentukan Factory mana yang akan digunakan

package com.avatarduel.component;

public class SkillHandCardFactory {

    public static HandCard getSkillFactory(SkillCard card){
        HandCard retval = null;

        if (card.getEffect().equals("aura")){
            retval = new AuraHandCardFactory();
        }
        else if (card.getEffect().equals("destroy")){
            retval = new DestroyHandCardFactory();
        }
        else if (card.getEffect().equals("powerup")){
            retval = new PowerUpHandCardFactory();
        }

        return retval;
    }
}