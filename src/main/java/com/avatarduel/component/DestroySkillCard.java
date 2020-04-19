package com.avatarduel.component;

/**
 * DestroySkillCard stores the information each destroy skill cards share
 * @see SkillCard
 */
public class DestroySkillCard extends SkillCard {
    
    /**
     * Creates a new DestroySkillCard and stores their information
     * @param _id Card's id
     * @param _name Card's name
     * @param ele Card's element
     * @param desc Card's description
     * @param path The path to where the card's image is stored
     * @param pow Power value of card
     */
    public DestroySkillCard(int _id, String _name, String ele, String desc, String path, int pow){
        super(_id, _name, ele, desc, path, SkillCard.SKILL_DESTROY, pow);
    }
}