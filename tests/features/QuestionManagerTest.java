package features;

import core.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionManagerTest {
    QuestionManager questionManager;
    @BeforeEach
    void setUp() {
        questionManager = new QuestionManager(new Game());
    }

    @Test
    void answer() {
        assertNotNull(questionManager.answer("13"));
        assertNull(questionManager.answer("Netusim, co meles?"));
    }
}