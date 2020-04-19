package com.avatarduel.component;
import java.util.List;
import java.util.ArrayList;

/**
 * HandCardPlayer is a class that handles how a IHandCard gets turned into a BoardCard and their addition to the board
 * @see IHandCard
 * @see BoardCard
 */
public class HandCardPlayer {

    /**
     * Takes a CharacterHandCard and whether they're in attack position or not and creates a SummonedCharacter and adds it to the CharacterHandCard's owner's board.
     * Also the decreases the player's Power according to the cards element.
     * @param card The CharacterHandCard to be played
     * @param attack true if the Character is being summoned in attack position, false otherwise
     */
    public static void playCard(CharacterHandCard card, boolean attack){

        SummonedCharacter chara = new SummonedCharacter(card.getOwner(), (CharacterCard) card.getCardInstance(), attack);
        int cidx = card.getOwner().getBoard().indexOf(NullCardHandler.getNullBoardCard());
        decreaseUserPower(card);
        card.getOwner().getBoard().set(cidx, chara);  
    }

    /**
     * Takes a AuraHandCard and the target of the AuraHandCard's effect.
     * Adds the AuraSkillCard to the AuraHandCard's owner's skill board.
     * Creates an AuraBoardCard that wraps the target and add it to the target's owner's board.
     * Also the decreases the player's Power according to the cards element.
     * @param card AuraHandCard played
     * @param target BoardCard targeted
     */
    public static void playCard(AuraHandCard card, BoardCard target){
        
        AuraBoardCard aura = new AuraBoardCard(card.getOwner(), target, (AuraSkillCard) card.getCardInstance());
        int cidx = target.getOwner().getBoard().indexOf(target);
        int sidx = card.getOwner().getSkillBoard().indexOf(NullCardHandler.getNullSkillCard());
        decreaseUserPower(card);
        target.getOwner().getBoard().set(cidx, aura);
        card.getOwner().getSkillBoard().set(sidx, (SkillCard) card.getCardInstance()); // Nambahin kartu ke skillBoard
    }

    /**
     * Takes a PowerUpHandCard and the target of the PowerUpHandCard's effect.
     * Adds the PowerUpSkillCard to the PowerUpHandCard's owner's skill board.
     * Creates an PowerUpBoardCard that wraps the target and add it to the target's owner's board.
     * Also the decreases the player's Power according to the cards element.
     * @param card PowerUpHandCard played
     * @param target BoardCard targeted
     */
    public static void playCard(PowerUpHandCard card, BoardCard target){
        
        PowerUpBoardCard power = new PowerUpBoardCard(card.getOwner(), target, (PowerUpSkillCard) card.getCardInstance());
        int cidx = target.getOwner().getBoard().indexOf(target);
        int sidx = card.getOwner().getSkillBoard().indexOf(NullCardHandler.getNullSkillCard());
        decreaseUserPower(card);
        target.getOwner().getBoard().set(cidx, power);
        card.getOwner().getSkillBoard().set(sidx, (SkillCard) card.getCardInstance()); // Nambahin kartu ke skillBoard
    }

    /**
     * Takes a DestroyHandCard and target of DestroyHandCard's effect
     * Decreases the player's Power according to the cards element and destroys the target
     * @param card DestroyHandCard being played
     * @param target BoardCard to destroy
     */
    public static void playCard(DestroyHandCard card, BoardCard target){
        decreaseUserPower(card);
        target.destroy();
    }

    /**
     * Takes a LandHand Card and adds the player's max and currentelement according to the card's element
     * @param card LandHandCard being played
     */
    public static void playCard(LandHandCard card){
        String element = card.getCardInstance().getElement();
        int valMax = card.getOwner().getMaxElement(element);
        int valCurr = card.getOwner().getCurrentElement(element);
        card.getOwner().setMaxElement(element, valMax + 1);
        card.getOwner().setCurrentElement(element, valCurr + 1);
    }

    /**
     * Checks whether the player has enough power to play a card
     * @param card card to be played
     * @return true if player can play the card, false otherwise
     */
    public static boolean validatePlay(IHandCard card){
        int currentElementPower = card.getOwner().getCurrentElement(card.getCardInstance().getElement());
        int requiredElementPower = 0;
        if (card.getCardInstance().getType().equals(Card.CHARACTER_CARD)){
            requiredElementPower = ((CharacterCard)card.getCardInstance()).getPower();
        }
        else if (card.getCardInstance().getType().equals(Card.SKILL_CARD)){ 
            requiredElementPower = ((SkillCard)card.getCardInstance()).getPower();
        }
        return currentElementPower >= requiredElementPower;
    }

    /**
     * Decreases player's power according to the card they played
     * @param card card played
     */
    public static void decreaseUserPower(IHandCard card){
        int currentElementPower = card.getOwner().getCurrentElement(card.getCardInstance().getElement());
        int requiredElementPower = 0;
        if (card.getCardInstance().getType().equals(Card.CHARACTER_CARD)){
            requiredElementPower = ((CharacterCard)card.getCardInstance()).getPower();
        }
        else if (card.getCardInstance().getType().equals(Card.SKILL_CARD)){ 
            requiredElementPower = ((SkillCard)card.getCardInstance()).getPower();
        }
        card.getOwner().setCurrentElement(card.getCardInstance().getElement(), currentElementPower - requiredElementPower);
    }
}