package com.avatarduel.component;

// File : SummonedCharacter.java
// Handles the behaviour of summoned characters
import java.util.List;
import java.util.ArrayList;

public class SummonedCharacter extends BoardCard {
    CharacterCard summon;

    public SummonedCharacter(Player owner, CharacterCard m, boolean open, boolean attack){
        super(owner, open, attack);
        summon = m;
    }

    public int getPositionValue(){
        return (attackPos) ? summon.getAttack() : summon.getDefense();
    }

    /*public void render(){
        System.out.print("Character " + summon.getName() + " dalam keadaan ");
        if (isOpen){
            System.out.print("terbuka ");
        }
        else{
            System.out.print("tertutup ");
        }
        System.out.print("dengan posisi ");

        if(attackPos){
            System.out.println("menyerang");
        }
        else{
            System.out.println("bertahan");
        }
    }*/

    public void destroy(){
        // Remove this card from board
        // Plan : Decorator akan dipanggil destroynya lalu akan memanggil destroy BoardCard yang mereka wrap
        // Karna struktur pasti Decorator(Decorator(Decorator.......(SummonedCharacter)))...) maka SummonedCharacter pasti yang terakhir harus di destroy
        // Sehingga destroy milik SummonedCharacter tidak perlu memanggil method destroy lainnya
    }
}