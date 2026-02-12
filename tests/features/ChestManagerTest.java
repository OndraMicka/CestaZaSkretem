package features;

import core.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChestManagerTest {
    ChestManager chestManager;
    @BeforeEach
    void setUp() {
        chestManager = new ChestManager(new Game());
    }

    @Test
    void getInfoItems() {
        assertNotNull(chestManager.getInfoItems());
        chestManager.pick("1");
        assertNotNull(chestManager.getInfoItems());
        chestManager.pick("2");
        assertNotNull(chestManager.getInfoItems());
        chestManager.pick("3");
        assertNotNull(chestManager.getInfoItems());
    }

    @Test
    void pick() {
        assertNotNull(chestManager.pick("1"));
        assertNotNull(chestManager.pick("2"));
        assertNotNull(chestManager.pick("3"));
        assertNull(chestManager.pick("4"));
        assertNull(chestManager.pick("nula"));
    }
}