// File : AuraSkillCard.java
// Menyimpan informasi khusus kartu aura 

public class AuraSkillCard extends SkillCard {
    private int attack;
    private int defense;
    private int power;

    public AuraSkillCard(int _id, String _name, String ele, String desc, String path, int att, int def, int pow){
        super(_id, _name, ele, desc, path, "aura");
        attack = att;
        defense = def;
        power = pow;
    }

    public int getAttack(){
        return attack;
    }

    public int getDefense(){
        return defense;
    }

    public int getPower(){
        return power;
    }
}