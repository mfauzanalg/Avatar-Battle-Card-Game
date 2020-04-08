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

    public Card(String _type, int _id, String _name, String ele, String desc, String path){
        type = _type;
        id = _id;
        name = _name;
        element = ele;
        description = desc;
        imagepath = path;
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


    // Card on layout
    public static Card cardHover;
    // Card on hand player 1
    public static Card onP1H1;
    public static Card onP1H2;
    public static Card onP1H3;
    public static Card onP1H4;
    public static Card onP1H5;
    public static Card onP1H6;
    public static Card onP1H7;
    public static Card onP1H8;
    public static Card onP1H9;

    // Card on arena player 1
    public static Card onP1A1;
    public static Card onP1A2;
    public static Card onP1A3;
    public static Card onP1A4;
    public static Card onP1A5;
    public static Card onP1A6;
    public static Card onP1A7;
    public static Card onP1A8;
    public static Card onP1A9;

    // Card on skill area player 1
    public static Card onP1S1;
    public static Card onP1S2;
    public static Card onP1S3;
    public static Card onP1S4;
    public static Card onP1S5;
    public static Card onP1S6;
    public static Card onP1S7;
    public static Card onP1S8;
    public static Card onP1S9;

    // Card on hand player 2
    public static Card onP2H1;
    public static Card onP2H2;
    public static Card onP2H3;
    public static Card onP2H4;
    public static Card onP2H5;
    public static Card onP2H6;
    public static Card onP2H7;
    public static Card onP2H8;
    public static Card onP2H9;

    // Card on arena player 2
    public static Card onP2A1;
    public static Card onP2A2;
    public static Card onP2A3;
    public static Card onP2A4;
    public static Card onP2A5;
    public static Card onP2A6;
    public static Card onP2A7;
    public static Card onP2A8;
    public static Card onP2A9;

    // Card on skill area player 2
    public static Card onP2S1;
    public static Card onP2S2;
    public static Card onP2S3;
    public static Card onP2S4;
    public static Card onP2S5;
    public static Card onP2S6;
    public static Card onP2S7;
    public static Card onP2S8;
    public static Card onP2S9;

}