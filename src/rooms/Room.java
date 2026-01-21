package rooms;

public abstract class Room {
    protected String info;

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
