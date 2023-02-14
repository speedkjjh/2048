package org.cis120.TwentyFortyEight;

/*
 * CIS 120 HW09 - TicTacToe Demo
 * (c) University of Pennsylvania
 * Created by Bayley Tuch, Sabrina Green, and Nicolas Corona in Fall 2020.
 */

import javax.swing.*;
import java.awt.*;

/**
 * This class sets up the top-level frame and widgets for the GUI.
 * 
 * This game adheres to a Model-View-Controller design framework. This
 * framework is very effective for turn-based games. We STRONGLY
 * recommend you review these lecture slides, starting at slide 8,
 * for more details on Model-View-Controller:
 * https://www.seas.upenn.edu/~cis120/current/files/slides/lec37.pdf
 * 
 * In a Model-View-Controller framework, Game initializes the view,
 * implements a bit of controller functionality through the reset
 * button, and then instantiates a GameBoard. The GameBoard will
 * handle the rest of the game's view and controller functionality, and
 * it will instantiate a TicTacToe object to serve as the game's model.
 */
public class RunTwentyFortyEight implements Runnable {
    public void run() {
        // NOTE: the 'final' keyword denotes immutability even for local variables.

        // Top-level frame in which game components live
        final JFrame frame = new JFrame("2048");
        frame.setLocation(300, 300);

        // Instructions window
        final JFrame instructionsFrame = new JFrame();
        instructionsFrame.setLocation(300, 200);

        // Actual instructions
        final JLabel space = new JLabel(" ");
        final JLabel space2 = new JLabel(" ");
        final JLabel instructions = new JLabel(
                "   Use your arrow keys to move all the numbers in a direction."
                + " When two of the same numbers collide, " +
                        "they add up and give you points. Win by making a 2048 "
                + " on the board, and you lose when no moves are possible.   ");
        instructionsFrame.add(space, BorderLayout.NORTH);
        instructionsFrame.add(space2, BorderLayout.SOUTH);
        instructionsFrame.add(instructions, BorderLayout.CENTER);

        // Status panel
        final JPanel status_panel = new JPanel();
        frame.add(status_panel, BorderLayout.SOUTH);
        final JLabel status = new JLabel("Setting up...");
        status_panel.add(status);

        // Game board
        final GameBoard board = new GameBoard(status);
        frame.add(board, BorderLayout.CENTER);

        // Reset button
        final JPanel control_panel = new JPanel();
        frame.add(control_panel, BorderLayout.NORTH);

        // Note here that when we add an action listener to the reset button, we
        // define it as an anonymous inner class that is an instance of
        // ActionListener with its actionPerformed() method overridden. When the
        // button is pressed, actionPerformed() will be called.
        final JButton reset = new JButton("Reset");
        reset.addActionListener(e -> board.reset());
        control_panel.add(reset);

        // Undo button
        final JPanel control_panel2 = new JPanel();
        frame.add(control_panel2, BorderLayout.SOUTH);
        final JButton undo = new JButton("Undo");
        undo.addActionListener(e -> board.undo());
        control_panel.add(undo);

        final JPanel control_panel3 = new JPanel();
        frame.add(control_panel3, BorderLayout.EAST);
        final JButton save = new JButton("Save");
        save.addActionListener(e -> board.save());
        control_panel.add(save);

        final JPanel control_panel4 = new JPanel();
        frame.add(control_panel4, BorderLayout.WEST);
        final JButton load = new JButton("Load");
        load.addActionListener(e -> board.load());
        control_panel.add(load);

        // Put the frame on the screen
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Put the instructions frame on the screen
        instructionsFrame.pack();
        instructionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        instructionsFrame.setVisible(true);

        // Start the game
        board.reset();
    }
}