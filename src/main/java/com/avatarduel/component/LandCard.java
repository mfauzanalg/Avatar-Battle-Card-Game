// File : LandCard.java
// Menambahkan power Player sesuai elemen kartu
package com.avatarduel.component;

public class LandCard extends Card implements IHandCard {
    Player target;

    public LandCard(int _id, String _name, String ele, String desc, String path){
        super("land", _id, _name, ele, desc, path);
    }
    // Mungkin semua kode dibawah komentar ini harusnya dipisah?
    // Tapi kalo dipisah class ini isinya constructor doang
    // Dan informasi LandCard udah disimpen di SkillCard? Jadi Single Responsibility Principle terpenuhi?
    public void setPlayer(Player _target){
        target = _target;
    }

    public void play(){
        // Tambah power player sesuai elemen kartu land
        // Tunggu implementasi player
        System.out.println("blm diimplemen");
    }
}