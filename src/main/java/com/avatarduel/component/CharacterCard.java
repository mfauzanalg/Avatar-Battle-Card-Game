// File : CharacterCard.java
// Menyimpan informasi khusus character card

package com.avatarduel.component;

public class CharacterCard extends Card {
    private int attack;
    private int defense;
    private int power;

    public CharacterCard(){
        super();
        attack = 0;
        defense = 0;
        power = 0;
    }
    
    public CharacterCard(int _id, String _name, String ele, String desc, String path, int att, int def, int pow){
        super(Card.CHARACTER_CARD, _id, _name, ele, desc, path);
        attack = att;
        defense = def;
        power = pow;
    }

    public int getAttack(){
        return attack;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }

    public int getDefense(){
        return defense;
    }

    public void setDefense(int def){
        this.defense = def;
    }

    public int getPower(){
        return power;
    }
}