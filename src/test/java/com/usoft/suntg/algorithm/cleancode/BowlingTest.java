package com.usoft.suntg.algorithm.cleancode;

import com.usoft.suntg.algorithm.cleancode.bowling.BowlingGame;
import junit.framework.TestCase;

/**
 * @author suntg
 * @date ${date}
 */
public class BowlingTest extends TestCase {

    private BowlingGame game = new BowlingGame();

    public void testScore() {
        rollMany(10, 1, 0);
        assertEquals(10, game.score());
    }

    public void testOneStrike() {
        game.roll(10, 0);
        game.roll(3, 3);
        rollMany(8, 1, 0);
        assertEquals(30, game.score());
    }

    public void testTwoStrike() {
        game.roll(10, 0);
        game.roll(10, 0);
        rollMany(8, 1, 0);
        assertEquals(39, game.score());
    }

    public void testOneSpare() {
        game.roll(4, 6);
        game.roll(3, 3);
        rollMany(8, 1, 0);
        assertEquals(27, game.score());
    }

    public void testTwoSpare() {
        game.roll(4, 6);
        game.roll(7, 3);
        rollMany(8, 1, 0);
        assertEquals(36, game.score());
    }

    public void testLastStrike() {
        rollMany(9, 1, 0);
        game.roll(10, 0);
        game.roll(1, 1);
        assertEquals(21, game.score());
    }

    public void testLastSpare() {
        rollMany(9, 1, 0);
        game.roll(1, 9);
        game.roll(1, 0);
        assertEquals(20, game.score());
    }

    private void rollMany(int times, int... score) {
        for (int i = 0; i < times; i ++) {
            game.roll(score);
        }
    }
}
