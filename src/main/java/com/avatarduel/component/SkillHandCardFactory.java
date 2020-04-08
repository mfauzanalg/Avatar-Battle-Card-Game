// File : SkillHandCardFactory.java
// Menerima skill card dan menentukan Factory mana yang akan digunakan

package com.avatarduel.component;

public class SkillHandCardFactory {

    public static HandCard getSkillFactory(SkillCard card){
        if (card.getEffect().equals("aura")){
            return new AuraHandCardFactory();
        }
        else if (card.getEffect().equals("destroy")){
            return new DestroyHandCardFactory();
        }
        else if (card.getEffect().equals("powerup")){
            return new PowerUpHandCardFactory();
        }
    }
}