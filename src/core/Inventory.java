package core;

import characters.GameCharacter;
import items.Item;

import java.util.ArrayList;

public class Inventory {
    private transient ArrayList<Item> items = new ArrayList<>();
    private final int capacity;

    public Inventory(int capacity) {
        this.capacity = capacity;
    }

    public String toString() {
        String str = "Inventář obsahuje:";
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            str += "\n" + (i+1) + ": " + item.getDurability() + "x " + item.getInfo();
        }
        return str;
    }

    public boolean addItem(Item item) {
        if (items == null) {
            items = new ArrayList<>();
        }
        if (capacity > items.size()) {
            items.add(item);
            return true;
        }
        return false;
    }

    public void use(int index, GameCharacter attacker,GameCharacter attacked) {
        Item item = items.get(index);
        items.remove(index);
        item.use(attacker,attacked);
    }

    public int getCapacity() {
        return capacity;
    }
}
