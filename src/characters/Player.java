package characters;

import core.Inventory;

import java.util.ArrayList;

public class Player extends GameCharacter {
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", inventory=" + inventory +
                ", itemsID=" + itemsID +
                ", maxHealth=" + maxHealth +
                '}';
    }
}
