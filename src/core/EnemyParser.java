package core;

import characters.Enemy;
import items.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class EnemyParser {
    private HashMap<String, Enemy> enemies;

    public EnemyParser(Game game) {
        enemies = new HashMap<>();
        ArrayList<Enemy> enemiesJSON = game.getGameData().enemies;

        for(Enemy enemy :enemiesJSON ) {
            enemies.put(enemy.getName(), enemy);
        }

    }

    public Enemy getEnemy(String name) throws NullPointerException {
        Enemy enemy = enemies.get(name);
        if(enemy == null) {
            throw new NullPointerException("Id does not match any Item.");
        }
        return enemy;

    }
}
