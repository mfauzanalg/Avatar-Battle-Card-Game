// File : BoardCard.java
// Abstract class yang akan menjadi interface untuk SummonedCharacter dan Decoratornya (SkillCard)

package com.avatarduel.component;

import java.util.List;

abstract public class BoardCard implements ISummoned, IDestructible {
    protected Player owner;

    public BoardCard(Player _owner){
        owner = _owner;
    }

    abstract public void rotate();

    public Player getOwner(){
        return owner;
    }

    abstract public int getAttackValue();

    abstract public int getDefenseValue();
    
    abstract public int getPositionValue();

    abstract public Card getCardInstance();

    abstract public void destroy();

    abstract public boolean getPowerUp();

    abstract public boolean getAttackPos();

    abstract public void setPowerUp(boolean val);

    abstract public void setAttackPos(boolean val);

    abstract public void addSkillCard(SkillCard skill);

    abstract public List<SkillCard> getSkills();

    abstract public void setCanAttack(boolean val);

    abstract public boolean getCanAttack();

    abstract public void removeSkill(SkillCard skill);
}