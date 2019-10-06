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

    @Test
    public void checkScore_whileScoreIs21_shouldReturnFalse () {
        // TODO: 06-Oct-19
        gameEngine.getUser().setScore(21);
        boolean checkResult = gameEngine.checkScoreValid(gameEngine.getUser());
        assertEquals("The player score of 21 should return false", false, checkResult);
    }

    @Test
    public void checkScore_whileScoreIs22_shouldReturnFalse () {
        // TODO: 06-Oct-19
        gameEngine.getUser().setScore(22);
        boolean checkResult = gameEngine.checkScoreValid(gameEngine.getUser());
        assertEquals("The player score of 21 should return false", false, checkResult);
    }

    @Test
    public void dealerTurn_shouldReturnBetween16and27 () {
        // TODO: 06-Oct-19
        gameEngine.dealerTurn();
        int dealerScore = gameEngine.getDealer().getScore();
        assertTrue("The dealer should finish on a score of at least 16 and no more than 27", dealerScore >= 16 && dealerScore <= 27);
    }

    @Test
    public void hit_shouldReturnBetween2And12 () {
        // TODO: 06-Oct-19
        int preScore = gameEngine.getUser().getScore();
        gameEngine.hit(gameEngine.getUser());
        int postScore = gameEngine.getUser().getScore();
        int scoreDifference = postScore - preScore;
        assertTrue("Hit should add between 2 and 12 to score", scoreDifference <=2 && scoreDifference <= 12);
    }

    @Test
    public void calculateWinner_whileScoresAre0_shouldReturnNull () {
        // TODO: 06-Oct-19
        Player winner = gameEngine.calculateWinner();
        assertNull("While scores are the same, winner should be null", winner);
    }

    @Test
    public void calculateWinner_whileUserScoreIsHigher_shouldReturnUser () {
        // TODO: 06-Oct-19
        gameEngine.getUser().setScore(1);
        Player winner = gameEngine.calculateWinner();
        assertEquals("While user score is higher, user should win", gameEngine.getUser(), winner);
    }

    @Test
    public void calculateWinner_whileUserScoreIs22_shouldReturnDealer () {
        // TODO: 06-Oct-19
        gameEngine.getUser().setScore(22);
        Player winner = gameEngine.calculateWinner();
        Player dealer = gameEngine.getDealer();
        assertEquals("While user score is over 21, dealer should win", dealer, winner);
    }

    @Test
    public void calculateWinner_whileDealerScoreIsHigher_shouldReturnDealer () {
        // TODO: 06-Oct-19
        gameEngine.getDealer().setScore(1);
        Player winner = gameEngine.calculateWinner();
        Player dealer = gameEngine.getDealer();
        assertEquals("While user dealer is higher, dealer should win", dealer, winner);
    }

    @Test
    public void calculateWinner_whileDealerScoreIs22_shouldReturnUser () {
        // TODO: 06-Oct-19
        gameEngine.getDealer().setScore(22);
        Player winner = gameEngine.calculateWinner();
        Player dealer = gameEngine.getDealer();
        assertEquals("While user score is higher, user should win", dealer, winner);
    }
}
