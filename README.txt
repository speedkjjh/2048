=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 120 Game Project README
PennKey: spedkjjh
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

- List the four core concepts, the features they implement, and why each feature
  is an appropriate use of the concept. Incorporate the feedback you got after
  submitting your proposal.

  1. 2D Arrays implements the actual board of the game, represented with 0 for empty spaces and 2, 4, etc. for
  the different values. The array naturally represents the board of an 2048 game, since it is a 4 by 4 field
  with only one value possible in each space.

  2. File I/O was used for a save/load function for game states. Storing game states as a file allows the
  player to save a state, close the game, and load it at a later time, which is not possible when stored on memory.

  3. Maps and Collections were used, specifically LinkedLists to allow an Undo feature on the game.
  Saving the board and the score as a LinkedList allows the game to keep track of an unspecified number of
  moves in history, and return to the previous state as many times as necessary.

  4. JUnit Testable Component was used to test the fundamental game outside the GUI components.
  The basic game encapsulated in TwentyFortyEight.java is independent of the controller and the view, and
  is tested for functionality and edge cases, since it is difficult to test all necessary scenarios
  just by playing the game.

=========================
=: Your Implementation :=
=========================

- Provide an overview of each of the classes in your code, and what their
  function is in the overall game.

TwentyFortyEight holds the code for the basic game of 2048.

RunTwentyFortyEight implements the runnable and creates JPanels and others for the game.

GameBoard creates the game and the visuals, and acts to take the inputs from the player
and display it correctly on the game board.

GameTest holds the JUnit Tests for the game logic held in TwentyFortyEight.

SaveState allows the game to save and load different game states
using File I/O

GameState holds a class of the game board and the score to deal with
individual game states for saving and loading purposes.

- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?

  No

- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?

I think the design is functional but suboptimal. I created the class GameState to hold both
the board array and the score, and it could have been used in other places in the code to make
it more efficient and clean. The private state is well-encapsulated, and functionalities are
separated logically.

========================
=: External Resources :=
========================

- Cite any external resources (images, tutorials, etc.) that you may have used 
  while implementing your game.

I used https://play2048.co/ to learn the specific rules and behaviors within the
2048 game.