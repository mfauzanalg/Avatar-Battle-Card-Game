// File : AuraBoardCard.java
// Concrete decorator for SummonedCharacter
package com.avatarduel.component;

public class AuraBoardCard extends SkillBoardCard {
    BoardCard target;

    public AuraBoardCard(BoardCard _target, AuraSkillCard card){
        super(_target, card);
        target = _target;
    }

    public int getPositionValue(){
        return (attackPos) ? (card.getAttack() + target.getPositionValue()) : (card.getDefense() + target.getPositionValue());
    }    

    public void destroy(){
        // remove the card from player's board
    }
}