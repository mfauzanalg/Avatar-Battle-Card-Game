package com.avatarduel.component;

/**
 * PowerUpSkillCard stores information that every PowerUpSkillCard has
 */
public class PowerUpSkillCard extends SkillCard {

    /**
     * Creates a new AuraSkillCard and stores it's information
     * @param _id The id of the card
     * @param _name The name of the card
     * @param ele The card's element
     * @param desc The card's description
     * @param path The path where the card's image is stored
     * @param pow Power value of the card
     */
    public PowerUpSkillCard(int _id, String _name, String ele, String desc, String path, int pow){
        super(_id, _name, ele, desc, path, SkillCard.SKILL_POWERUP, pow);
    }
}