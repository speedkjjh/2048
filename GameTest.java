package org.cis120.TwentyFortyEight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You can use this file (and others) to test your
 * implementation.
 */

public class GameTest {

    @Test
    public void moveBoardLeftTest() {
        TwentyFortyEight tfe = new TwentyFortyEight();
        int[][] arr = new int[4][4];
        arr[0][0] = 2;
        arr[0][1] = 2;
        tfe.setState(arr, 0);
        tfe.playTurn(4);
        assertEquals(4, tfe.getCell(0,0));
        assertEquals(0, tfe.getCell(0,1));
        assertEquals(1, tfe.getNumTurns());
    }

    @Test
    public void moveBoardLeftThreeTest() {
        TwentyFortyEight tfe = new TwentyFortyEight();
        int[][] arr = new int[4][4];
        arr[0][0] = 2;
        arr[0][3] = 2;
        tfe.setState(arr, 0);
        tfe.playTurn(4);
        assertEquals(4, tfe.getCell(0,0));
        assertEquals(0, tfe.getCell(3,0));
        assertEquals(1, tfe.getNumTurns());
    }

    @Test
    public void moveBoardFourNumbersTest() {
        TwentyFortyEight tfe = new TwentyFortyEight();
        int[][] arr = new int[4][4];
        arr[0][0] = 2;
        arr[0][1] = 2;
        arr[0][2] = 2;
        arr[0][3] = 2;
        tfe.setState(arr, 0);
        tfe.playTurn(4);
        assertEquals(4, tfe.getCell(0,0));
        assertEquals(4, tfe.getCell(1,0));
        assertEquals(0, tfe.getCell(2,0));
        assertEquals(0, tfe.getCell(3,0));
        assertEquals(1, tfe.getNumTurns());
    }

    @Test
    public void generateTileNoMoveTest() {
        TwentyFortyEight tfe = new TwentyFortyEight();
        int[][] arr = new int[4][4];
        tfe.setState(arr, 0);
        tfe.playTurn(4);
        int tot = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tot += tfe.getCell(i, j);
            }
        }
        assertEquals(0, tot);
    }

    @Test
    public void checkWinnerWinTest() {
        TwentyFortyEight tfe = new TwentyFortyEight();
        int[][] arr = new int[4][4];
        arr[0][0] = 2048;
        tfe.setState(arr, 0);
        assertEquals(1, tfe.checkWinner());
    }

    @Test
    public void checkWinnerLoseTest() {
        TwentyFortyEight tfe = new TwentyFortyEight();
        int[][] arr = new int[4][4];
        int k = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = k;
                k++;
            }
        }
        tfe.setState(arr, 0);
        assertEquals(2, tfe.checkWinner());
    }

    @Test
    public void resetLossTest() {
        TwentyFortyEight tfe = new TwentyFortyEight();
        int[][] arr = new int[4][4];
        int k = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = k;
                k++;
            }
        }
        tfe.setState(arr, 10);
        tfe.reset();
        assertEquals(0, tfe.getScore());
    }

    @Test
    public void undoOneMoveTest() {
        TwentyFortyEight tfe = new TwentyFortyEight();
        int[][] arr = new int[4][4];
        arr[0][0] = 2;
        arr[0][1] = 2;
        tfe.setState(arr, 0);
        tfe.playTurn(4);
        tfe.undo();
        assertEquals(2, tfe.getCell(0,0));
        assertEquals(2, tfe.getCell(1,0));
    }

    @Test
    public void undoTwoMoveTest() {
        TwentyFortyEight tfe = new TwentyFortyEight();
        int[][] arr = new int[4][4];
        arr[0][0] = 2;
        arr[0][1] = 2;
        tfe.setState(arr, 0);
        tfe.playTurn(4);
        tfe.playTurn(2);
        tfe.undo();
        tfe.undo();
        assertEquals(2, tfe.getCell(0,0));
        assertEquals(2, tfe.getCell(1,0));
    }


}
