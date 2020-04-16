// File : SkillHandCardFactory.java
// Menerima skill card dan menentukan Factory mana yang akan digunakan

package com.avatarduel.component;

public class SkillHandCardFactory {

    public static HandCard getSkillFactory(SkillCard card){
        HandCard retval = null;

        if (card.getEffect().equals(SkillCard.SKILL_AURA)){
            retval = new AuraHandCardFactory();
        }
        else if (card.getEffect().equals(SkillCard.SKILL_DESTROY)){
            retval = new DestroyHandCardFactory();
        }
        else if (card.getEffect().equals(SkillCard.SKILL_POWERUP)){
            retval = new PowerUpHandCardFactory();
        }

        return retval;
    }
}