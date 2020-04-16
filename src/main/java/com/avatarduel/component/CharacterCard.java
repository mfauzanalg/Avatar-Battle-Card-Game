// File : CharacterCard.java
// Menyimpan informasi khusus character card

package com.avatarduel.component;

public class CharacterCard extends Card {
    private int attack;
    private int defense;
    private int power;

    public CharacterCard(int _id, String _name, String ele, String desc, String path, int att, int def, int pow){
        super(Card.CHARACTER_CARD, _id, _name, ele, desc, path);
        attack = att;
        defense = def;
        power = pow;
    }

    public int getAttack(){
        return attack;
    }

    public int getDefense(){
        return defense;
    }

    public int getPower(){
        return power;
    }
}