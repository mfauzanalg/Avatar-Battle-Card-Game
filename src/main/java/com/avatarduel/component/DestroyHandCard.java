// File : DestroyHandCard.java
// Handles the behaviour of Destroy Skill Cards in hand 

package com.avatarduel.component;

public class DestroyHandCard implements IHandCard {
    private SummonedCharacter target;
    private DestroySkillCard skill;
    private Player owner;
    private boolean isOpen;

    public DestroyHandCard(DestroySkillCard card, Player _owner){
        skill = card;
        owner = _owner;
        isOpen = true;
    }

    public void setTarget(SummonedCharacter _target){
        target = _target;
    }

    public Card getCardInstance(){
        return skill;
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
}