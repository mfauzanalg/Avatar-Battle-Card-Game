// File : LandCard.java
// Menyimpan informasi Land Card
package com.avatarduel.component;

public class LandCard extends Card {
    Player target;

    public LandCard(int _id, String _name, String ele, String desc, String path){
        super(Card.LAND_CARD, _id, _name, ele, desc, path);
    }

    public void setPlayer(Player _target){
        target = _target;
    }
}