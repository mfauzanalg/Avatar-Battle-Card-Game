// File : AuraHandCardFactory.java
// Mengubah AuraCard menjadi AuraHandCard

package com.avatarduel.component;

public class AuraHandCardFactory extends HandCard {

    public IHandCard createHandCard(Card card, Player owner){
        return new AuraHandCard((AuraSkillCard) card, owner);
    }
}