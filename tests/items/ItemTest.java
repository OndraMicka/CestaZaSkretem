package items;

import characters.Enemy;
import characters.Player;
import core.Inventory;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    Player player;
    Enemy enemy;

    @BeforeEach
    void setUp() {
        Item item = new Item();
        item.setDurability(1);
        item.setMethod(MethodType.ATTACK);
        item.setHealthAmount(20);

        player = new Player();
        player.setInventory(new Inventory(7));
        player.getInventory().addItem(item);
        player.setHealth(100);


        enemy = new Enemy();
        enemy.setInventory(new Inventory(5));
        enemy.setHealth(100);
    }


    @org.junit.jupiter.api.Test
    void copyOfItem() {
        Item item = new Item();
        assertNotSame(item, item.copyOfItem());
    }

    @org.junit.jupiter.api.Test
    void use() {
        player.getInventory().use(0,player,enemy);
        assertEquals(80, enemy.getHealth());
        assertEquals(100, player.getHealth());
    }
}