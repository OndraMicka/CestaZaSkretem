package core;

import items.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemParser {
    private HashMap<String, Item> items;

    public ItemParser(Game game) {
        items = new HashMap<>();
        ArrayList<Item> itemsJSON = game.getGameData().items;

        for(Item item :itemsJSON ) {
            items.put(item.getId(), item);
        }

    }

    public Item getItem(String id) throws NullPointerException {
        Item item = items.get(id);
        if(item == null) {
            throw new NullPointerException("Id does not match any Item.");
        }
            return item;

    }
}
