// File : CharacterHandCard.java
// Handles how the character card is summoned

package com.avatarduel.component;

public class CharacterHandCard implements IHandCard {
    CharacterCard kar;
    Player target;

    public CharacterHandCard(CharacterCard card, Player _target){
        kar = card;
        target = target;
    }

    public Card getCardInstance(){
        return kar;
    }

    public Player getOwner(){
        return target;
    }

    public void play(){
        // Buat SummonedChar dengan objek ini sebagai parameter
        // Lalu tambahkan SummonedChar tersebut ke board milik player
        // Jangan lupa cek pilihan user apakah dia memilih posisi att/def dan apakah kartu dibuka / ditutup
    }
}