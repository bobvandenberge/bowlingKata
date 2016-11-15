package com.infosupport;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void canRollGutterGame() {
        rollMany(20, 0);

        assertThat(game.score(), is(0));
    }

    @Test
    public void canRollOnePinGame() {
        rollMany(20, 1);

        assertThat(game.score(), is(20));
    }

    @Test
    public void canRollSpare() {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);

        assertThat(game.score(), is(16));
    }

    @Test
    public void canRollStrike() {
        rollStrike();
        game.roll(4);
        game.roll(3);
        rollMany(16, 0);

        assertThat(game.score(), is(24));
    }

    @Test
    public void canRollPerfectGame() {
        rollMany(12, 10);

        assertThat(game.score(), is(300));
    }

    private void rollStrike() {
        game.roll(10);
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollMany(final int rolls, final int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }
}
