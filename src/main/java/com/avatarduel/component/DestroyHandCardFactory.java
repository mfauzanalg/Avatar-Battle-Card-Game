// File : DestroyHandCardFactory.java
// Mengubah DestroySkillCard menjadi DestroyHandCard

package com.avatarduel.component;

public class DestroyHandCardFactory extends HandCard {

    public IHandCard createHandCard(Card card, Player owner){
        return new DestroyHandCard(card, owner);
    }
}