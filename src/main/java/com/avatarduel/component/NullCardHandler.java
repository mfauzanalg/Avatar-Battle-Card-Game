package com.avatarduel.component;

/**
 * NullCardHandler creates a NullObject for the player's board and skillBoard
 * @see Player
 */
public class NullCardHandler {
    private static BoardCard nullBoardCard;
    private static SkillCard nullSkillCard;

    /**
     * If an instance of nullBoardCard does not exist, create one. Return an instance of nullBoardCard
     * @return BoardCard that represents null
     */
    public static BoardCard getNullBoardCard(){
        if (nullBoardCard == null){
            nullBoardCard = new SummonedCharacter(null, new CharacterCard(), true);
        }
        return nullBoardCard;
    }

    /**
     * If an instance of nullSkillCard does not exist, create one. Return an instance of nullSkillCard
     * @return SkillCard that represents null
     */
    public static SkillCard getNullSkillCard(){
        if (nullSkillCard == null){
            nullSkillCard = new SkillCard();
        }
        return nullSkillCard;
    }

    /**
     * Checks whether a card is a BoardCard that represents null or not
     * @param card BoardCard to be checked
     * @return true if it is the BoardCard that represents null, false otherwise
     */
    public static boolean isNull(BoardCard card){
        return card.getCardInstance().getId() == Card.NULL_ID;
    }

    /**
     * Checks whether a SkillCard is a SkillCard that represents null or not
     * @param card SkillCard to be checked
     * @return true if it represents null, false otherwise
     */
    public static boolean isNull (SkillCard card){
        return card.getId() == Card.NULL_ID;
    }
}