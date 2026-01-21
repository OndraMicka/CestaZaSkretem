package characters;


import core.Inventory;

import java.util.ArrayList;

public abstract class GameCharacter {
    private String name;
    private int health;
    private Inventory inventory;
    private int inventoryCapacity;
    private ArrayList<String> itemsID;
}
