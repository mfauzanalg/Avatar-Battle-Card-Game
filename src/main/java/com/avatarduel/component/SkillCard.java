// File : SkillCard.java
// Menyimpan informasi kartu skill 

package com.avatarduel.component;

public class SkillCard extends Card {
    String effect;
    int power;
    public static final String SKILL_AURA = "aura";
    public static final String SKILL_DESTROY = "destroy";
    public static final String SKILL_POWERUP = "powerup";

    public SkillCard(){
        super();
        effect = "";
        power = 0;
    }

    public SkillCard(int _id, String _name, String ele, String desc, String path, String eff, int pow){
        super(Card.SKILL_CARD, _id, _name, ele, desc, path);
        effect = eff;
        power = pow;
    }

    public String getEffect(){
        return effect;
    }

    public int getPower(){
        return power;
    }
}