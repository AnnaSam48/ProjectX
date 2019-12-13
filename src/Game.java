
import java.util.Random;

public class Game {

    final int ROWCOUNT = 4;
    final int COLUMNCOUNT = 4;
    int[][] board = new int[ROWCOUNT][COLUMNCOUNT];
    int tilesWithValue = 0;
    int score =0;
    int sumValue =0;
    UserInputOutput userInputOutput = new UserInputOutput();
   // BoardPrinter boardPrinter = new BoardPrinter();

    public void createTile() {
        if (!hasEmptyCell()) {
            return;
        }

        while (true) {
            int rowIndex = (int) (Math.random() * (ROWCOUNT));
            int columnIndex = (int) (Math.random() * (COLUMNCOUNT));
            if (board[rowIndex][columnIndex] == 0) {
                board[rowIndex][columnIndex] = generateRandom();
                tilesWithValue++;
                if (!isAbleToMove()) {
                   // createTile();
                    // boardPrinter.printBoard(board, getScore());
                    userInputOutput.endGame(getScore());
                }
                return;
            }
        }
    }

    private int generateRandom() {
        return new Random().nextInt(10) == 7 ? 4 : 2;
    }

    private boolean isAbleToMove() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    return true;
                }
            }
        }

        for (int i = 0; i < board.length-1; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == board[j][i + 1]) {
                    return true;
                }
            }
        }

        return hasEmptyCell();
    }

    private boolean hasEmptyCell() {
        boolean hasEmptyCell = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == 0) {
                     hasEmptyCell = true;
                }
            }
        }
        return hasEmptyCell;
    }

    private int moveVertically(int currentRow, int currentCol, boolean verticalMovement) {

        if (board[tilesWithValue][currentCol] == 0 ||
                board[tilesWithValue][currentCol] == board[currentRow][currentCol]) {
            if (currentRow > tilesWithValue ||
                    (verticalMovement && (tilesWithValue > currentRow))) {
                sumValue =board[tilesWithValue][currentCol]*2;
                board[tilesWithValue][currentCol] += board[currentRow][currentCol];
                board[currentRow][currentCol] = 0;
                score += sumValue;
            }
        } else {
            if (verticalMovement) {
                tilesWithValue--;
            } else {
                tilesWithValue++;
            }
            moveVertically(currentRow, currentCol, verticalMovement);
        }
        return score;
    }

    private int moveHorizontally(int currentRow, int currentCol, boolean verticalMovement) {

        if (board[currentRow][tilesWithValue] == 0 ||
                board[currentRow][tilesWithValue] == board[currentRow][currentCol]) {
            if (currentCol > tilesWithValue ||
                    (verticalMovement && (tilesWithValue > currentCol))) {
                sumValue = board[currentRow][tilesWithValue]*2;
                board[currentRow][tilesWithValue] += board[currentRow][currentCol];
                board[currentRow][currentCol] = 0;
                score +=  sumValue;

            }
        } else {
            if (verticalMovement) {
                tilesWithValue--;
            } else {
                tilesWithValue++;
            }
            moveHorizontally(currentRow, currentCol, verticalMovement);
        }
        return score;
    }

    public void moveUp() {
        for (int i = 0; i < COLUMNCOUNT; i++) {
            tilesWithValue =0;
            for (int j = 0; j < ROWCOUNT; j++) {
                // if not zero, tries to add the digits
                if (board[j][i] != 0) {
                    // when space, it moves the numbers as far as it can and adds
                    if (tilesWithValue <= j) {
                        moveVertically(j, i, false);
                    }
                }
            }
        }
    }
    public void moveDown() {
        for (int i = 0; i < COLUMNCOUNT; i++) {
            tilesWithValue = ROWCOUNT - 1;
            for (int j = tilesWithValue; j >= 0; j--) {
                if (board[j][i] != 0) {
                    if (tilesWithValue >= j) {
                        moveVertically(j, i, true);
                    }
                }
            }
        }
    }

    public void moveLeft() {
        for (int i = 0; i < ROWCOUNT; i++) {
            tilesWithValue = 0;
            for (int j = 0; j < COLUMNCOUNT; j++) {
                if (board[i][j] != 0) {
                    if (tilesWithValue <= j) {
                        moveHorizontally(i, j, false);
                    }
                }
            }
        }
    }

    public void moveRight() {
        for (int i = 0; i < ROWCOUNT; i++) {
            tilesWithValue = COLUMNCOUNT - 1;
            for (int j = tilesWithValue; j >= 0; j--) {
                if (board[i][j] != 0) {
                    if (tilesWithValue >= j) {
                        moveHorizontally(i, j, true);
                    }
                }
            }
        }

    }
    public void printBoard(){
        String output = "";
        for (int i = 0; i < ROWCOUNT; i++) {
            String rowOutput = "";
            for (int j = 0; j < COLUMNCOUNT; j++) {
                rowOutput += board[i][j] + " ";
            }
            rowOutput += "\n";
            output += rowOutput;
        }
        System.out.println(output);
    }
    public int getScore(){
        return score;
    }

    public static void main(String[] args) {


        BoardPrinter boardPrinter = new BoardPrinter();
        UserInputOutput userInputOutput = new UserInputOutput();
        Game newGame = new Game();
        newGame.createTile();
        boardPrinter.printBoard(newGame.board, newGame.getScore());
        String userMoveInput = userInputOutput.getUserInput();

        while (!userMoveInput.equals("?")) {

            if (userMoveInput.equals("w")) {
                newGame.moveUp();

            } else if (userMoveInput.equals("s")) {
                newGame.moveDown();

            } else if (userMoveInput.equals("a")) {
                newGame.moveLeft();

            } else if (userMoveInput.equals("d")) {
                newGame.moveRight();

            } else {
                System.out.println("Invalid input, please use 'a', 's', 'd', 'w'");
            }

            newGame.createTile();
            boardPrinter.printBoard(newGame.board, newGame.getScore());
            userMoveInput = userInputOutput.getUserInput();

        }
    }
}
