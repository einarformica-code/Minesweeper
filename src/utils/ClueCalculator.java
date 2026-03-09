package utils;

public class ClueCalculator {

    public static void calculateClues(char[][] boardWithMines) {
        for (int row = 0; row < Board.ROWS; row++) {
            for (int col = 0; col < Board.COLS; col++) {

                if (boardWithMines[row][col] != '*') {
                    int adjacentMines = 0;

                    for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
                        for (int colOffset = -1; colOffset <= 1; colOffset++) {

                            int neighborRow = row + rowOffset;
                            int neighborCol = col + colOffset;

                            boolean insideBoard =
                                    neighborRow >= 0 && neighborRow < Board.ROWS &&
                                    neighborCol >= 0 && neighborCol < Board.COLS;

                            if (insideBoard && boardWithMines[neighborRow][neighborCol] == '*') {
                                adjacentMines++;
                            }
                        }
                    }
                    boardWithMines[row][col] = (char) (adjacentMines + '0');
                }
            }
        }
    }
}