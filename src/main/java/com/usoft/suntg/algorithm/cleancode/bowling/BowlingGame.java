package com.usoft.suntg.algorithm.cleancode.bowling;

/**
 * 保龄球游戏
 * @author suntg
 * @date ${date}
 */
public class BowlingGame {

    private int[][] rolls = new int[11][2];
    private int round = 0;
    private int time = 0;

    public void roll(int... i) {
        rolls[round] = i;
        round ++;
    }

    public int score() {
        int score = 0;
        boolean strike = false;
        boolean spare = false;
        for (int i = 0; i < rolls.length; i ++) {
            int[] roll = rolls[i];
            if (strike) {
                score += roll[0] + roll[1];
            } else if (spare) {
                score += roll[0];
            }
            if (i < rolls.length - 1) {
                score += roll[0] + roll[1];
            }
            if (roll[0] == 10) {
                strike = true;
                spare = false;
            } else if (roll[0] + roll[1] == 10) {
                strike = false;
                spare = true;
            } else {
                strike = false;
                spare = false;
            }
        }
        return score;
    }
}
