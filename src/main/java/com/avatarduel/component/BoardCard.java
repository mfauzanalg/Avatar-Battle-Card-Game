// File : BoardCard.java
// Abstract class yang akan menjadi interface untuk SummonedCharacter dan Decoratornya (SkillCard)

package com.avatarduel.component;

import java.util.List;
import java.util.ArrayList;

abstract public class BoardCard implements ISummoned, IDestructible {
    protected List<SkillCard> skills = new ArrayList<SkillCard>();
    protected Player owner;
    protected boolean isOpen;
    protected boolean attackPos;
    protected boolean isPoweredUp;

    public BoardCard(Player _owner, boolean open, boolean attack){
        owner = _owner;
        isOpen = open;
        attackPos = attack;
        isPoweredUp = false;
    }

    public BoardCard(Player _owner, boolean open, boolean attack, boolean power){
        owner = _owner;
        isOpen = open;
        attackPos = attack;
        isPoweredUp = power;
    }

    public boolean flip(){
        boolean retval = !isOpen;
        isOpen = true;
        return retval;
    }

    public void rotate(){
        attackPos = !attackPos;
    }

    abstract public int getPositionValue();

    abstract public Card getCardInstance();

    abstract public destroy();

    public boolean getPowerUp(){
        return isPoweredUp;
    }

    public void setPowerUp(boolean val){
        isPoweredUp = val;
    }

    public void addSkillCard(SkillCard skill){
        skills.add(skill);
    }
}