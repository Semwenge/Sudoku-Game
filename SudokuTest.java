/**
 * Lab 5: Super Sudoku Solver
 * 
 * The program contains the SudokuTest class. The method holds the main method, 
 * which executes Lab 5 using the SudokuPuzzle, SudokuMove, and SudokuSolver classes.
 * 
 * @authors Espoir Byishimo and Aryeh Carmi
 */

import java.util.Scanner;

public class SudokuTest {

	/**
	 * Main method, which prompts the user to enter a file containing an 
	 * unsolved Sudoku puzzle, as well as (optionally) a file containing 
	 * the solution to that puzzle, then prints out unsolved puzzle, solves
	 * it, prints out the solved puzzle, and, assuming a solution file was 
	 * entered, verifies that the found solution is correct.
	 */
	public static void main(String[] args) {
		
		// Scanner object 
		Scanner input = new Scanner(System.in);

		// Acquires name of unsolved puzzle file.
		System.out.println("Enter filename of puzzle: ");
		String unsolvedFilename = input.nextLine();
		
		// SudokuPuzzle object containing the unsolved puzzle.
		SudokuPuzzle startPuzzle = new SudokuPuzzle(unsolvedFilename);

		// (Optionally) acquires name of puzzle solution file.
		System.out.println("(Optional) Enter filename of solution: ");
		String solutionFilename = input.nextLine();
		System.out.println();

		// If no solution file was given
		if (solutionFilename.isEmpty()) {
			// Print starting puzzle configuration
			System.out.println("Starting puzzle: ");
			System.out.println();
			System.out.println(startPuzzle.toString());
			
			// New SudokuSolver object built using unsolved puzzle.
			SudokuSolver solver = new SudokuSolver(startPuzzle);
			solver.solve(); // Solve puzzle.
			
			// SudokuPuzzle variable holding the solved configuration.
			SudokuPuzzle solvedPuzzle = startPuzzle;
			
			// Prints solved puzzle configuration.
			System.out.println("Solved Puzzle: ");
			System.out.println();
			System.out.println(solvedPuzzle.toString());
		}
		
		// If a solution file was given, repeats the process, but compares
		// to given solution, and prints verification.
		else {
			// Same as above.
			System.out.println("Starting puzzle: ");
			System.out.println();
			System.out.println(startPuzzle.toString());
			
			// SudokuPuzzle object containing the given solution puzzle.
			SudokuPuzzle solutionPuzzle = new SudokuPuzzle(solutionFilename);
			
			// Same as above.
			SudokuSolver solver = new SudokuSolver(startPuzzle);
			solver.solve();
			SudokuPuzzle solvedPuzzle = startPuzzle;
			
			System.out.println("Solved Puzzle:");
			System.out.println();
			System.out.println(solvedPuzzle.toString());
			
			// Compares and prints whether the given solution matched the 
			// solved puzzle or not.
			if (!solvedPuzzle.equals(solutionPuzzle)) {
				System.out.println("Solution is NOT correct!");
			} 
			else {
				System.out.println("Solution is correct!");
			}
		}
		input.close();
	}
}