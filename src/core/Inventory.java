package core;

import characters.GameCharacter;
import items.Item;
import items.ItemType;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Stores all items of game character.
 */
public class Inventory {
    private transient ArrayList<Item> items = new ArrayList<>();
    private final int capacity;

    public Inventory(int capacity) {
        this.capacity = capacity;
    }

    public void addItemInteractive(Item item) {
        Scanner scanner = new Scanner(System.in);
        if (!addItem(item)) {
            System.out.println("Nemáš pro item dostatek místa. Zadej číslo predmětu,\nza který chceš předmět vyměnit,\nnebo 0 pro zahození itemu..");
            System.out.println(this);
            do {
                System.out.print(">>");
                try {
                    int choice = scanner.nextInt();
                    if (choice == 0) {
                        System.out.println("Zahodil jsi předmět.");
                        return;
                    }
                    if (removeItem(choice - 1)) {
                        addItem(item);
                        System.out.println("Vyměnil jsi si předmět za nový.");
                        return;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Zadej číslo.");
                    scanner.nextLine();
                }
            } while (true);
        }
        System.out.println("Vzal jsi předmět.");
    }


    /**
     * returns string with all items in inventory, with index, durability and info.
     *
     * @return String text, print to console
     */
    public String toString() {
        String str = "Inventář obsahuje:\n";
        for (int i = 0; i < items.size(); i++) {
            str += (i + 1) + ": " + items.get(i).getPrintInfo() + "\n";
        }
        return str;
    }

    /**
     * If inventory is not full, adds item to inventory .
     * If item type is HEAL => Adds new item or adds durability to an already contained item.
     * If item type is ATTACK => Adds new item to list.
     *
     * @param item Item to be added
     * @return true if operation was successful, false if inventory was full.
     */
    public boolean addItem(Item item) {
        if (items == null) {
            items = new ArrayList<>();
        }
        if (item.getType() == ItemType.HEAL) {
            for (Item itemInList : items) {
                if (item.getName().equals(itemInList.getName())) {
                    itemInList.setDurability(itemInList.getDurability() + item.getDurability());
                    return true;
                }
            }
        }
        if (capacity > items.size()) {
            items.add(item);
            return true;
        }
        return false;
    }


    /**
     * Removes item from list.
     *
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
     * Uses item. Lowers durability or removes item if durability was 1.
     *
     * @param index    index of item in list
     * @param attacker Game character which is attacking.
     * @param attacked Game character to be attacked.
     * @return If wrong index was given, returns false.
     */
    public boolean use(int index, GameCharacter attacker, GameCharacter attacked) {
        try {
            Item item = items.get(index);
            if (item.getDurability() == 1) {
                items.remove(index);
            } else {
                items.get(index).setDurability(item.getDurability() - 1);
            }
            item.use(attacker, attacked);
            System.out.println(attacker.getName() + " použil: " + item.getName());
            return true;
        } catch (Exception _) {
            return false;
        }


    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return items.size();
    }
}
