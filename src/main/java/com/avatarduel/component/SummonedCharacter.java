// File : SummonedCharacter.java
// Handles the behaviour of summoned characters
import java.util.List;
import java.util.ArrayList;

public class SummonedCharacter implements ISummoned, IDestructible {
    List<IDestructible> skillCards;
    CharacterCard summon;
    int auraAttack;
    int auraDefense;
    boolean isOpen;
    boolean attackPos;
    boolean isPoweredUp;

    public SummonedCharacter(CharacterCard m, boolean open, boolean attack){
        summon = m;
        isOpen = open;
        attackPos = attack;
        auraAttack = 0;
        auraDefense = 0;
        isPoweredUp = false;
        skillCards = new ArrayList<IDestructible>();
    }

    public boolean flip(){
        boolean retval = !isOpen;
        isOpen = true;
        return retval;
    }

    public void rotate(){
        attackPos = !attackPos;
    }

    public int getPositionValue(){
        return (attackPos) ? (summon.getAttack() + auraAttack) : (summon.getDefense() + auraDefense);
    }

    public boolean getPowerUp(){
        return isPoweredUp;
    }

    public int getAuraAttack(){
        return auraAttack;
    }

    public int getAuraDefense(){
        return auraDefense;
    }

    public void setAuraAttack(int val){
        auraAttack = val;
    }

    public void setAuraDefense(int val){
        auraDefense = val;
    }

    public void setPowerUp(boolean val){
        isPoweredUp = val;
    }

    public void addSkillCard(IDestructible card){
        skillCards.add(card);
    }

    public void render(){
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
    }

    public void destroy(){
        // Remove this card from board and power ups added to this card
        for (IDestructible card : skillCards){
            card.destroy();
        }
        skillCards.clear(); 
        // Sorry ku belum pelajarin kode boardnya
    }
}