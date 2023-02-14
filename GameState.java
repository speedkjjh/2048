package org.cis120.TwentyFortyEight;

import java.util.*;

public class GameState implements Comparable<Object> {
    private int[][] b;
    private int s;

    public GameState(int[][] arr, int score) {
        this.b = arr;
        this.s = score;
    }

    public int getScore() {
        return s;
    }

    public int[][] getBoard() {
        return b;
    }

    @Override
    public boolean equals(Object o) {
        GameState s = (GameState) o;
        return (s.getScore() == this.getScore() && Arrays.equals(this.getBoard(), s.getBoard()));
    }

    @Override
    public int compareTo(Object o) {
        GameState s = (GameState) o;
        return (this.getScore() - s.getScore());
    }
}
