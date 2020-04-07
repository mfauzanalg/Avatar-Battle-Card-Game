// File : SkillCard.java
// Menyimpan informasi kartu skill 

public class SkillCard extends Card {
    String effect;

    public SkillCard(int _id, String _name, String ele, String desc, String path, String eff){
        super("skill", _id, _name, ele, desc, path);
        effect = eff;
    }

    public String getEffect(){
        return effect;
    }
}