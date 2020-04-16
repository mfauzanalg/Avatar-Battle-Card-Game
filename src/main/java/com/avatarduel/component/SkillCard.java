// File : SkillCard.java
// Menyimpan informasi kartu skill 

package com.avatarduel.component;

public class SkillCard extends Card {
    String effect;
    public static final String SKILL_AURA = "aura";
    public static final String SKILL_DESTROY = "destroy";
    public static final String SKILL_POWERUP = "powerup";

    public SkillCard(int _id, String _name, String ele, String desc, String path, String eff){
        super(Card.SKILL_CARD, _id, _name, ele, desc, path);
        effect = eff;
    }

    public String getEffect(){
        return effect;
    }
}