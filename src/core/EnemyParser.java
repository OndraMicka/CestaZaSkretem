package core;

import characters.Enemy;
import items.Item;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Stores all enemies, returns Enemy from provided String id of enemy
 */
public class EnemyParser {
    private HashMap<String, Enemy> enemies;

    public EnemyParser(Game game) {
        enemies = new HashMap<>();
        ArrayList<Enemy> enemiesJSON = game.getGameData().enemies;

        for(Enemy enemy :enemiesJSON ) {
            enemies.put(enemy.getName(), enemy);
        }

    }

    /**
     * Returns enemy from given id.
     * @param name id of enemy (stored in gameData.json)
     * @return Enemy
     * @throws NullPointerException
     */
    public Enemy getEnemy(String name) throws NullPointerException {
        Enemy enemy = enemies.get(name);
        if(enemy == null) {
            throw new NullPointerException("Id does not match any Item.");
        }
        return enemy;

    }
}
