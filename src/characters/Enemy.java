package characters;

public class Enemy extends GameCharacter {
    private String info;


    @Override
    public String toString() {
        return "Enemy{" +
                "info='" + info + '\'' +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", inventory=" + inventory +
                ", itemsID=" + itemsID +
                '}';
    }

    public String getInfo() {
        return info;
    }
}
