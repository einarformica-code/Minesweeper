package utils;

public class BoardDisplay {

    public static void showBoard(char[][] grid) {
        System.out.println("Board:");
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLS; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}