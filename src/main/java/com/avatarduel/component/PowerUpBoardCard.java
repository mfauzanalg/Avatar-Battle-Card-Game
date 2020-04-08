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

    public int getPositionValue(){
        return target.getPositionValue();
    }

    public void destroy(){
        // Remove card from player's board
    }
}