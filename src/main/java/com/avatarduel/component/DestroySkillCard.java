// File : DestroySkillCard.java
// Handles the behaviour of Destroy Skill Card when played

package com.avatarduel.component;

public class DestroySkillCard extends SkillCard implements IHandCard {
    SummonedCharacter target;

    public DestroySkillCard(int _id, String _name, String ele, String desc, String path){
        super(_id, _name, ele, desc, path,"destroy");
    }

    // Semua kode dibawah komen ini agak ragu, alasannya sama dengan yang ada di LandCard.java
    public void setTarget(SummonedCharacter _target){
        target = _target;
    }

    public void play(){
        // Put this card into board
        // Get the target card and set it as target
        target.destroy();
        //Immediately remove this card from board
    }
}