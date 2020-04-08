// File : CharacterHandCard.java
// Handles how the character card is summoned

package com.avatarduel.component;

public class CharacterHandCard implements IHandCard {
    CharacterCard kar;
    Player target;
    boolean isOpen;

    public CharacterHandCard(CharacterCard card, Player _target){
        kar = card;
        target = target;
        isOpen = true;
    }

    public Card getCardInstance(){
        return kar;
    }

    public Player getOwner(){
        return target;
    }

    public void flip(){
        isOpen = !isOpen;
    }

    public boolean getIsOpen(){
        return isOpen;
    }

    public void play(){
        // Buat SummonedChar dengan objek ini sebagai parameter
        // Lalu tambahkan SummonedChar tersebut ke board milik player
        // Jangan lupa cek pilihan user apakah dia memilih posisi att/def dan apakah kartu dibuka / ditutup
        // kayaknya character card gak bisa implementasi ini, harus bikin method kayak, play(boolean isOpen, boolean attackPos)
    }
}