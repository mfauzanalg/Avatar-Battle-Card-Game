// File : AuraHandCard.java
// Handles the behaviour of Aura cards

public class AuraHandCard implements IHandCard, IDestructible {
    SummonedCharacter target;
    AuraSkillCard skill;

    public AuraHandCard(AuraSkillCard card){
        skill = card;
    }

    public void setTarget(ISummoned _target){
        target = _target;
    }

    public void play(){
        // Add this card to board
        target.addSkillCard(this);
        target.setAuraAttack(target.getAuraAttack() + skill.getAttack());
        target.setAuraDefense(target.getAuraDefense() + skill.getDefense());
    }

    public void destroy(){
        // remove card from board
    }
}