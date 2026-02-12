package core;

import characters.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyParserTest {
    EnemyParser enemyParser;
    @BeforeEach
    void setUp() {
        Game game = new Game();
        enemyParser = new EnemyParser(game);
    }

    @Test
    void getEnemy() {
        Enemy enemy1 = enemyParser.getEnemy("Čarodějnice");
        Enemy enemy2 = enemyParser.getEnemy("Kostlivec");
        Enemy enemy3 = enemyParser.getEnemy("Skřet");
        assertNotNull(enemy3);
        assertNotNull(enemy2);
        assertNotNull(enemy1);
    }
}