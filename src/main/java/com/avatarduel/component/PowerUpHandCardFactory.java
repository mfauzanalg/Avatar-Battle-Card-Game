// File : PowerUpHandCardFactory.java
// Mengubah PowerUpSkillCard menjadi PowerUpHandCard

package com.avatarduel.component;

public class PowerUpHandCardFactory extends HandCard {

    public IHandCard createHandCard(Card card, Player owner){
        return new PowerUpHandCard(card, owner);
    }
}