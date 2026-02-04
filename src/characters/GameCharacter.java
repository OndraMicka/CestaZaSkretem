package characters;


import core.GameData;
import core.Inventory;
import core.ItemParser;
import rooms.Room;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public abstract class GameCharacter {
    protected String name;
    protected int health;
    protected Inventory inventory;
    protected ArrayList<String> itemsID;
    protected int maxHealth;

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health > maxHealth&maxHealth!=0) {
            health = maxHealth;
        }
        this.health = health;
    }

    public Inventory getInventory() {
        return inventory;
    }


    public ArrayList<String> getItemsID() {
        return itemsID;
    }

    public void setName(String name) {
        this.name = name;
    }
}
