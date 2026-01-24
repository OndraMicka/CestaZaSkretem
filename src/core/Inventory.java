package core;

import characters.GameCharacter;
import items.Item;
import items.ItemType;

import java.util.ArrayList;

/**
 * Stores all items of game character.
 */
public class Inventory {
    private transient ArrayList<Item> items = new ArrayList<>();
    private final int capacity;

    public Inventory(int capacity) {
        this.capacity = capacity;
    }


    /**
     * returns string with all items in inventory, with index, durability and info.
     * @return String text, print to console
     */
    public String toString() {
        String str = "Inventář obsahuje:";
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if(item.getType()==ItemType.HEAL) {
                str += "\n" + (i + 1) + ": " + item.getDurability() + "x " + item.getInfo();
            }else {
                str += "\n" + (i + 1) + ": " + item.getInfo()+", životnost: " + item.getDurability();
            }
        }
        return str;
    }

    /**
     * If inventory is not full, adds item to inventory .
     * If item type is HEAL => Adds new item or adds durability to an already contained item.
     * If item type is ATTACK => Adds new item to list.
     * @param item Item to be added
     * @return true if operation was successful, false if inventory was full.
     */
    public boolean addItem(Item item) {
        if (items == null) {
            items = new ArrayList<>();
        }
        if (capacity > items.size()) {
            if (item.getType() == ItemType.HEAL) {
                for (Item itemInList : items) {
                    if (item.getName().equals(itemInList.getName())) {
                        itemInList.setDurability(itemInList.getDurability() + item.getDurability());
                        return true;
                    }
                }
            }
            items.add(item);
            return true;
        }
        return false;
    }


    /**
     * Removes item from list.
     * @param Index Index of item in list.
     * @return If wrong index was given, returns false.
     */
    public boolean removeItem(int Index) {
        try {
            items.remove(Index);
            return true;
        } catch (Exception _) {
            return false;
        }
    }

    /**
     * Uses item. Lowers durability or removes item if durability was 1.which
     * @param index index of item in list
     * @param attacker Game character which is attacking.
     * @param attacked Game character to be attacked.
     */
    public void use(int index, GameCharacter attacker, GameCharacter attacked) {
        Item item = items.get(index);
        if (item.getDurability() == 1) {
            items.remove(index);
        } else {
            items.get(index).setDurability(item.getDurability() - 1);
        }
        item.use(attacker, attacked);
    }

    public int getCapacity() {
        return capacity;
    }
}
