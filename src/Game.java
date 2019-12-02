public class Game {


    public static void main(String[] args) {

        Game newGame = new Game();
        newGame.createTile();
        newGame.printBoard();

        UserInputOutput userInputOutput = new UserInputOutput();

 //       userInputOutput.startUpText();
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
                if (userMoveInput.equals("?")) {
                    throw new IllegalArgumentException("Invalid input, please use 'a', 's', 'd', 'w'");
                }
            }

            newGame.createTile();
            newGame.printBoard();

            userMoveInput = userInputOutput.getUserInput();
        }
    }

    final int ROWCOUNT = 4;
    final int COLUMNCOUNT = 4;
    int[][] board = new int[ROWCOUNT][COLUMNCOUNT];
    int tilesWithValue = 0;
    int newTileGenerated = 2;
    UserInputOutput userInputOutput = new UserInputOutput();

    public void createTile() {
        
        while (true) {
            int rowIndex = (int) (Math.random() * (ROWCOUNT - 1));
            int columnIndex = (int) (Math.random() * (COLUMNCOUNT - 1));
            if (board[rowIndex][columnIndex] == 0) {
                board[rowIndex][columnIndex] = newTileGenerated;
                tilesWithValue++;
                    //add method from UserInputOutput Class with end game message and final score
                return;
            }
        }
    }

    private void moveVertically(int currentRow, int currentCol, boolean verticalMovement) {

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
            moveVertically(currentRow, currentCol, verticalMovement);
        }
    }

    private void moveHorizontally(int currentRow, int currentCol, boolean verticalMovement) {

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
            moveHorizontally(currentRow, currentCol, verticalMovement);
        }
    }

    public void moveUp() {
        for (int i = 0; i < COLUMNCOUNT; i++) {
            for (int j = 0; j < ROWCOUNT; j++) {
                if (board[j][i] != 0) {
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
}
//
//                if((userInput.equals('w')||(userInput.equals('a')) || (userInput.equals('s') ||(userInput.equals('d'))){
//                    isValid = true;
//                    return userI/////nput;