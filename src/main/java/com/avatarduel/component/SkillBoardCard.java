// File : SkillBoardCard
// Abstract decorator for SummonedCharacter

package com.avatarduel.component;

abstract public class SkillBoardCard extends BoardCard {
    BoardCard target;
    SkillCard card;

    public SkillBoardCard(BoardCard target, SkillCard _card){
        super(target.owner, target.isOpen, target.attackPos, target.isPoweredUp);
        this.target = target;
        card = _card;
        target.addSkillCard(_card);
    }

    abstract public int getPositionValue();

    public Card getCardInstance(){
        return card;
    }

    abstract public void destroy();
}