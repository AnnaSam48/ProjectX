public class Game {
//    public static void main(String[] args) {
//
//
        final int ROWCOUNT = 4;
        final int COLUMNCOUNT = 4;
        int[][] board = new int[ROWCOUNT][COLUMNCOUNT];
        int tilesWithValue = 0;
        boolean boardIsEmpty = true;
        int newTileGenerated = 2;
        Game newGame = new Game();
        UserInputOutput userInputOutput = new UserInputOutput();
        char userMoveInput = userInputOutput.getUserInput();
//
       do {
            newGame.createTile();

           if (userMoveInput == ('w')) {
              newGame.moveUp();

            } else if (userMoveInput ==('s')) {
                newGame.moveDown();

            } else if (userMoveInput ==('a')) {
                newGame.moveLeft();

            } else if (userMoveInput ==('d')) {
                newGame.moveRight();

            } else {
               if(userMoveInput == ('?')){
            throw new IllegalArgumentException("Invalid input, please use 'a', 's', 'd', 'w'");
          }
       }while(userMoveInput!=('?'));
//
//
////
////                if((userInput.equals('w')||(userInput.equals('a')) || (userInput.equals('s') ||(userInput.equals('d'))){
////                    isValid = true;
//                    return userInput;
////
//        }

            public int createTile(){
                while (boardIsEmpty) {
                int rowIndex = (int) (Math.random() * (ROWCOUNT -1));
                int columnIndex = (int) (Math.random() * (COLUMNCOUNT -1));
                if (board[rowIndex][columnIndex] == 0) {
                    board[rowIndex][columnIndex] = newTileGenerated;
                    tilesWithValue++;
                    if (tilesWithValue == 16) {
                        boardIsEmpty = false;
                        userInputOutput.endGame();
                        //add method from UserInputOutput Class with end game message and final score
                    }
//                }
//            }
            }
//


    //}
}
