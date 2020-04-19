package com.avatarduel.component;

/**
 * AuraSkillCard stores the information of the AuraSkillCards
 * @see SkillCard
 */
public class AuraSkillCard extends SkillCard {
    private int attack;
    private int defense;

    /**
     * Creates a new AuraSkillCard and stores it's information
     * @param _id The id of the card
     * @param _name The name of the card
     * @param ele The card's element
     * @param desc The card's description
     * @param path The path where the card's image is stored
     * @param att Attack value of the card
     * @param def Defense value of the card
     * @param pow Power value of the card
     */
    public AuraSkillCard(int _id, String _name, String ele, String desc, String path, int att, int def, int pow){
        super(_id, _name, ele, desc, path, SkillCard.SKILL_AURA, pow);
        attack = att;
        defense = def;
        power = pow;
    }

    /**
     * Returns the attack value of the AuraSkillCard
     * @return AuraSkillCard's attack value
     */
    public int getAttack(){
        return attack;
    }

    /**
     * Returns the defense value of the AuraSkillCard
     * @return AuraSkillCard's defense value
     */
    public int getDefense(){
        return defense;
    }
}