package com.infosupport;

public class Game {
    private int[] rolls = new int[21];
    private int rollIndex = 0;

    public void roll(final int pins) {
        rolls[rollIndex] = pins;
        rollIndex++;
     }

    public int score() {
        int score = 0;
        int frameIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            if(isStrike(frameIndex)) {
                score += 10 + strikeBonus(frameIndex);
                frameIndex += 1;
            } else if (isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += sumOfPinsInFrame(frameIndex);
                frameIndex += 2;
            }
        }

        return score;
    }

    private int sumOfPinsInFrame(final int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }

    private int spareBonus(final int roll) {
        return rolls[roll + 2];
    }

    private int strikeBonus(final int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private boolean isSpare(final int frameIndex) {
        return sumOfPinsInFrame(frameIndex) == 10;
    }

    private boolean isStrike(final int frameIndex) {
        return rolls[frameIndex] == 10;
    }
}
