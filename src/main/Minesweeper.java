package main;

import utils.Board;
import utils.Game;

public class Minesweeper {
	public static void main(String[] args) {
		
		char[][] boardWithMines = new char[Board.ROWS][Board.COLS];
		char[][] boardVisibleForPlayer = new char[Board.ROWS][Board.COLS];

		Game.initGame(boardWithMines, boardVisibleForPlayer);

		Game.runGame(boardWithMines, boardVisibleForPlayer);
	}

}
