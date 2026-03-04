package utils;

public class Board {

    public static final int ROWS = 5;
    public static final int COLS = 5;
    public static final int MINES = 4;

    public static void initBoard(char[][] board, char[][] visible) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = '0';
                visible[i][j] = '-';
            }
        }
    }
    
    public static boolean hasWon(char[][] board, char[][] visible) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                // If a cell is not a mine and is still hidden, the player has not won yet
            	if (board[i][j] != '*' && visible[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
    
}