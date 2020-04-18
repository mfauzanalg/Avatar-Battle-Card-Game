// File : NullBoardCard.java
// Mewakili tempat kosong di board

package com.avatarduel.component;

public class NullCardHandler {
    private static BoardCard nullBoardCard;
    private static SkillCard nullSkillCard;

    public static BoardCard getNullBoardCard(){
        if (nullBoardCard == null){
            nullBoardCard = new SummonedCharacter(null, new CharacterCard(), true);
        }
        return nullBoardCard;
    }

    public static SkillCard getNullSkillCard(){
        if (nullSkillCard == null){
            nullSkillCard = new SkillCard();
        }
        return nullSkillCard;
    }

    public static boolean isNull(BoardCard card){
        return card.getCardInstance().getId() == Card.NULL_ID;
    }

    public static boolean isNull (SkillCard card){
        return card.getId() == Card.NULL_ID;
    }
}