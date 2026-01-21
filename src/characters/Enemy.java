package characters;

import core.Inventory;

import java.util.ArrayList;

public class Enemy extends GameCharacter{
    private String info;

    @Override
    public String toString() {
        return "Enemy{" +
                "info='" + info + '\'' +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", inventory=" + inventory +
                ", inventoryCapacity=" + inventoryCapacity +
                ", itemsID=" + itemsID +
                '}';
    }

    public String getInfo() {
        return info;
    }
}
