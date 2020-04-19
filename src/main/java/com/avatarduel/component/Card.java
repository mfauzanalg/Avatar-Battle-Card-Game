//File : Card.java
// Menyimpan informasi umum kartu

package com.avatarduel.component;

public class Card {
    private String type;
    private int id;
    private String name;
    private String element;
    private String description;
    private String imagepath;
    private String place;
//    private int idx;
//    private int owner;
    public static final String CHARACTER_CARD = "character";
    public static final String SKILL_CARD = "skill";
    public static final String LAND_CARD = "land";
    public static final int NULL_ID = 0;

    public Card(){
        this.type = "";
        this.id = NULL_ID;
//        this.idx = -1;
        this.name = "";
        this.element = "";
        this.description = "";
        this.place = "";
//        this.owner = 0;
        this.imagepath = "src/main/resources/com/avatarduel/card/image/blank.png";
    }

    public Card(String _type, int _id, String _name, String ele, String desc, String path){
        type = _type;
        id = _id;
        name = _name;
        element = ele;
        description = desc;
        imagepath = path;
        this.place = "deck";
//        this.idx = -1;
//        this.owner = 0;
    }

//    public int getOwner(){
//        return owner;
//    }

//    public void setOwner(int owner){
//        this.owner = owner;
//    }

//    public int getIdx(){
//        return idx;
//    }

//    public void setIdx(int idx){
//        this.idx = idx;
//    }

    public String getPlace(){
        return place;
    }

    public void setPlace(String place){
        this.place = place;
    }

    public String getType(){
        return type;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getElement(){
        return element;
    }

    public String getDescription(){
        return description;
    }

    public String getImagePath(){
        return imagepath;
    }

    public void setImagepath(String path){
        this.imagepath = path;
    }


    // Card on layout
    public static Card cardHover = new Card();
    public static Card cardClick1 = new Card();
    public static int clickIdx = -1;
    public static int targetidx = -1;
    public static int atk = -1;
    public static int def = -1;
}