// File : DestroyHandCard.java
// Handles the behaviour of Destroy Skill Cards in hand 

package com.avatarduel.component;

public class DestroyHandCard implements IHandCard {
    private SummonedCharacter target;
    private DestroySkillCard skill;
    private Player owner;

    public DestroyHandCard(DestroySkillCard card, Player _owner){
        skill = card;
        owner = _owner;
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

    public void play(){
        // Put this card into board
        // Get the target card and set it as target
        target.destroy();
        //Immediately remove this card from board
    }
}