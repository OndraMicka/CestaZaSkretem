package rooms;

import characters.Enemy;

public class FightRoom extends Room {
    private Enemy enemy;

    public FightRoom(String info, Enemy enemy) {
        super(info);
        this.enemy = enemy;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    @Override
    public String toString() {
        return "FightRoom{" +
                "enemy=" + enemy +
                ", info='" + info + '\'' +
                '}';
    }
}
