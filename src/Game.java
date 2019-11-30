import java.util.Random;

public class Game {
    public static void main(String[] args) {


        final int rowCount = 4;
        final int columnCount = 4;
        int[][] board = new int[rowCount][columnCount];
        int tilesWithValue = 0;
        boolean gameIsFinished = false;
        int newTileGenerated = 2;


            while (!gameIsFinished) {
                int rowIndex = (int) (Math.random() * (rowCount));
                int columnIndex = (int) (Math.random() * (columnCount));
                if (board[rowIndex][columnIndex] == 0) {
                    board[rowIndex][columnIndex] = newTileGenerated;
                    tilesWithValue++;
                    System.out.print(board[rowIndex][columnIndex]);
                    if (tilesWithValue == 16) {
                        gameIsFinished = true;
                    }
                }
            }


    }
}
