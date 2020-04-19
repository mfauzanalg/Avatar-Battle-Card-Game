package com.avatarduel.component;

// File : SummonedCharacter.java
// Handles the behaviour of summoned characters
import java.util.List;
import java.util.ArrayList;

public class SummonedCharacter extends BoardCard {
    protected List<SkillCard> skills = new ArrayList<SkillCard>();
    CharacterCard summon;
    protected int attackLost;
    protected int defenseLost;
    protected boolean attackPos;
    protected boolean isPoweredUp;

    public SummonedCharacter(Player owner, CharacterCard m, boolean attack){
        super(owner);
        summon = m;
        attackPos = attack;
        isPoweredUp = false;
        attackLost = 0;
        defenseLost = 0;
    }

    public int getAttackValue(){
        return summon.getAttack() - attackLost;
    }

    public int getDefenseValue(){
        return summon.getDefense() - defenseLost;
    }

    public int getPositionValue(){
        return (attackPos) ? getAttackValue() : getDefenseValue();
    }

    public Card getCardInstance(){
        return summon;
    }

    public void rotate(){
        attackPos = !attackPos;
    }

    public boolean getPowerUp(){
        return isPoweredUp;
    }

    public boolean getAttackPos(){
        return attackPos;
    }

    public void setPowerUp(boolean val){
        isPoweredUp = val;
    }

    public void setAttackPos(boolean val){
        attackPos = val;
    }

    public void addSkillCard(SkillCard skill){
        skills.add(skill);
    }

    public List<SkillCard> getSkills(){
        return skills;
    }
    
    public void destroy(){
        // Remove this card from board
        // Plan : Decorator akan dipanggil destroynya lalu akan memanggil destroy BoardCard yang mereka wrap
        // Karna struktur pasti Decorator(Decorator(Decorator.......(SummonedCharacter)))...) maka SummonedCharacter pasti yang terakhir harus di destroy
        // Sehingga destroy milik SummonedCharacter tidak perlu memanggil method destroy lainnya
        int cidx = this.owner.getBoard().indexOf(this);
        this.owner.getBoard().set(cidx, NullCardHandler.getNullBoardCard());
    }

    public void removeSkill(SkillCard card){
        skills.remove(card);
        if (card.getEffect().equals(SkillCard.SKILL_AURA)){
            attackLost += ((AuraSkillCard) card).getAttack();
            defenseLost += ((AuraSkillCard) card).getDefense();
        }
        else if (card.getEffect().equals(SkillCard.SKILL_POWERUP)){
            boolean found = false;
            for (SkillCard skill : skills){
                if (skill.getEffect().equals(SkillCard.SKILL_POWERUP)){
                    found = true;
                    break;
                }
            }
            isPoweredUp = found;
        }
    }
}