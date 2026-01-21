package items;

import characters.GameCharacter;

public class Item {
    private String name;
    private ItemType type;
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

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", id='" + id + '\'' +
                ", info='" + info + '\'' +
                ", durability=" + durability +
                '}';
    }
}
