package com.avatarduel.component;

/**
 * AuraBoardCard serves as one of the concrete decorator of the class SummonedCharacter.
 * AuraBoardCard represents a SummonedCharacter that is equipped with an AuraSkillCard.
 * @see BoardCard
 * @see SummonedCharacter
 * @see AuraSkillCard
 * @see Player
 */
public class AuraBoardCard extends SkillBoardCard {
    BoardCard target;
    int attackVal;
    int defenseVal;

    /**
     * Creates a new AuraBoardCard with the user of the AuraSkillCard as the owner, the selected card in the board as target, and the AuraSkillCard played as card
     * @param owner The player that played the AuraSkillCard
     * @param _target The BoardCard selected as the target of the AuraSkillCard
     * @param card The AuraSkillCard that was played
     */
    public AuraBoardCard(Player owner, BoardCard _target, AuraSkillCard card){
        super(owner, _target, card);
        target = _target;
        attackVal = card.getAttack();
        defenseVal = card.getDefense();
    }

    /**
     * Returns the attack value of the card equipped with the AuraSkillCard
     */
    public int getAttackValue(){
        return attackVal + target.getAttackValue();
    }

    /**
     * Returns the defense value of the card equpped with the AuraSkillCard
     */
    public int getDefenseValue(){
        return defenseVal + target.getDefenseValue();
    }    
}