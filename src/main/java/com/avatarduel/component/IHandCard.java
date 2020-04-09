// File : IHandCard.java
// Interface untuk kartu kartu yang ada di tangan
package com.avatarduel.component;

public interface IHandCard {

    Card getCardInstance();

    Player getOwner();

    void flip();

    boolean getIsOpen();
}