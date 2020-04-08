// File : LandHandCardFactory.java
// Mengubah LandCard menjadi LandHandCard

package com.avatarduel.component;

public class LandHandCardFactory extends HandCard {
    
    public IHandCard createHandCard(Card card, Player owner){
        return new LandHandCard(card, owner);
    } 
}