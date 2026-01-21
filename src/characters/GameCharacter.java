package characters;


import core.Inventory;

import java.util.ArrayList;

public abstract class GameCharacter {
    protected String name;
    protected int health;
    protected Inventory inventory;
    protected int inventoryCapacity;
    protected ArrayList<String> itemsID;

}
