package com.avatarduel.component;

/**
 * SkillCard stores information all skill cards have
 */
public class SkillCard extends Card {
    String effect;
    int power;
    public static final String SKILL_AURA = "aura";
    public static final String SKILL_DESTROY = "destroy";
    public static final String SKILL_POWERUP = "powerup";

    /**
     * Creates a blank skill card
     */
    public SkillCard(){
        super();
        effect = "";
        power = 0;
    }

    /**
     * Creates a SkillCard and stores it's info
     * @param _id Card's id
     * @param _name Card's name
     * @param ele Card's element
     * @param desc Card's description
     * @param path Path to where Card's image is stored
     * @param eff Skill effect, can be aura, destroy or power up
     * @param pow Power needed to play card
     */
    public SkillCard(int _id, String _name, String ele, String desc, String path, String eff, int pow){
        super(Card.SKILL_CARD, _id, _name, ele, desc, path);
        effect = eff;
        power = pow;
    }

    /**
     * Return card's effect
     * @return SkillCard.SKILL_AURA, SkillCard.SKILL_DESTROY, SkillCard.SKILL_POWERUP
     */
    public String getEffect(){
        return effect;
    }

    /**
     * Return's card's power value
     * @return Power needed to play card
     */
    public int getPower(){
        return power;
    }
}