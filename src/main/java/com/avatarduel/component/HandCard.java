// File : HandCard.java
// Factory yang akan mengubah Card yang di draw menjadi HandCard

package com.avatarduel.component;

abstract public class HandCard {

    abstract public IHandCard createHandCard(Card card, Player owner);
}