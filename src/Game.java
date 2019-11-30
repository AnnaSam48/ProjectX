public class Game {

    public static void main(String[] args) {

        Game newGame = new Game();
        UserInputOutput userInputOutput = new UserInputOutput();
        char userMoveInput = userInputOutput.getUserInput();

        do {
            newGame.createTile();

            if (userMoveInput == ('w')) {
                newGame.moveUp();

            } else if (userMoveInput == ('s')) {
                newGame.moveDown();

            } else if (userMoveInput == ('a')) {
                newGame.moveLeft();

            } else if (userMoveInput == ('d')) {
                newGame.moveRight();

            } else {
                if (userMoveInput == ('?')) {
                    throw new IllegalArgumentException("Invalid input, please use 'a', 's', 'd', 'w'");
                }
            }
        } while (userMoveInput != ('?'));
    }

    final int ROWCOUNT = 4;
    final int COLUMNCOUNT = 4;
    int[][] board = new int[ROWCOUNT][COLUMNCOUNT];
    int tilesWithValue = 0;
    boolean boardIsEmpty = true;
    int newTileGenerated = 2;
    UserInputOutput userInputOutput = new UserInputOutput();

    public void createTile() {


        while (boardIsEmpty) {
            int rowIndex = (int) (Math.random() * (ROWCOUNT - 1));
            int columnIndex = (int) (Math.random() * (COLUMNCOUNT - 1));
            if (board[rowIndex][columnIndex] == 0) {
                board[rowIndex][columnIndex] = newTileGenerated;
                tilesWithValue++;
                if (tilesWithValue == 16) {
                    boardIsEmpty = false;
                    userInputOutput.endGame();
                    //add method from UserInputOutput Class with end game message and final score
                }
            }
        }
    }

    private void moveVerticaly(int currentRow, int currentCol, boolean verticalMovement) {

        if (board[tilesWithValue][currentCol] == 0 ||
                board[tilesWithValue][currentCol] == board[currentRow][currentCol]) {
            if (currentRow > tilesWithValue ||
                    (verticalMovement && (tilesWithValue > currentRow))) {
                board[tilesWithValue][currentCol] += board[currentRow][currentCol];
                board[currentRow][currentCol] = 0;
            }
        } else {
            if (verticalMovement) {
                tilesWithValue--;
            } else {
                tilesWithValue++;
            }
            moveVerticaly(currentRow, currentCol, verticalMovement);
        }
    }

    private void moveHorizontaly(int currentRow, int currentCol, boolean verticalMovement) {

        if (board[currentRow][tilesWithValue] == 0 ||
                board[currentRow][tilesWithValue] == board[currentRow][currentCol]) {
            if (currentCol > tilesWithValue ||
                    (verticalMovement && (tilesWithValue > currentCol))) {
                board[currentRow][tilesWithValue] += board[currentRow][currentCol];
                board[currentRow][currentCol] = 0;
            }
        } else {
            if (verticalMovement) {
                tilesWithValue--;
            } else {
                tilesWithValue++;
            }
            moveHorizontaly(currentRow, currentCol, verticalMovement);
        }
    }

    public void moveUp() {
        for (int i = 0; i < COLUMNCOUNT; i++) {
            for (int j = 0; j < ROWCOUNT; j++) {
                if (board[j][i] != 0) {
                    if (tilesWithValue <= j) {
                        moveVerticaly(j, i, false);
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
                        moveVerticaly(j, i, true);
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
                        moveHorizontaly(i, j, false);
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
                        moveHorizontaly(i, j, true);
                    }
                }
            }
        }
    }
}
//
//                if((userInput.equals('w')||(userInput.equals('a')) || (userInput.equals('s') ||(userInput.equals('d'))){
//                    isValid = true;
//                    return userInput;