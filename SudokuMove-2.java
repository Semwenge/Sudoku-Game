/**
 * Lab 5: Super Sudoku Solver
 * 
 * This program contains the SudokuMove class. The class holds the position
 * and value of an intended move and provides getter methods to view these
 * attributes individually, and a toString method to view a textual representation
 * of all the move's attributes.
 * 
 * @authors Espoir Byishimo and Aryeh Carmi
 */

public class SudokuMove {
	
	/*
	 * The row of intended move.
	 */
	private int row;
	
	/*
	 * The column of intended move.
	 */
	private int column;
	
	/*
	 * The number of intended move.
	 */
	private int number;

	/**
	 * Constructor method of SudokuMove. Constructs a move of with intended
	 * row and column indices of intended location and number to be placed
	 * in said location.
	 * 
	 * @param row Row in which number is to be placed by move.
	 * @param column Column in which number is to be placed by move.
	 * @param number Number that is to be placed at specified location.
	 */
	public SudokuMove(int row, int column, int number) {
		
		this.row = row;
		this.column = column;
		this.number = number;
	}

	/**
	 * A getter method to return the row attribute of move.
	 * 
	 * @return An integer representing row attribute.
	 */
	public int getRow() {

		return row;
	}

	/**
	 * A getter method to return the column attribute of move.
	 * 
	 * @return An integer representing column attribute.
	 */
	public int getColumn() {

		return column;
	}
	
	/**
	 * A getter method to return the number attribute of move.
	 * 
	 * @return An integer representing number attribute.
	 */
	public int getNumber() {

		return number;
	}

	/**
	 * Returns a textual representation of the move.
	 * 
	 * @return A String that contains the row, column and value
	 * 		 of intended move.
	 */
	public String toString() {
		
		// Empty string to hold row, column, and value of move.
		String move = "";
		
		// Filling the string with the attributes.
		move += row;
		move += " ";
		move += column;
		move += " ";
		move += number;

		return move;
	}
}
