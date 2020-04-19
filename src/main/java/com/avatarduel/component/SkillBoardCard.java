// File : SkillBoardCard
// Abstract decorator for SummonedCharacter

package com.avatarduel.component;

import java.util.List;

abstract public class SkillBoardCard extends BoardCard {
    BoardCard target;
    SkillCard card;

    public SkillBoardCard(BoardCard target, SkillCard _card){
        super(target.owner);
        this.target = target;
        card = _card;
        target.addSkillCard(_card);
    }

    abstract public int getAttackValue();

    abstract public int getDefenseValue();

    public int getPositionValue(){
        return (target.getAttackPos()) ? getAttackValue() : getDefenseValue();
    }

    public Card getCardInstance(){
        return target.getCardInstance();
    }

    public SkillCard getSkillCardInstance(){
        return card;
    }

    public void rotate(){
        target.rotate();
    }

    public void destroy(){
        // remove the card from player's board
        int sidx = this.owner.getSkillBoard().indexOf(this.getSkillCardInstance());
        this.owner.getSkillBoard().set(sidx, NullCardHandler.getNullSkillCard());
        target.removeSkill(this.getSkillCardInstance());
        int cidx = target.owner.getBoard().indexOf(this);
        target.owner.getBoard().set(cidx, target);
        target.destroy();
    }

    public boolean getPowerUp(){
        return target.getPowerUp();
    }

    public boolean getAttackPos(){
        return target.getAttackPos();
    }

    public void setPowerUp(boolean val){
        target.setPowerUp(val);
    }

    public void setAttackPos(boolean val){
        target.setAttackPos(val);
    }

    public void addSkillCard(SkillCard skill){
        target.addSkillCard(skill);
    }

    public List<SkillCard> getSkills(){
        return target.getSkills();
    }

    public void removeSkill(SkillCard card){
        target.removeSkill(card);
    }
}