package com.avatarduel.component;

/**
 * LandCard stores information that every land cards have
 * @see Card
 */
public class LandCard extends Card {
    /**
     * Creates a LandCard and stores it's information
     * @param _id Card's id
     * @param _name Card's name
     * @param ele Card's element
     * @param desc Card's description
     * @param path Path to where card's image is stored
     */
    public LandCard(int _id, String _name, String ele, String desc, String path){
        super(Card.LAND_CARD, _id, _name, ele, desc, path);
    }
}