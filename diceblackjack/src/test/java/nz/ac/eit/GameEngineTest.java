package nz.ac.eit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameEngineTest {
    private GameEngine gameEngine;

    @Before
    public void setup() {
        gameEngine = new GameEngine();
    }

    @Test
    public void checkScore_whileScoreIs0_shouldReturnTrue () {
        boolean checkResult = gameEngine.checkScoreValid(gameEngine.getUser());
        assertEquals("The player score of 0 should return true", true, checkResult);
    }
}
