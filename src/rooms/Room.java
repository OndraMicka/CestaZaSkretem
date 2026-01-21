package rooms;

public abstract class Room {
    protected String info;

    public Room(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "Room{" +
                "info='" + info + '\'' +
                '}';
    }
}
