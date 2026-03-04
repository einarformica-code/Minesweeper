package main;

import java.util.Scanner;

import utils.Board;
import utils.MinesPlacer;
import utils.ClueCalculator;
import utils.BoardDisplay;

public class Minesweeper {
	public static void main(String[] args) {

		char[][] board = new char[Board.ROWS][Board.COLS];
		char[][] visible = new char[Board.ROWS][Board.COLS];

		Board.initBoard(board, visible);
		MinesPlacer.placeMines(board);
		ClueCalculator.calculateClues(board);

		Scanner sc = new Scanner(System.in);
		boolean gameOver = false;

		while (!gameOver) {

            // Display the current visible board to the player
            BoardDisplay.showBoard(visible);

            System.out.print("Enter row (1-" + (Board.ROWS) + "): ");
            int r = (sc.nextInt()-1);

            System.out.print("Enter column (1-" + (Board.COLS) + "): ");
            int c = (sc.nextInt()-1);

            // Check if the input is outside the board limits
            if (r < 0 || r >= Board.ROWS || c < 0 || c >= Board.COLS) {
                System.out.println("Position out of range!");
                continue;
            }
            
            // Check if the cell is already revealed
            if (visible[r][c] != '-') {
                System.out.println("That cell is already revealed!");
                continue;
            }
            
            // If the player hits a mine, the game ends
            if (board[r][c] == '*') {
                System.out.println("BOOM! You stepped on a mine.");
                
                // Reveal the full board so the player can see where all mines were
                BoardDisplay.showBoard(board);
                
                gameOver = true;

            } else {
                // Reveal the selected cell to the player
                visible[r][c] = board[r][c];
             // Check if the player has won
                if (Board.hasWon(board, visible)) {
                    BoardDisplay.showBoard(visible);
                    System.out.println("Congratulations! You revealed all safe cells!");
                    gameOver = true;
                }
            }
        }
		sc.close();

	}

}
