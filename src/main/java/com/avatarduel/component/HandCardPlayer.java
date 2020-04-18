// File : HandCardPlayer.java
// Menerima HandCard dan mengubahnya menjadi BoardCard lalu meletakkannya di board untuk kartu yang menetap di board
// Menjalankan efek langsung untuk kartu yang tidak menetap di board (Contoh, LandCard dan DestroySkillCard)

package com.avatarduel.component;
import java.util.List;
import java.util.ArrayList;

public class HandCardPlayer {

    // Menerima CharacterHandCard dan boolean yang menunjukkan apakah kartu dalam posisi menyerang
    // Membuat SummonedCharacter dan menambahkannya ke board
    // Mungkin perlu idx board yang kosong dimana??
    public static void playCard(CharacterHandCard card, boolean attack){
        int currentElementPower = card.getOwner().getCurrentElement(card.getCardInstance().getElement());
        int requiredElementPower = ((CharacterCard)card.getCardInstance()).getPower();
        if (currentElementPower < requiredElementPower){
            System.out.println("You don't have enough power to summon + " + card.getCardInstance().getName());
        }
        else{

            SummonedCharacter chara = new SummonedCharacter(card.getOwner(), (CharacterCard) card.getCardInstance(), attack);
            int cidx = card.getOwner().getBoard().indexOf(NullCardHandler.getNullBoardCard());
            card.getOwner().getBoard().set(cidx, chara);  
        }
    }

    // Menerima AuraHandCard, dan kartu target
    // Me-replace board[idx] dengan kartu yang dipilih sebagai target
    public static void playCard(AuraHandCard card, BoardCard target){
        int currentElementPower = card.getOwner().getCurrentElement(card.getCardInstance().getElement());
        int requiredElementPower = ((SkillCard)card.getCardInstance()).getPower();
        if (currentElementPower < requiredElementPower){
            System.out.println("You don't have enough power to play + " + card.getCardInstance().getName());
        }
        else{
            AuraBoardCard aura = new AuraBoardCard(target, (AuraSkillCard) card.getCardInstance());
            int cidx = card.getOwner().getBoard().indexOf(target);
            int sidx = card.getOwner().getBoard().indexOf(NullCardHandler.getNullSkillCard());
            card.getOwner().getBoard().set(cidx, aura);
            card.getOwner().getSkillBoard().set(sidx, (SkillCard) card.getCardInstance()); // Nambahin kartu ke skillBoard
        }
    }

    // 11 12 sama Aura
    public static void playCard(PowerUpHandCard card, BoardCard target){
        int currentElementPower = card.getOwner().getCurrentElement(card.getCardInstance().getElement());
        int requiredElementPower = ((SkillCard)card.getCardInstance()).getPower();
        if (currentElementPower < requiredElementPower){
            System.out.println("You don't have enough power to play + " + card.getCardInstance().getName());
        }
        else{
            PowerUpBoardCard power = new PowerUpBoardCard(target, (PowerUpSkillCard) card.getCardInstance());
            int cidx = card.getOwner().getBoard().indexOf(target);
            int sidx = card.getOwner().getBoard().indexOf(NullCardHandler.getNullSkillCard());
            card.getOwner().getBoard().set(cidx, power);
            card.getOwner().getSkillBoard().set(sidx, (SkillCard) card.getCardInstance()); // Nambahin kartu ke skillBoard
        }
    }

    public static void playCard(BoardCard target){
        target.destroy();
    }

    public static void playCard(LandHandCard card){
        String element = card.getCardInstance().getElement();
        int valMax = card.getOwner().getMaxElement(element);
        int valCurr = card.getOwner().getCurrentElement(element);
        card.getOwner().setMaxElement(element, valMax + 1);
        card.getOwner().setCurrentElement(element, valCurr + 1);
    }
}