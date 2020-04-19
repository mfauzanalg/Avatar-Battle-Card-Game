package com.avatarduel.component;

/**
 * PowerUpHandCard represents PowerUpSkillCard in a player's hand
 * @see PowerUpSkillCard
 * @see Player
 * @see IHandCard
 */
public class PowerUpHandCard implements IHandCard {
    PowerUpSkillCard power;
    Player owner;
    boolean isOpen;

    /**
     * Creates a new PowerUpHandCard with the PowerUpSkillCard that is added to the player's hand as card, and said player as the owner
     * @param pow The PowerUpSkillCard that will be added to the player's hand
     * @param _owner The Player that owns the PowerUpSkillCard
     */
    public PowerUpHandCard(PowerUpSkillCard pow, Player _owner){
        power = pow;
        owner = _owner;
        isOpen = true;
    }

    /**
     * Returns the PowerUpSkillCard this card represents
     * @return Card class that stores info about this card
     */
    public Card getCardInstance(){
        return power;
    }

    /**
     * Returns the owner of this card
     * @return Player who owns this card
     */
    public Player getOwner(){
        return owner;
    }

    /**
     * Changes card from being revealed to closed and vice versa
     */
    public void flip(){
        isOpen = !isOpen;
    }

    /**
     * Checks whether the card is revealed or closed
     * @return true if card is revealed, false otherwise
     */
    public boolean getIsOpen(){
        return isOpen;
    }
}