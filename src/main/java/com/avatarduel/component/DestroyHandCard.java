package com.avatarduel.component;

/**
 * DestroyHandCard represents DestroySkillCard in a player's hand
 * @see DestroySkillCard
 * @see Player
 * @see IHandCard
 * @see SummonedCharacter
 */
public class DestroyHandCard implements IHandCard {
    private SummonedCharacter target;
    private DestroySkillCard skill;
    private Player owner;
    private boolean isOpen;

    /**
     * Creates a new DestroyHandCard with the DestroySkillCard that is added to the player's hand as card, and said player as the owner 
     * @param card The DestroySkillCard that will be added to the player's hand
     * @param _target The player in question
     */
    public DestroyHandCard(DestroySkillCard card, Player _owner){
        skill = card;
        owner = _owner;
        isOpen = true;
    }

    /**
     * Sets the target to destroy
     * @param _target The BoardCard to destroy
     */
    public void setTarget(SummonedCharacter _target){
        target = _target;
    }

    /**
     * Returns the DestroySkillCard this card represents
     * @return DestroySkillCard
     */
    public Card getCardInstance(){
        return skill;
    }

    /**
     * Returns the owner of this card
     * @return
     */
    public Player getOwner(){
        return owner;
    }

    /**
     * Changes the card's state from being revealed to closed and vice versa
     */
    public void flip(){
        isOpen = !isOpen;
    }

    /**
     * Returns the card's current state in hand
     * @return true if the card is revealed, false otherwise
     */
    public boolean getIsOpen(){
        return isOpen;
    }
}