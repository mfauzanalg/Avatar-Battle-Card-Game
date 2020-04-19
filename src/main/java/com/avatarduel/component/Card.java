package com.avatarduel.component;

/**
 * The card class stores basic info that all cards have
 * @see CharacterCard
 * @see SkillCard
 * @see LandCard
 */
public class Card {
    private String type;
    private int id;
    private String name;
    private String element;
    private String description;
    private String imagepath;
    private String place;

    /**
     * Creates a blank card
     */
    public Card(){
        this.type = "";
        this.id = NULL_ID;
        this.name = "";
        this.element = "";
        this.description = "";
        this.place = "";
        this.imagepath = "src/main/resources/com/avatarduel/card/image/blank.png";
    }

    /**
     * Creates a card and stores it's information
     * @param _type The card's type, character card, skill card, or land card
     * @param _id The id of the card
     * @param _name The card's name
     * @param ele The card's element
     * @param desc The card's description
     * @param path The path to where the card's image is stored
     */
    public Card(String _type, int _id, String _name, String ele, String desc, String path){
        type = _type;
        id = _id;
        name = _name;
        element = ele;
        description = desc;
        imagepath = path;
        this.place = "deck";
    }

    public String getPlace(){
        return place;
    }

    public void setPlace(String place){
        this.place = place;
    }

    /**
     * Returns the type of the card, can be either character, skill, or land
     * @return type of the card
     */
    public String getType(){
        return type;
    }

    /**
     * Returns the id of the card
     * @return Card's id
     */
    public int getId(){
        return id;
    }

    /**
     * Returns the name of the card
     * @return Card's name
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the element of the card
     * @return Card's element
     */
    public String getElement(){
        return element;
    }

    /**
     * Return's the card's description
     * @return Card's description
     */
    public String getDescription(){
        return description;
    }

    /**
     * Return's the card's imagepath
     * @return Card's imagepath
     */
    public String getImagePath(){
        return imagepath;
    }

    /**
     * Sets the card's imagepath
     * @param path new imagepath
     */
    public void setImagepath(String path){
        this.imagepath = path;
    }

    public static final String CHARACTER_CARD = "character";
    public static final String SKILL_CARD = "skill";
    public static final String LAND_CARD = "land";
    public static final int NULL_ID = 0;
    public static Card cardHover = new Card();
    public static Card cardClick1 = new Card();
    public static int clickIdx = -1;
    public static int atk = -1;
    public static int def = -1;
    public static int src;
    public static int trg;
    public static int cardOwner;
}