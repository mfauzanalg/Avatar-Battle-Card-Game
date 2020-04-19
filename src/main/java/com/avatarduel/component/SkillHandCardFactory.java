package com.avatarduel.component;

/**
 * SkillHandCardFactory is a factory method that returns Specific SkillCardFactories
 * @see HandCard
 * @see AuraHandCardFactory
 * @see DestroyHandCardFactory
 * @see PowerUpHandCardFactory
 * @see SkillCard
 */
public class SkillHandCardFactory {

    /**
     * Takes a SkillCard and checks the effect of said SkillCard.
     * Returns a factory corresponding to the effect of the SkillCard
     * @param card SkillCard to convert
     * @return HandCard corresponding to the SkillCard inputted
     */
    public static HandCard getSkillFactory(SkillCard card){
        HandCard retval = null;

        if (card.getEffect().equals(SkillCard.SKILL_AURA)){
            retval = new AuraHandCardFactory();
        }
        else if (card.getEffect().equals(SkillCard.SKILL_DESTROY)){
            retval = new DestroyHandCardFactory();
        }
        else if (card.getEffect().equals(SkillCard.SKILL_POWERUP)){
            retval = new PowerUpHandCardFactory();
        }

        return retval;
    }
}