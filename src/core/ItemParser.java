package core;

import items.Item;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Stores all items, returns Item from provided String id of item
 */
public class ItemParser {
    private HashMap<String, Item> items;

    public ItemParser(Game game) {
        items = new HashMap<>();
        ArrayList<Item> itemsJSON = game.getGameData().items;

        for(Item item :itemsJSON ) {
            items.put(item.getId(), item);
        }

    }

    /**
     * Returns Item from given id.
     * @param id of item (stored in gameData.json)
     * @return Copy of item.
     * @throws NullPointerException
     */
    public Item getItem(String id) throws NullPointerException {
        Item item = items.get(id);
        if(item == null) {
            throw new NullPointerException("Id does not match any Item.");
        }
            return item.copyOfItem();

    }
}
