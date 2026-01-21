package characters;

import core.Inventory;

import java.util.ArrayList;

public class Player extends GameCharacter {
    private int maxHealth;


    @Override
    public String toString() {
        return "Player{" +
                "maxHealth=" + maxHealth +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", inventory=" + inventory +
                ", inventoryCapacity=" + inventoryCapacity +
                ", itemsID=" + itemsID +
                '}';
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}
