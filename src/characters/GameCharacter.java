package characters;

import core.Inventory;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Abstract class game character, parent class for Player and Enemy.
 * Stores values of character.
 */
public abstract class GameCharacter implements Serializable {
    protected String name;
    protected int health;
    protected Inventory inventory;
    protected ArrayList<String> itemsID;
    protected int maxHealth;


    public void setHealth(int health) {
        if (health > maxHealth & maxHealth != 0) {
            health = maxHealth;
        }
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public ArrayList<String> getItemsID() {
        return itemsID;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
