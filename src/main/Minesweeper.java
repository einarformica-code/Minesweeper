package main;

import java.util.Scanner;

import utils.Functions;

public class MInesweeper {
	public static void main(String[] args) {

		char[][] board = new char[Functions.ROWS][Functions.COLS];
		char[][] visible = new char[Functions.ROWS][Functions.COLS];

		Functions.initBoard(board, visible);
		Functions.placeMines(board);
		Functions.calculateClues(board);

		Scanner sc = new Scanner(System.in);
		boolean gameOver = false;

		while (!gameOver) {

            // Display the current visible board to the player
            Functions.showBoard(visible);

            System.out.print("Enter row (0-" + (Functions.ROWS - 1) + "): ");
            int r = sc.nextInt();

            System.out.print("Enter column (0-" + (Functions.COLS - 1) + "): ");
            int c = sc.nextInt();

            // Check if the input is outside the board limits
            if (r < 0 || r >= Functions.ROWS || c < 0 || c >= Functions.COLS) {
                System.out.println("Position out of range!");
                continue;
            }

            // If the player hits a mine, the game ends
            if (board[r][c] == '*') {
                System.out.println("BOOM! You stepped on a mine.");
                
                // Reveal the full board so the player can see where all mines were
                Functions.showBoard(board);
                
                gameOver = true;

            } else {
                // Reveal the selected cell to the player
                visible[r][c] = board[r][c];

            }
        }
		sc.close();

	}

}
