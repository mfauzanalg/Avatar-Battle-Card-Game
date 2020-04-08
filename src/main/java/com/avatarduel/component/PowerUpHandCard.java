// File : PowerUpHandCard.java
// Handles the behaviour of Power Up Card in Hand

package com.avatarduel.component;

public class PowerUpHandCard implements IHandCard {
    PowerUpSkillCard power;
    SummonedCharacter target;
    Player owner;
    boolean isOpen;

    public PowerUpHandCard(PowerUpSkillCard pow, Player _owner){
        power = pow;
        owner = _owner;
        isOpen = true;
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

    public void flip(){
        isOpen = !isOpen;
    }

    public boolean getIsOpen(){
        return isOpen;
    }
    
    public void play(){
        // Taruh kartu ke board

        target.setPowerUp(true);
    }
}