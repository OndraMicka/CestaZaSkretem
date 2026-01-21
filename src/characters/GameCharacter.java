package characters;


import core.Inventory;

import java.util.ArrayList;

public abstract class GameCharacter {
    protected String name;
    protected int health;
    protected Inventory inventory;
    protected int inventoryCapacity;
    protected ArrayList<String> itemsID;

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getInventoryCapacity() {
        return inventoryCapacity;
    }

    public ArrayList<String> getItemsID() {
        return itemsID;
    }
}
