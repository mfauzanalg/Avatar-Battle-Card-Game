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

    public BoardCard(Player _owner){
        owner = _owner;
        isOpen = true;
        attackPos = true;
        isPoweredUp = false;
    }

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

    public void attack(Player other){
        // Method kalo board musuh kosong
        // Langsung kurangi HP other sebanyak this.getPositionValue()
    }

    public void attack(Player other, int idx){
        // Check getPositionValue this sama other.board[idx]
        // Kalo other lebih gede, gak bisa diserang (Print message or something)
        // Kalo this lebih gede, jalankan destroy milik other.board[idx] lalu kurangi HP other sesuai selisih
    }

    abstract public int getPositionValue();

    abstract public Card getCardInstance();

    abstract public void destroy();

    public boolean getPowerUp(){
        return isPoweredUp;
    }

    public boolean getIsOpen(){
        return isOpen;
    }

    public boolean getAttackPos(){
        return attackPos;
    }

    public void setPowerUp(boolean val){
        isPoweredUp = val;
    }

    public void setIsOpen(boolean val){
        isOpen = val;
    }

    public void setAttackPos(boolean val){
        attackPos = val;
    }

    public void addSkillCard(SkillCard skill){
        skills.add(skill);
    }

    public List<SkillCard> getSkills(){
        return skills;
    }
}