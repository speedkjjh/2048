package org.cis120.TwentyFortyEight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * This class instantiates a TicTacToe object, which is the model for the game.
 * As the user clicks the game board, the model is updated. Whenever the model
 * is updated, the game board repaints itself and updates its status JLabel to
 * reflect the current state of the model.
 * 
 * This game adheres to a Model-View-Controller design framework. This
 * framework is very effective for turn-based games. We STRONGLY
 * recommend you review these lecture slides, starting at slide 8,
 * for more details on Model-View-Controller:
 * https://www.seas.upenn.edu/~cis120/current/files/slides/lec37.pdf
 * 
 * In a Model-View-Controller framework, GameBoard stores the model as a field
 * and acts as both the controller (with a MouseListener) and the view (with
 * its paintComponent method and the status JLabel).
 */
@SuppressWarnings("serial")
public class GameBoard extends JPanel {

    private TwentyFortyEight tfe; // model for the game
    private JLabel status; // current status text
    private SaveState ss;

    // Game constants
    public static final int BOARD_WIDTH = 400;
    public static final int BOARD_HEIGHT = 400;

    /**
     * Initializes the game board.
     */
    public GameBoard(JLabel statusInit) {
        // creates border around the court area, JComponent method
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Enable keyboard focus on the court area. When this component has the
        // keyboard focus, key events are handled by its key listener.
        setFocusable(true);

        tfe = new TwentyFortyEight(); // initializes model for the game
        status = statusInit; // initializes the status JLabel

        /*
         * Listens for mouseclicks. Updates the model, then updates the game
         * board based off of the updated model.
         */
        addKeyListener(new KeyAdapter() {
            int direction = 0;
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    direction = 4;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    direction = 2;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    direction = 3;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    direction = 1;
                }
            }
            public void keyReleased(KeyEvent e) {
                if (tfe.checkWinner() == 0) {
                    tfe.playTurn(direction);
                    updateStatus(); // updates the status JLabel
                    repaint(); // repaints the game board
                }
            }
        });
    }

    /**
     * (Re-)sets the game to its initial state.
     */
    public void reset() {
        tfe.reset();
        status.setText("" + tfe.getScore());
        repaint();
        updateStatus();
        requestFocusInWindow();
    }

    /**
     * Undoes the previous action in the game
     */
    public void undo() {
        tfe.undo();
        status.setText("" + tfe.getScore());
        repaint();
        updateStatus();
        requestFocusInWindow();
    }

    public void save() {
        GameState gs = new GameState(tfe.getBoard(), tfe.getScore());
        ss.writeState(gs);
        requestFocusInWindow();
    }

    public void load() {
        ss = new SaveState();
        GameState gs = ss.getGS();
        if (!(gs == null)) {
            tfe.setState(gs.getBoard(), gs.getScore());
            status.setText("" + tfe.getScore());
            repaint();
        }
        updateStatus();
        requestFocusInWindow();
    }

    /**
     * Updates the JLabel to reflect the current state of the game.
     */
    private void updateStatus() {
        status.setText("Current Score: " + tfe.getScore());
        int winner = tfe.checkWinner();
        if (winner == 1) {
            status.setText("You win! The final score was " + tfe.getScore());
        } else if (winner == 2) {
            status.setText("You lose! The final score was " + tfe.getScore());
        }
    }

    /**
     * Draws the game board.
     * 
     * There are many ways to draw a game board. This approach
     * will not be sufficient for most games, because it is not
     * modular. All of the logic for drawing the game board is
     * in this method, and it does not take advantage of helper
     * methods. Consider breaking up your paintComponent logic
     * into multiple methods or classes, like Mushroom of Doom.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draws board grid
        g.drawLine(100, 0, 100, 400);
        g.drawLine(200, 0, 200, 400);
        g.drawLine(300, 0, 300, 400);
        g.drawLine(0, 100, 400, 100);
        g.drawLine(0, 200, 400, 200);
        g.drawLine(0, 300, 400, 300);

        // Draws the tiles
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int state = tfe.getCell(i, j);
                if (state > 0) {
                    g.drawString("" + state, 50 + i * 100, 50 + j * 100);
                }
            }
        }
    }

    /**
     * Returns the size of the game board.
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
    }
}
