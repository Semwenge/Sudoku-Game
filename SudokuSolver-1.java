/**
 * Lab 5: Super Sudoku Solver
 * 
 * This program contains the SudokuSolver class. It contains a solve method which
 * solves the puzzle, and a helper method for the solve method, which determines
 * the next move to be made in order to solve the puzzle.
 * 
 * @author Espoir Byishimo and Aryeh Carmi
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class SudokuSolver {

	/*
	 * A SudokuPuzzle object representing the board.
	 */
	private SudokuPuzzle board;

	/**
	 * Constructor method. Instantiates the SudokuSolver class with the given board as
	 * its board instance variable.
	 * 
	 * @param board The desired instance of the SudokuPuzzle class to be solved.
	 */
	public SudokuSolver(SudokuPuzzle board) {

		this.board = board;

	}

	/**
	 * Solves the Sudoku puzzle configuration. Does so by creating a stack to store 
	 * valid moves made, and putting valid moves found by determineNextMove method in 
	 * the puzzle (by giving the moves to the setPuzzleValue method from SudokuPuzzle). 
	 * If a dead end is reached, it backtracks–incrementally un-solves the board and 
	 * tries new moves until it finds a way to finish the puzzle.
	 */
	public void solve() {

		// Creates stack to store moves.
		Deque<SudokuMove> moveStack = new ArrayDeque<SudokuMove>();

		// If puzzle is not yet solved.
		while (!board.isGameOver()) {

			// Finds next move.
			SudokuMove nextMove = determineNextMove(1);

			// Start backtracking if next move cannot be found.
			while (nextMove == null) {

				// Deletes previous move from the stack of executed moves.
				SudokuMove lastMove = moveStack.pop();

				// Deletes the last digit that was put in the puzzle.
				board.clear(lastMove.getRow(), lastMove.getColumn());

				// Finds new move to replace the previous move.
				nextMove = determineNextMove(lastMove.getNumber() + 1);

			} // End of backtracking loop.

			// Puts executed moves in the stack.
			moveStack.push(nextMove);

			// Updates puzzle with new move.
			board.setPuzzleValue(nextMove);
		}
	}

	/**
	 * Finds the next move to be made. 
	 * 
	 * @param minVal Minimum value that can be used for the move.
	 * @return Move to be made or null if not found
	 */
	private SudokuMove determineNextMove(int minVal) {

		// Loops through columns.
		for (int i = 0; i < 9; i++) {

			// Loops through rows.
			for (int j = 0; j < 9; j++) {

				// Finds empty spots in puzzle to be solved.
				if (board.getPuzzleValue(i, j) == 0) {

					// Loops through possible digits until a digit that
					// can be placed is found.
					for (int k = minVal; k < 10; k++) {

						// Creates a possible move to be made.
						SudokuMove nextMove = new SudokuMove(i, j, k);

						// Checks if the created move is valid.
						if (board.isValid(nextMove)) {

							// Returns the move if it is valid.
							return nextMove;

						}

					}
					return null; // Returns null if cannot find valid move.
				}

			}
		}
		return null;
	}
}
