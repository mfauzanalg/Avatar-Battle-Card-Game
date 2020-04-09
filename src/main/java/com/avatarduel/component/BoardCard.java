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

    abstract public boolean getPowerUp();

    abstract public boolean getAttackPos();

    abstract public void setPowerUp(boolean val);

    abstract public void setAttackPos(boolean val);

    abstract public void addSkillCard(SkillCard skill);

    abstract public List<SkillCard> getSkills();
}