// File : PowerUpHandCard.java
// Handles the behaviour of Power Up Card in Hand

package com.avatarduel.component;

public class PowerUpHandCard implements IHandCard {
    PowerUpSkillCard power;
    SummonedCharacter target;
    Player owner;

    public PowerUpHandCard(PowerUpSkillCard pow, Player _owner){
        power = pow;
        owner = _owner;
    }

    public void setTarget(SummonedCharacter _target){
        target = _target;
    }

    public Card getCardInstance(){
        return power;
    }

    public Player getOwner(){
        return owner;
    }
    
    public void play(){
        // Taruh kartu ke board

        target.setPowerUp(true);
    }
}