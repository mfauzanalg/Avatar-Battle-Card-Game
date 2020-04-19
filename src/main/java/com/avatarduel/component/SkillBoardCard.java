package com.avatarduel.component;

/**
 * SkillBoardCard is an abstract decorator for SummonedChar
 * SkillBoardCard represents BoardCard that is equipped with a SkillCard
 * @see BoardCard
 * @see SummonedCharacter
 * @see SkillCard
 */
import java.util.List;

abstract public class SkillBoardCard extends BoardCard {
    BoardCard target;
    SkillCard card;

    /**
     * Creates a new SkillBoardCard with the user of the SkillCard as the owner, the selected card in the board as target, and the SkillCard played as card.
     * Adds SkillCard to target's list of skills
     * @param owner The player that played the SkillCard
     * @param _target The BoardCard selected as the target of the SkillCard
     * @param card The SkillCard that was played
     */
    public SkillBoardCard(Player owner, BoardCard target, SkillCard _card){
        super(owner);
        this.target = target;
        card = _card;
        target.addSkillCard(_card);
    }

    /**
     * Returns the attack value of the SummonedCharacter + bonuses it gets from skills
     * @return Character card attack value + skill card bonuses
     */
    abstract public int getAttackValue();

    /**
     * Returns the defense value of the SummonedCharacter + bonuses it gets from skills
     * @return Character card defense value + skill card bonuses
     */
    abstract public int getDefenseValue();

    /**
     * Returns attack if card is in attack position, defense if is in defense position
     * @return attack value if in attack position, defense value otherwise
     */
    public int getPositionValue(){
        return (target.getAttackPos()) ? getAttackValue() : getDefenseValue();
    }

    /**
     * Returns info of character card equipping this card
     * @return Card class that stores info about character card
     */
    public Card getCardInstance(){
        return target.getCardInstance();
    }

    /**
     * Returns info this skill card
     * @return SkillCard class that stores info about skill card
     */
    public SkillCard getSkillCardInstance(){
        return card;
    }

    /**
     * Change card from attack position to defense position and vice versa
     */
    public void rotate(){
        target.rotate();
    }

    /**
     * Remove this card from the owner's skill board and remove skill from target's list of skills.
     * And then destroy target
     */
    public void destroy(){
        // remove the card from player's board
        int sidx = this.owner.getSkillBoard().indexOf(this.getSkillCardInstance());
        this.owner.getSkillBoard().set(sidx, NullCardHandler.getNullSkillCard());
        target.removeSkill(this.getSkillCardInstance());
        int cidx = target.owner.getBoard().indexOf(this);
        target.owner.getBoard().set(cidx, target);
        target.destroy();
    }

    /**
     * Checks whether target have PowerUpSkillCard equipped or not
     * @return true if PowerUpSkillCard is equipped, false otherwise
     */
    public boolean getPowerUp(){
        return target.getPowerUp();
    }

    /**
     * Checks whether target is in attack position
     * @return true if is in attack position, false otherwise
     */
    public boolean getAttackPos(){
        return target.getAttackPos();
    }

    /**
     * Set power up status on target
     * @param val true to set target to have PowerUp false to not
     */
    public void setPowerUp(boolean val){
        target.setPowerUp(val);
    }

    /**
     * Sets target position
     * @param val true to set to attack position, false otherwise
     */
    public void setAttackPos(boolean val){
        target.setAttackPos(val);
    }

    /**
     * Adds skill card to target's list of skill
     * @param skill Skill card to be added
     */
    public void addSkillCard(SkillCard skill){
        target.addSkillCard(skill);
    }

    /**
     * Gets target's list of skills
     * @return List of SkillCard
     */
    public List<SkillCard> getSkills(){
        return target.getSkills();
    }

    /**
     * Removes a SkillCard in board
     * @param card SkillCard to remove
     */
    public void removeSkill(SkillCard card){
        target.removeSkill(card);
    }

    /**
     * Sets target's can attack value
     * @param canAttack true to enable attack, false otherwise
     */
    public void setCanAttack(boolean canAttack){ target.setCanAttack(canAttack);}

    /**
     * Checks whether target can attack or not
     * @return true if can attack, false otherwise
     */
    public boolean getCanAttack(){return target.getCanAttack();}
}