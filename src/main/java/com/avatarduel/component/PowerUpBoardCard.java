package com.avatarduel.component;

/**
 * PowerUpBoardCard is one of the concrete decorator for SummonedCharacter
 * PowerUpBoardCard represents SummonedCharacter equipped with PowerUpSkillCard
 * @see BoardCard
 * @see SkillBoardCard
 * @see SummonedCharacter
 */
public class PowerUpBoardCard extends SkillBoardCard {
    BoardCard target;

    /**
     * Creates a new PowerUpBoardCard with the user of the PowerUpSkillCard as the owner, the selected card in the board as target, and the PowerUpSkillCard played as card
     * @param owner The player that played the PowerUpSkillCard
     * @param _target The BoardCard selected as the target of the PowerUpSkillCard
     * @param card The PowerUpSkillCard that was played
     */
    public PowerUpBoardCard(Player owner, BoardCard _target, PowerUpSkillCard card){
        super(owner, _target, card);
        target = _target;
        target.setPowerUp(true);
    }

    /**
     * Returns the attack value of the card equipping this card
     * @return attack value of equipping card
     */
    public int getAttackValue(){
        return target.getAttackValue();
    }

    /**
     * Returns the defense value of the card equipping this card
     * @return defense value of equipping card
     */
    public int getDefenseValue(){
        return target.getDefenseValue();
    }
}