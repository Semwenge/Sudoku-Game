/**
 * Lab 5: Super Sudoku Solver
 * 
 * This program contains the SudokuPuzzle class. The class's methods can 
 * create a sudoku board, return a textual representation of the current 
 * state of this board, test if the game is over, get, set, and remove 
 * values at particular spots on the board, and check if a desired move 
 * is valid.
 * 
 * @authors Espoir Byishimo and Aryeh Carmi
 */

import java.util.Scanner;
import java.io.File;

public class SudokuPuzzle {

	/*
	 * 2D int array representing puzzle board.
	 */
	private int[][] puzzle = new int[9][9];

	/**
	 * Constructor method of SudokuPuzzle. Fills 2D integer array puzzle with
	 * the initial configuration of the board.
	 * 
	 * @param filename Name of filed holding initial board configuration.
	 */
	public SudokuPuzzle(String filename) {

		// Scanner object.
		Scanner scan = null;

		// Reads the puzzle/solution file
		try {

			scan = new Scanner(new File(filename));
		}

		catch (Exception e) {
			System.out.println("File does not exist!");
		}

		while (scan.hasNext()) {

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {

					puzzle[i][j] = scan.nextInt();

				}
			}
		}
	}

	/**
	 * Creates a textual representation of the current state of the Sudoku board.
	 * 
	 * @return A string containing all the values of the board, separated by spaces.
	 */
	public String toString() {

		// Empty string to hold board representation
		String board = "";

		// Filling this string with each value on board separated by space.
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board += puzzle[i][j];
				board += " ";
			}
			board += "\n"; // New line at end of each row.
		}
		return board;
	}

	/**
	 * Determines if two Sudoku board configurations are the same.
	 * 
	 * @param obj An object that should hold a puzzle configuration.
	 * @return A boolean (true if the boards are the same, false if not)
	 */
	public boolean equals(Object obj) {

		// Checking that object argument is a puzzle
		if (obj instanceof SudokuPuzzle) {

			// Compares the values at each location in both puzzles.
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if ((int) ((SudokuPuzzle) obj).getPuzzleValue(i, j) != puzzle[i][j]) {
						return false;
					}
				}
			}
		}

		else {

			return false;
		}

		return true;
	}

	/**
	 * Modifies the puzzle configuration according to a move. Puts the move's number
	 * attribute at an index in the puzzle array that correlates to the move's row
	 * and column values.
	 * 
	 * @param obj An object that should hold a puzzle configuration.
	 */
	public void setPuzzleValue(SudokuMove move) {

		puzzle[move.getRow()][move.getColumn()] = move.getNumber();
	}

	/**
	 * Returns the number at the specified row and column of the board.
	 * 
	 * @param row    An integer representing desired value's row.
	 * @param column An integer representing desired value's column.
	 * @return The integer value at the specified point on the board.
	 */
	public int getPuzzleValue(int row, int column) {

		return puzzle[row][column];
	}

	/**
	 * Determines whether an intended move is valid–does not involve placing a given
	 * number in a row, column or 3X3 square in which it already occurs.
	 * 
	 * @param move A SudokuMove, representing intended move.
	 * @return A boolean value (true if move is valid, false if not).
	 */
	public boolean isValid(SudokuMove move) {

		// Storing attributes of given move as integer variables.
		int row = move.getRow();
		int column = move.getColumn();
		int number = move.getNumber();

		// Checking that number has not already been placed in row.
		for (int i = 0; i < puzzle.length; i++)
			if (puzzle[row][i] == number) {
				return false;
			}

		// Checking that number has not already been placed in column.
		for (int j = 0; j < puzzle.length; j++) {
			if (puzzle[j][column] == number) {
				return false;
			}
		}

		// Figuring out in which 3X3 square the move would place its
		// number.
		int squareRowStart = row - row % 3;
		int squareColStart = column - column % 3;

		// Checking that the number has not already been placed in that
		// 3X3 square.
		for (int i = squareRowStart; i < squareRowStart + 3; i++) {
			for (int j = squareColStart; j < squareColStart + 3; j++) {
				if (puzzle[i][j] == number) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Determines whether or not Sudoku game is over by checking that no empty
	 * spaces (0s) remain to be filled.
	 * 
	 * @return A boolean value (true if game is over, false if not).
	 */
	public boolean isGameOver() {

		// Looping through the board and checking if any empty (0) spots
		// remain to be filled.
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (puzzle[i][j] == 0) {
					// If an empty spot is found, game is not over.
					return false;
				}
			}
		}
		// If no empty spot found, game is over.
		return true;
	}

	/**
	 * Removes the value at a given space in the Sudoku board configuration by
	 * setting the element at that index in the board array equal to zero.
	 * 
	 * @param row    An integer that represents row of value to be removed.
	 * @param column An integer that represents column of value to be removed.
	 */
	public void clear(int row, int column) {

		puzzle[row][column] = 0;
	}
}
