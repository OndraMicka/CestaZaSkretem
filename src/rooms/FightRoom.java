package rooms;

import characters.Enemy;

public class FightRoom extends Room {
    private Enemy enemy;
    private String enemyName;


    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public String getEnemyName() {
        return enemyName;
    }



    @Override
    public String toString() {
        return "FightRoom{" +
                "enemy=" + enemy +
                ", enemyName='" + enemyName + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
