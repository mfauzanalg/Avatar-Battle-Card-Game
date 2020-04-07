// File : CharacterHandCard.java
// Handles how the character card is summoned

package com.avatarduel.component;

public class CharacterHandCard implements IHandCard {
    CharacterCard kar;

    public CharacterHandCard(CharacterCard card){
        kar = card;
    }

    public CharacterCard getCharacterCard(){
        return kar;
    }

    public void play(){
        // Buat SummonedChar dengan objek ini sebagai parameter
        // Lalu tambahkan SummonedChar tersebut ke board 
        // Jangan lupa cek pilihan user apakah dia memilih posisi att/def dan apakah kartu dibuka / ditutup
    }
}