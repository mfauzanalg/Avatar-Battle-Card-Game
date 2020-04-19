package com.avatarduel.component;

import java.util.List;
import java.util.ArrayList;

/**
 * SummonedCharacter is a class representing Characters summoned to the board
 * @see BoardCard
 * @see CharacterCard
 * @see SkillCard
 * @see Player
 */
public class SummonedCharacter extends BoardCard {
    protected List<SkillCard> skills = new ArrayList<SkillCard>();
    CharacterCard summon;
    protected int attackLost;
    protected int defenseLost;
    protected boolean attackPos;
    protected boolean isPoweredUp;
    protected boolean canAttack;

    /**
     * Creates a SummonedCharacter with the summoner as owner, CharacterCard summoned as summon, and boolean that represents the card's position
     * @param owner The summoner of the card
     * @param m Character card summoned
     * @param attack true if is summoned in attack position, false otherwise
     */
    public SummonedCharacter(Player owner, CharacterCard m, boolean attack){
        super(owner);
        summon = m;
        attackPos = attack;
        isPoweredUp = false;
        attackLost = 0;
        defenseLost = 0;
    }

    /**
     * Returns the card's attack value.
     * If card loses some skill cards without being destroyed, decrease the attack by the lost Skill card's attack.
     * @return card's attack value
     */
    public int getAttackValue(){
        return summon.getAttack() - attackLost;
    }

    /**
     * Returns the card's defense value.
     * If card loses some skill cards without being destroyed, decrease the defense by the lost Skill card's defense.
     * @return card's defense value
     */
    public int getDefenseValue(){
        return summon.getDefense() - defenseLost;
    }

    /**
     * Returns attack if card is in attack position, defense otherwise
     * @return attackvalue if card is in attack position, defense if in defense
     */
    public int getPositionValue(){
        return (attackPos) ? getAttackValue() : getDefenseValue();
    }

    /**
     * Returns the Character card this card represents
     * @return Card class that stores info about character card
     */
    public Card getCardInstance(){
        return summon;
    }

    /**
     * Changes card's position to attack position from defense position and vice versa
     */
    public void rotate(){
        boolean temp = attackPos;
        attackPos = !temp;
    }

    /**
     * Checks whether the character card has PowerUpSkillCard equipped
     * @return true if it has, false otherwise
     */
    public boolean getPowerUp(){
        return isPoweredUp;
    }

    /**
     * Gets card's current position
     * @return true if card is in attack position, false otherwise
     */
    public boolean getAttackPos(){
        return attackPos;
    }

    /**
     * Sets card's PowerUp
     * @param val new PowerUp val
     */
    public void setPowerUp(boolean val){
        isPoweredUp = val;
    }

    /**
     * Sets card's position
     * @param val true to set to attack position, false to defense position
     */
    public void setAttackPos(boolean val){
        attackPos = val;
    }

    /**
     * Add's skill to CharacterCard's list of skills
     * @param skill SkillCard to add
     */
    public void addSkillCard(SkillCard skill){
        skills.add(skill);
    }

    /**
     * Returns character card's list of skills
     * @return List of SkillCard
     */
    public List<SkillCard> getSkills(){
        return skills;
    }

    /**
     * Sets this card's ablity to attack
     * @param canAttack true to set to able to attack, false to set to unable
     */
    public void setCanAttack(boolean canAttack) {
        this.canAttack = canAttack;
    }

    /**
     * Returns card's ability to attack
     */
    public boolean getCanAttack(){
        return this.canAttack;
    }

    /**
     * Remove this card from board
     */
    public void destroy(){
        // Remove this card from board
        // Plan : Decorator akan dipanggil destroynya lalu akan memanggil destroy BoardCard yang mereka wrap
        // Karna struktur pasti Decorator(Decorator(Decorator.......(SummonedCharacter)))...) maka SummonedCharacter pasti yang terakhir harus di destroy
        // Sehingga destroy milik SummonedCharacter tidak perlu memanggil method destroy lainnya
        int cidx = this.owner.getBoard().indexOf(this);
        this.owner.getBoard().set(cidx, NullCardHandler.getNullBoardCard());
    }

    /**
     * Remove one of character card's skill from list of skills
     * @param card SkillCard to remove
     */
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