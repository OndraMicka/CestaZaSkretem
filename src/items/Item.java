package items;

import characters.GameCharacter;

public abstract class Item {
    private String name;
    private String id;
    private String info;
    private int durability;

    public String getInfo() {
        return info;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
    public void use(GameCharacter attacker,GameCharacter attacked) {
        //todo
    }
}
