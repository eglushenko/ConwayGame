package com.game.conway;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class MainGliderTest {
    private static final String LIVE = "O";
    private static final String DEATH = "X";

    @Test
    public void main() {
        int generations = 6;
        String[][] field = {{"X", "X", "X", "X", "X", "X", "X", "X", "X"},
                {"X", "X", "X", "X", "X", "X", "X", "X", "X"},
                {"X", "X", "X", "O", "X", "X", "X", "X", "X"},
                {"X", "X", "X", "X", "O", "X", "X", "X", "X"},
                {"X", "X", "O", "O", "O", "X", "X", "X", "X"},
                {"X", "X", "X", "X", "X", "X", "X", "X", "X"},
                {"X", "X", "X", "X", "X", "X", "X", "X", "X"},
                {"X", "X", "X", "X", "X", "X", "X", "X", "X"},
                {"X", "X", "X", "X", "X", "X", "X", "X", "X"}};
        String[][] equalsField = {{"X", "X", "X", "X", "X", "X", "X", "X", "X"},
                {"X", "X", "X", "X", "X", "X", "X", "X", "X"},
                {"X", "X", "X", "X", "X", "X", "X", "X", "X"},
                {"X", "X", "X", "X", "X", "X", "X", "X", "X"},
                {"X", "X", "X", "X", "X", "O", "X", "X", "X"},
                {"X", "X", "X", "O", "X", "O", "X", "X", "X"},
                {"X", "X", "X", "X", "O", "O", "X", "X", "X"},
                {"X", "X", "X", "X", "X", "X", "X", "X", "X"},
                {"X", "X", "X", "X", "X", "X", "X", "X", "X"}};
        field = ConwayGameLogic.run(field,generations);
        boolean res = Arrays.deepEquals(field,equalsField);
        assertTrue(res);
    }
}