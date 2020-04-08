// File : CharacterHandCardFactory.java
// Mengubah CharacterCard menjadi CharacterHandCard

package com.avatarduel.component;

public class CharacterHandCardFactory extends HandCard {
    
    public IHandCard createHandCard(Card card, Player owner){
        return new CharacterHandCard((CharacterCard) card, owner);
    } 
}