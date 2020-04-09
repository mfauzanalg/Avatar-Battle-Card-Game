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

    public Card(){
        this.type = "";
        this.id = 0;
        this.name = "";
        this.element = "";
        this.description = "";
        this.imagepath = "src/main/resources/com/avatarduel/card/image/blank.png";
    }

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
    public static Card cardHover = new Card();

//    // Card on hand player 1
//    public static Card onP1H1 = new Card();
//    public static Card onP1H2 = new Card();
//    public static Card onP1H3 = new Card();
//    public static Card onP1H4 = new Card();
//    public static Card onP1H5 = new Card();
//    public static Card onP1H6 = new Card();
//    public static Card onP1H7 = new Card();
//    public static Card onP1H8 = new Card();
//    public static Card onP1H9 = new Card();
//
//    // Card on arena player 1
//    public static Card onP1A1 = new Card();
//    public static Card onP1A2 = new Card();
//    public static Card onP1A3 = new Card();
//    public static Card onP1A4 = new Card();
//    public static Card onP1A5 = new Card();
//    public static Card onP1A6 = new Card();
//    public static Card onP1A7 = new Card();
//    public static Card onP1A8 = new Card();
//
//    // Card on skill area player 1
//    public static Card onP1S1 = new Card();
//    public static Card onP1S2 = new Card();
//    public static Card onP1S3 = new Card();
//    public static Card onP1S4 = new Card();
//    public static Card onP1S5 = new Card();
//    public static Card onP1S6 = new Card();
//    public static Card onP1S7 = new Card();
//    public static Card onP1S8 = new Card();
//
//    // Card on hand player 2
//    public static Card onP2H1 = new Card();
//    public static Card onP2H2 = new Card();
//    public static Card onP2H3 = new Card();
//    public static Card onP2H4 = new Card();
//    public static Card onP2H5 = new Card();
//    public static Card onP2H6 = new Card();
//    public static Card onP2H7 = new Card();
//    public static Card onP2H8 = new Card();
//    public static Card onP2H9 = new Card();
//
//    // Card on arena player 2
//    public static Card onP2A1 = new Card();
//    public static Card onP2A2 = new Card();
//    public static Card onP2A3 = new Card();
//    public static Card onP2A4 = new Card();
//    public static Card onP2A5 = new Card();
//    public static Card onP2A6 = new Card();
//    public static Card onP2A7 = new Card();
//    public static Card onP2A8 = new Card();
//
//    // Card on skill area player 2
//    public static Card onP2S1 = new Card();
//    public static Card onP2S2 = new Card();
//    public static Card onP2S3 = new Card();
//    public static Card onP2S4 = new Card();
//    public static Card onP2S5 = new Card();
//    public static Card onP2S6 = new Card();
//    public static Card onP2S7 = new Card();
//    public static Card onP2S8 = new Card();
}