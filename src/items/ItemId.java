package items;

import java.io.Serializable;

/**
 * Represents item. Used for reading item from json then parsing it to actual item.
 */
public class ItemId implements Serializable {
    private String id;
    private int durability;

    public String getId() {
        return id;
    }

    public int getDurability() {
        return durability;
    }
}
