// File : AuraSkillCard.java
// Menyimpan informasi khusus kartu aura 

package com.avatarduel.component;

public class AuraSkillCard extends SkillCard {
    private int attack;
    private int defense;

    public AuraSkillCard(int _id, String _name, String ele, String desc, String path, int att, int def, int pow){
        super(_id, _name, ele, desc, path, SkillCard.SKILL_AURA, pow);
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
}