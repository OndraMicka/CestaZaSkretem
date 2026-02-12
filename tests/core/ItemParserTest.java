package core;

import items.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemParserTest {
    ItemParser ip;
    @BeforeEach
    void setUp() {
        Game game = new Game();
        ip = new ItemParser(game);
    }

    @Test
    void getItem() {
        Item item = ip.getItem("potion");
        assertNotNull(item);
        Item item2 = ip.getItem("potion2");
        assertNotNull(item2);
        Item item3 = ip.getItem("mace");
        assertNotNull(item3);
        Item item4 = ip.getItem("sword");
        assertNotNull(item4);
    }
}