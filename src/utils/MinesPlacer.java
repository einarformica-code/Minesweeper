package utils;

import java.util.Random;

public class MinesPlacer {

    public static void placeMines(char[][] boardWithMines) {
        Random rand = new Random();
        int placed = 0;

        while (placed < Board.MINES) {
            int r = rand.nextInt(Board.ROWS);
            int c = rand.nextInt(Board.COLS);

            if (boardWithMines[r][c] != '*') {
                boardWithMines[r][c] = '*';
                placed++;
            }
        }
    }
}