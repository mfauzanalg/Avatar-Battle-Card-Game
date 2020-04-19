package com.avatarduel.component;

import java.util.List;

/**
 * BoardCard is a class that serves as the interface for the class SummonedCharacter and it's decorator, SkillBoardCard.
 * BoardCard class and it's subclasses represents CharacterCards that is summoned to the player's board
 * @see SummonedCharacter
 * @see SkillBoardCard
 * @see ISummoned
 * @see IDestructible
 * @see Player
 */
abstract public class BoardCard implements ISummoned, IDestructible {
    protected Player owner;

    /**
     * Creates a BoardCard with the Player who owns this card as the owner
     * @param _owner The player who owns this card
     */
    public BoardCard(Player _owner){
        owner = _owner;
    }

    /**
     * Changes the card's position from attack position to defense and vice versa
     */
    abstract public void rotate();

    /**
     * Returns the owner of this card
     * @return Player who owns this card
     */
    public Player getOwner(){
        return owner;
    }

    /**
     * Returns the attack value of this card
     * @return Attack value of card
     */
    abstract public int getAttackValue();

    /**
     * Returns the defense value of this card
     * @return Attack value of card
     */
    abstract public int getDefenseValue();
    
    /**
     * Returns attack value if card is in attack position, defense value if is in defense position
     * @return value according to the card's current position
     */
    abstract public int getPositionValue();

    /**
     * Returns the CharacterCard this class represents
     * @return Card class that stores info about this card
     */
    abstract public Card getCardInstance();

    /**
     * Destroys this card and remove it from the board
     */
    abstract public void destroy();

    /**
     * Returns true if this card is equipped with a PowerUpSkillCard, false otherwise
     * @return true if PowerUpSkillCard is equipped, false otherwise
     */
    abstract public boolean getPowerUp();

    /**
     * Returns true if this card is in attack position, false otherwise
     * @return true if card is in attack position, false otherwise
     */
    abstract public boolean getAttackPos();

    /**
     * Change the card's status to have PowerUpSkillCard equipped / Don't have PowerUpSkillCard equipped
     * @param val boolean, true to set card to have PowerUpSkillCard, false otherwise
     */
    abstract public void setPowerUp(boolean val);

    /**
     * Change the card's current position
     * @param val true to change card to attack position, false to defense position
     */
    abstract public void setAttackPos(boolean val);

    /**
     * Add SkillCard as one of the CharacterCard's skills
     * @param skill the SkillCard to be added
     */
    abstract public void addSkillCard(SkillCard skill);

    /**
     * Get's the list of skills the CharacterCard owns
     * @return List of SkillCard
     */
    abstract public List<SkillCard> getSkills();

    /**
     * Removes one of the CharacterCard's skills
     * @param skill the skill to be removed
     */
    abstract public void removeSkill(SkillCard skill);

    /**
     * Sets the status of the CharacterCard to able to attack / unable to attack
     * @param canAttack true to enable card to attack, false otherwise
     */
    abstract public void setCanAttack(boolean canAttack);

    /**
     * Get's whether the CharacterCard can attack or not 
     * @return true if can attack, false otherwise
     */
    abstract public boolean getCanAttack();
}