// File : PowerUpSkillCard.java
// Handles the behaviour of Power Up Card when played

package com.avatarduel.component;

public class PowerUpSkillCard extends SkillCard implements IHandCard, IDestructible {
    ISummoned target;

    public PowerUpSkillCard(int _id, String _name, String ele, String desc, String path){
        super("powerup", _id, _name, ele, desc, path);
    }

    // Semua kode dibawah komen ini agak ragu, alasannya sama dengan yang ada di LandCard.java
    public void setTarget(ISummoned _target){
        target = _target;
    }

    public void play(){
        target.setPowerUp(true);
    }

    public void destroy(){
        // remove this card from the board
    }
}