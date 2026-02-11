package rooms;

/**
 * Base abstract class representing a room in the game.
 * Contains shared information such as room description.
 */
public abstract class Room {
    protected String info;

    /**
     * @return description of surrounding
     */
    public String getInfo() {
        return info;
    }
}
