// File : AuraHandCard.java
// Handles the behaviour of Aura cards

package com.avatarduel.component;

public class AuraHandCard implements IHandCard {
    private AuraSkillCard skill;
    private Player target;
    private boolean isOpen;

    public AuraHandCard(AuraSkillCard card, Player _target){
        skill = card;
        target = _target;
        isOpen = true;
    }

    public Card getCardInstance(){
        return skill;
    }

    public Player getOwner(){
        return target;
    }

    public void flip(){
        isOpen = !isOpen;
    }

    public boolean getIsOpen(){
        return isOpen;
    }

    public void play(){
        // Create a AuraBoardCard as a Decorator to Summoned Character
        // Add this card to Player's board
    }
}