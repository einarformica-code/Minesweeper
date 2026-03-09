package utils;

public class Board {

    public static final int ROWS = 5;
    public static final int COLS = 5;
    public static final int MINES = 4;

    public static void initBoard(char[][] boardWithMines, char[][] boardVisibleForPlayer) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                boardWithMines[i][j] = '0';
                boardVisibleForPlayer[i][j] = '-';
            }
        }
    }
    
    public static boolean hasWon(char[][] boardWithMines, char[][] boardVisibleForPlayer) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                // If a cell is not a mine and is still hidden, the player has not won yet
            	if (boardWithMines[i][j] != '*' && boardVisibleForPlayer[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
    
}