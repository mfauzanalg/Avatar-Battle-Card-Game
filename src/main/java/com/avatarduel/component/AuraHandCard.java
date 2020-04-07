// File : AuraHandCard.java
// Handles the behaviour of Aura cards

package com.avatarduel.component;

public class AuraHandCard implements IHandCard, IDestructible {
    private SummonedCharacter target;
    private AuraSkillCard skill;

    public AuraHandCard(AuraSkillCard card){
        skill = card;
    }

    public void setTarget(SummonedCharacter _target){
        target = _target;
    }

    public void play(){
        // Add this card to board

        // Add this card to list of card that powers up target
        target.addSkillCard(this);
        target.setAuraAttack(target.getAuraAttack() + skill.getAttack());
        target.setAuraDefense(target.getAuraDefense() + skill.getDefense());
    }

    public void destroy(){
        // Remove the aura attack and defense from this card
        target.setAuraAttack(target.getAuraAttack() - skill.getAttack());
        target.setAuraDefense(target.getAuraDefense() - skill.getDefense());
        // remove card from board

    }
}