package characters;

import core.Inventory;

import java.util.ArrayList;

public class Enemy extends GameCharacter{
    private String info;

    public Enemy(String name, int health, Inventory inventory, int inventoryCapacity, ArrayList<String> itemsID, String info) {
        super(name, health, inventory, inventoryCapacity, itemsID);
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
