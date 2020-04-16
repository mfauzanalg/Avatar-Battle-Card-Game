// File : PowerUpSkillCard.java
// Handles the behaviour of Power Up Card when played

package com.avatarduel.component;

public class PowerUpSkillCard extends SkillCard {

    public PowerUpSkillCard(int _id, String _name, String ele, String desc, String path){
        super(_id, _name, ele, desc, path, SkillCard.SKILL_POWERUP);
    }
}