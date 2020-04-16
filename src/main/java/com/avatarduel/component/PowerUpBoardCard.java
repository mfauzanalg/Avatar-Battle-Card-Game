// File : PowerUpBoardCard.java
// Concrete decorator for SummonedCharacter

package com.avatarduel.component;

public class PowerUpBoardCard extends SkillBoardCard {
    BoardCard target;

    public PowerUpBoardCard(BoardCard _target, PowerUpSkillCard card){
        super(_target, card);
        target = _target;
        target.setPowerUp(true);
    }

    public int getAttackValue(){
        return target.getAttackValue();
    }

    public int getDefenseValue(){
        return target.getDefenseValue();
    }

    public void destroy(){
        // Remove card from player's board
    }
}