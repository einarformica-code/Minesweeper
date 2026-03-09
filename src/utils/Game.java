package utils;

import java.util.Scanner;

public class Game {
	public static void initGame (char[][] boardWithMines, char[][] boardVisibleForPlayer) {

		Board.initBoard(boardWithMines, boardVisibleForPlayer);
		MinesPlacer.placeMines(boardWithMines);
		ClueCalculator.calculateClues(boardWithMines);

	}

	public static boolean runGame(char[][] boardWithMines, char[][] boardVisibleForPlayer) {
		Scanner scanner = new Scanner(System.in);

		boolean gameOver = false;

		while (!gameOver) {

            // Display the current visible board to the player
            BoardDisplay.showBoard(boardVisibleForPlayer);

            System.out.print("Enter row (1-" + (Board.ROWS) + "): ");
            int row = (scanner.nextInt()-1);

            System.out.print("Enter column (1-" + (Board.COLS) + "): ");
            int column = (scanner.nextInt()-1);

            // Check if the input is outside the board limits
            if (row < 0 || row >= Board.ROWS || column < 0 || column >= Board.COLS) {
                System.out.println("Position out of range!");
                continue;
            }
            
            // Check if the cell is already revealed
            if (boardVisibleForPlayer[row][column] != '-') {
                System.out.println("That cell is already revealed!");
                continue;
            }
            
            // If the player hits a mine, the game ends
            if (boardWithMines[row][column] == '*') {
                System.out.println("BOOM! You stepped on a mine.");
                
                // Reveal the full board so the player can see where all mines were
                BoardDisplay.showBoard(boardWithMines);
                
                gameOver = true;

            } else {
                // Reveal the selected cell to the player
                boardVisibleForPlayer[row][column] = boardWithMines[row][column];
             // Check if the player has won
                if (Board.hasWon(boardWithMines, boardVisibleForPlayer)) {
                    BoardDisplay.showBoard(boardVisibleForPlayer);
                    System.out.println("Congratulations! You revealed all safe cells!");
                    gameOver = true;
                }
            }
        }
		scanner.close();
		return gameOver;
	}
	
}
