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

    // Entah kenapa merasa ini sebaiknya dipisah biar Single Responsibility Principle terpenuhi tapi belum kepikiran gimana misahinnya
    //abstract public void play();
}