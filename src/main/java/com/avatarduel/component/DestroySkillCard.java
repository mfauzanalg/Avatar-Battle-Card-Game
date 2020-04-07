// File : DestroySkillCard.java
// Handles the behaviour of Destroy Skill Card when played

public class DestroySkillCard extends SkillCard implements IHandCard {
    ISummoned target;

    public DestroySkillCard(int _id, String _name, String ele, String desc, String path){
        super("destroy", _id, _name, ele, desc, path);
    }

    // Semua kode dibawah komen ini agak ragu, alasannya sama dengan yang ada di LandCard.java
    public void setTarget(ISummoned _target){
        target = _target;
    }

    public void play(){
        // Put this card into board
        // Get the target card and set it as target
        target.destroy();
        //Immediately remove this card from board
    }
}