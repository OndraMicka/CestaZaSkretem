package characters;

import core.Inventory;

import java.util.ArrayList;

public class Player extends GameCharacter {
    private int maxHealth;

    public Player(String name, int health, Inventory inventory, int inventoryCapacity, ArrayList<String> itemsID, int maxHealth) {
        super(name, health, inventory, inventoryCapacity, itemsID);
        this.maxHealth = maxHealth;
    }


    public int getMaxHealth() {
        return maxHealth;
    }
}
