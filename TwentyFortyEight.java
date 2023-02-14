package org.cis120.TwentyFortyEight;


import java.util.LinkedList;

public class TwentyFortyEight {

    private int[][] board;
    private int numTurns;
    private int score;
    private int result;
    private LinkedList<int[][]> boardHistory;
    private LinkedList<Integer> scoreHistory;

    /**
     * Constructor sets up game state.
     */
    public TwentyFortyEight() {
        reset();
    }

    /**
     * playTurn allows players to play a turn. Returns true if the move is
     * successful and false if a player tries to play a useless move
     * or after the game has ended. Updates the game state after the move.
     *
     * @param d direction to play in
     * @return whether the turn was successful
     */
    public boolean playTurn(int d) {
        if (result == 1 || result == 2) {
            return false;
        }
        boolean moved = false;
        int[][] b = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                b[i][j] = board[i][j];
            }
        }

        int s = 0;
        s = score + 0;
        // input direction is downwards
        if (d == 3) {
            // adds tiles together in direction of input
            for (int i = 0; i < 4; i++) {
                for (int j = 2; j > -1; j--) {
                    if (board[j][i] == board[j + 1][i] && board[j][i] > 0) {
                        board[j + 1][i] = 2 * board[j][i];
                        board[j][i] = 0;
                        score += board[j + 1][i];
                        moved = true;
                    } else if (j < 2) {
                        if (board[j][i] == board[j + 2][i] &&
                                board[j + 1][i] == 0 && board[j][i] > 0) {
                            board[j + 2][i] = 2 * board[j][i];
                            board[j][i] = 0;
                            score += board[j + 2][i];
                            moved = true;
                        } else if (j == 0) {
                            if (board[j][i] == board[j + 3][i] &&
                                    board[j + 1][i] == 0 && board[j + 2][i] == 0
                                    && board[j][i] > 0) {
                                board[j + 3][i] = 2 * board[j][i];
                                board[j][i] = 0;
                                score += board[j + 3][i];
                                moved = true;
                            }
                        }
                    }
                }
            }
            // moves tiles in direction of input
            for (int r = 0; r < 3; r++) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[j + 1][i] == 0 && board[j][i] > 0) {
                            board[j + 1][i] = board[j][i];
                            board[j][i] = 0;
                            moved = true;
                        }
                    }
                }
            }
        }
        // input direction is rightwards
        if (d == 2) {
            for (int i = 2; i > -1; i--) {
                for (int j = 0; j < 4; j++) {
                    if (board[j][i + 1] == board[j][i] && board[j][i] > 0) {
                        board[j][i + 1] = 2 * board[j][i];
                        board[j][i] = 0;
                        score += board[j][i + 1];
                        moved = true;
                    } else if (i < 2) {
                        if (board[j][i + 2] == board[j][i] &&
                                board[j][i + 1] == 0 && board[j][i] > 0) {
                            board[j][i + 2] = 2 * board[j][i];
                            board[j][i] = 0;
                            score += board[j][i + 2];
                            moved = true;
                        } else if (i == 0) {
                            if (board[j][i + 3] == board[j][i] &&
                                    board[j][i + 1] == 0 && board[j][i + 2] == 0
                                    && board[j][i] > 0) {
                                board[j][i + 3] = 2 * board[j][i];
                                board[j][i] = 0;
                                score += board[j][i + 3];
                                moved = true;
                            }
                        }
                    }
                }
            }
            // moves tiles in direction of input
            for (int r = 0; r < 3; r++) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (board[j][i + 1] == 0 && board[j][i] > 0) {
                            board[j][i + 1] = board[j][i];
                            board[j][i] = 0;
                            moved = true;
                        }
                    }
                }
            }
        }
        // input direction is upwards
        if (d == 1) {
            for (int i = 0; i < 4; i++) {
                for (int j = 1; j < 4; j++) {
                    if (board[j][i] == board[j - 1][i] && board[j][i] > 0) {
                        board[j - 1][i] = 2 * board[j][i];
                        board[j][i] = 0;
                        score += board[j - 1][i];
                        moved = true;
                    } else if (j > 1) {
                        if (board[j][i] == board[j - 2][i] &&
                                board[j - 1][i] == 0 && board[j][i] > 0) {
                            board[j - 2][i] = 2 * board[j][i];
                            board[j][i] = 0;
                            score += board[j - 2][i];
                            moved = true;
                        } else if (j == 3) {
                            if (board[j][i] == board[j - 3][i] &&
                                    board[j - 1][i] == 0 && board[j - 2][i] == 0
                                    && board[j][i] > 0) {
                                board[j - 3][i] = 2 * board[j][i];
                                board[j][i] = 0;
                                score += board[j - 3][i];
                                moved = true;
                            }
                        }
                    }
                }
            }
            // moves tiles in direction of input
            for (int r = 0; r < 3; r++) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 3; j > 0; j--) {
                        if (board[j - 1][i] == 0 && board[j][i] > 0) {
                            board[j - 1][i] = board[j][i];
                            board[j][i] = 0;
                            moved = true;
                        }
                    }
                }
            }
        }
        // input direction is leftwards
        if (d == 4) {
            for (int i = 1; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (board[j][i - 1] == board[j][i] && board[j][i] > 0) {
                        board[j][i - 1] = 2 * board[j][i];
                        board[j][i] = 0;
                        score += board[j][i - 1];
                        moved = true;
                    } else if (i > 1) {
                        if (board[j][i - 2] == board[j][i] &&
                                board[j][i - 1] == 0 && board[j][i] > 0) {
                            board[j][i - 2] = 2 * board[j][i];
                            board[j][i] = 0;
                            score += board[j][i - 2];
                            moved = true;
                        } else if (i == 3) {
                            if (board[j][i - 3] == board[j][i] &&
                                    board[j][i - 1] == 0 && board[j][i - 2] == 0
                                    && board[j][i] > 0) {
                                board[j][i - 3] = 2 * board[j][i];
                                board[j][i] = 0;
                                score += board[j][i - 3];
                                moved = true;
                            }
                        }
                    }
                }
            }
            // moves tiles in direction of input
            for (int r = 0; r < 3; r++) {
                for (int i = 3; i > 0; i--) {
                    for (int j = 0; j < 4; j++) {
                        if (board[j][i - 1] == 0 && board[j][i] > 0) {
                            board[j][i - 1] = board[j][i];
                            board[j][i] = 0;
                            moved = true;
                        }
                    }
                }
            }
        }
        // if something has moved, generates a tile and adds the
        // past board and score to history.
        if (moved) {
            generateTile();
            boardHistory.add(b);
            scoreHistory.add(s);
            numTurns++;
            result = checkWinner();
        }
        return moved;
    }

    /**
     * generateTile creates a random tile (2 or 4) at an
     * empty square chosen randomly on the board.
     */
    public void generateTile() {
        int emptySquares = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // counts empty squares left on the board
                if (board[i][j] == 0) {
                    emptySquares++;
                }
            }
        }
        int pos = (int) (Math.random() * emptySquares);
        int r = (int) (Math.random() * 4);
        int tile = 0;
        if (r == 3) {
            tile = 4;
        } else {
            tile = 2;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    if (pos == 0) {
                        board[i][j] = tile;
                        return;
                    } else {
                        pos--;
                    }
                }

            }
        }
    }

    /**
     * checkWinner checks whether the game has reached the win condition of
     * having a tile of value 2048 or the loss condition of the board being full
     * and no valid moves remain.
     *
     * @return 0 if game has not ended yet, 1 if player has won, and 2 if player has lost
     */
    public int checkWinner() {
        int emptySquares = 0;
        // Check if player won or lost
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 2048) {
                    return 1;
                }
                // counts empty squares left on the board
                if (board[i][j] == 0) {
                    emptySquares++;
                }

            }
        }

        // Check if player lost
        if (!movesPossible() && emptySquares == 0) {
            return 2;
        }

        // Game is not over, returns 0
        return 0;
    }

    /**
     * movesPossible checks whether there are any tiles adjacent to
     * other tiles with the same value. This means if the board is full,
     * there are still possible moves that the player can take.
     *
     * @return whether there are adjacent tiles with the same value
     */
    public boolean movesPossible() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i > 0) {
                    if (board[i][j] == board[i - 1][j]) {
                        return true;
                    }
                }
                if (i < 0) {
                    if (board[i][j] == board[i + 1][j]) {
                        return true;
                    }
                }
                if (j > 0) {
                    if (board[i][j] == board[i][j - 1]) {
                        return true;
                    }
                }
                if (j < 0) {
                    if (board[i][j] == board[i][j + 1]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * printGameState prints the current game state
     * for debugging.
     */
    public void printGameState() {
        System.out.println("\n\nTurn " + numTurns + ":\n");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                if (j < 3) {
                    System.out.print(" | ");
                }
            }
            if (i < 3) {
                System.out.println("\n---------");
            }
        }
    }

    /**
     * reset (re-)sets the game state to start a new game.
     */
    public void reset() {
        board = new int[4][4];
        generateTile();
        generateTile();
        boardHistory = new LinkedList<>();
        scoreHistory = new LinkedList<>();
        boardHistory.add(board);
        scoreHistory.add(0);
        numTurns = 0;
        result = 0;
        score = 0;
    }

    /**
     * Undoes the last turn of the game.
     */
    public void undo() {
        if (numTurns > 0) {
            board = boardHistory.removeLast();
            score = scoreHistory.removeLast();
            numTurns--;
            result = checkWinner();
        }
    }

    /**
     * setState sets the game state to a determined board state and score.
     *
     * @param arr board state to set to
     * @param s score to set to
     */
    public void setState(int[][] arr, int s) {
        board = arr;
        numTurns = 0;
        score = s;
        result = checkWinner();
    }

    /**
     * getScore is a getter for the total score of the game.
     * 
     * @return score stored in the game state
     */
    public int getScore() {
        return score;
    }

    /**
     * getNumTurns is a getter for the turn number of the game.
     *
     * @return turn number stored in the game state
     */
    public int getNumTurns() {
        return numTurns;
    }

    /**
     * getCell is a getter for the contents of the cell specified by the method
     * arguments.
     *
     * @param c column to retrieve
     * @param r row to retrieve
     * @return an integer denoting the contents of the corresponding cell on the
     *         game board.
     */
    public int getCell(int c, int r) {
        return board[r][c];
    }

    /**
     * getBoard is a getter for the current board of the game.
     *
     * @return int array array board stored in the game state
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * This main method illustrates how the model is completely independent of
     * the view and controller. We can play the game from start to finish
     * without ever creating a Java Swing object.
     *
     * This is modularity in action, and modularity is the bedrock of the
     * Model-View-Controller design framework.
     *
     * Run this file to see the output of this method in your console.
     */
    public static void main(String[] args) {
        TwentyFortyEight t = new TwentyFortyEight();

        t.playTurn(1);
        t.printGameState();

        t.playTurn(4);
        t.printGameState();

        t.playTurn(2);
        t.printGameState();

        t.playTurn(1);
        t.printGameState();

        t.playTurn(4);
        t.printGameState();

        t.playTurn(2);
        t.printGameState();

        t.playTurn(1);
        t.printGameState();

        t.playTurn(3);
        t.printGameState();

        t.playTurn(2);
        t.printGameState();
    }
}
