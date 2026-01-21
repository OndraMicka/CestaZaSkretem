package characters;


import core.Inventory;

import java.util.ArrayList;

public abstract class GameCharacter {
    protected String name;
    protected int health;
    protected Inventory inventory;
    protected int inventoryCapacity;
    protected ArrayList<String> itemsID;

    public GameCharacter(String name, int health, Inventory inventory, int inventoryCapacity, ArrayList<String> itemsID) {
        this.name = name;
        this.health = health;
        this.inventory = inventory;
        this.inventoryCapacity = inventoryCapacity;
        this.itemsID = itemsID;
    }
}
