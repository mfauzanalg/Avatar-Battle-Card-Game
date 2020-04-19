package com.avatarduel.component;

/**
 * AuraHandCard represents AuraSkillCards that are currently in the player's hand
 * @see Player
 * @see Card
 * @see AuraSkillCard
 * @see IHandCard
 */
public class AuraHandCard implements IHandCard {
    private AuraSkillCard skill;
    private Player target;
    private boolean isOpen;

    /**
     * Creates a new AuraHandCard with the AuraSkillCard that is added to the player's hand as card, and said player as the owner
     * @param card The AuraSkillCard that will be added to the player's hand
     * @param _target The Player that owns the AuraSkillCard
     */
    public AuraHandCard(AuraSkillCard card, Player _target){
        skill = card;
        target = _target;
        isOpen = true;
    }

    /**
     * Returns the AuraSkillCard this class represents 
     * @return Card class that stores the info of the card this class represents
     */
    public Card getCardInstance(){
        return skill;
    }

    /**
     * Returns the current holder of this card
     * @return Owner of the AuraSkillCard
     */
    public Player getOwner(){
        return target;
    }

    /**
     * Changes the card's state from being revealed to closed, and vice versa
     */
    public void flip(){
        isOpen = !isOpen;
    }

    /**
     * Checks whether the card is currently being revealed or closed
     * @return true if the card is revealed, false otherwise
     */
    public boolean getIsOpen(){
        return isOpen;
    }
}