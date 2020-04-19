// File : AuraBoardCard.java
// Concrete decorator for SummonedCharacter
package com.avatarduel.component;

public class AuraBoardCard extends SkillBoardCard {
    BoardCard target;
    int attackVal;
    int defenseVal;

    public AuraBoardCard(BoardCard _target, AuraSkillCard card){
        super(_target, card);
        target = _target;
        attackVal = card.getAttack();
        defenseVal = card.getDefense();
    }

    public int getAttackValue(){
        return attackVal + target.getAttackValue();
    }

    public int getDefenseValue(){
        return defenseVal + target.getDefenseValue();
    }    
}