package com.avatarduel.component;

/**
 * CharacterCard stores information that every character cards have
 * @see Card
 */
public class CharacterCard extends Card {
    private int attack;
    private int defense;
    private int power;

    /**
     * Creates a blank CharacterCard
     */
    public CharacterCard(){
        super();
        attack = 0;
        defense = 0;
        power = 0;
    }
    
    /**
     * Creates a character card and stores their information
     * @param id Card's id
     * @param _name Card's name
     * @param ele Card's element
     * @param desc Card's description
     * @param path Path to where character's image is stored
     * @param att attack value of the card
     * @param def defense value of the card
     * @param pow power value of the card
     */
    public CharacterCard(int _id, String _name, String ele, String desc, String path, int att, int def, int pow){
        super(Card.CHARACTER_CARD, _id, _name, ele, desc, path);
        attack = att;
        defense = def;
        power = pow;
    }

    /**
     * Returns the CharacterCard's attack
     * @return character card's attack value
     */
    public int getAttack(){
        return attack;
    }

    /**
     * Sets the card's attack with a new value
     * @param attack new attack value
     */
    public void setAttack(int attack){
        this.attack = attack;
    }

    /**
     * Returns the CharacterCard's defense
     * @return character card's defense value
     */
    public int getDefense(){
        return defense;
    }

    /**
     * Sets the card's defense with a new value
     * @param def new defense value
     */
    public void setDefense(int def){
        this.defense = def;
    }

    /**
     * Returns the Power needed to summon CharacterCard
     * @return card's power value
     */
    public int getPower(){
        return power;
    }
}