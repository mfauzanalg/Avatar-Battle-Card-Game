// File : HandCardPlayer.java
// Menerima HandCard dan mengubahnya menjadi BoardCard lalu meletakkannya di board untuk kartu yang menetap di board
// Menjalankan efek langsung untuk kartu yang tidak menetap di board (Contoh, LandCard dan DestroySkillCard)

package com.avatarduel.component;

public class HandCardPlayer {

    // Menerima CharacterHandCard dan boolean yang menunjukkan apakah kartu dalam posisi menyerang
    // Membuat SummonedCharacter dan menambahkannya ke board
    // Mungkin perlu idx board yang kosong dimana??
    public static void playCard(CharacterHandCard card, boolean attack){
        SummonedCharacter chara = new SummonedCharacter(card.getOwner(), (CharacterCard) card.getCardInstance(), attack);
        //card.getOwner().getBoard().add(chara);  // Nambahin kartu ke board, nunggu method nambahin di Player 
    }

    // Menerima AuraHandCard, kartu target, dan index tempat target berada di board
    // Me-replace board[idx] dengan kartu yang dipilih sebagai target
    public static void playCard(AuraHandCard card, BoardCard target, int idx){
        AuraBoardCard aura = new AuraBoardCard(target, (AuraSkillCard) card.getCardInstance());
        // card.getOwner().getBoard().set(idx, aura) // Replace kartu ke board[idx]
        // card.getOwner().getBoard().add(card.getCardInstance()); // Nambahin kartu ke skillBoard
    }

    // 11 12 sama Aura
    public static void playCard(PowerUpHandCard card, BoardCard target, int idx){
        PowerUpBoardCard power = new PowerUpBoardCard(target, (PowerUpSkillCard) card.getCardInstance());
        // card.getOwner().getBoard().set(idx, power) // Replace kartu ke board[idx]
        // card.getOwner().getBoard().add(card.getCardInstance()); // Nambahin kartu ke skillBoard
    }

    public static void playCard(DestroyHandCard card, BoardCard target){
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