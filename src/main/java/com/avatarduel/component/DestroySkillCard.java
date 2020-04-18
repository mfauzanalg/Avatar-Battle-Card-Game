// File : DestroySkillCard.java
// Handles the behaviour of Destroy Skill Card when played

package com.avatarduel.component;

public class DestroySkillCard extends SkillCard {
    
    public DestroySkillCard(int _id, String _name, String ele, String desc, String path, int pow){
        super(_id, _name, ele, desc, path, SkillCard.SKILL_DESTROY, pow);
    }
}